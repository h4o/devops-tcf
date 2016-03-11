package fr.unice.polytech.isa.tcf.modules.order.components;

import fr.unice.polytech.isa.tcf.modules.order.OrderProcessing;
import fr.unice.polytech.isa.tcf.modules.order.Tracker;
import fr.unice.polytech.isa.tcf.modules.order.entities.Order;
import fr.unice.polytech.isa.tcf.modules.order.entities.OrderStatus;
import fr.unice.polytech.isa.tcf.modules.order.exceptions.UnknownOrderId;
import fr.unice.polytech.isa.tcf.modules.database.Database;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class KitchenBean implements OrderProcessing, Tracker {

	@EJB private Database memory;

	@Override
	public void process(Order order) {
		if (order.getCustomer().getName().contains("p")) {
			order.setStatus(OrderStatus.IN_PROGRESS);
		} else if (order.getCustomer().getName().contains("r")) {
			order.setStatus(OrderStatus.READY);
		}
		memory.getOrders().put(order.getId(), order);
	}

	@Override
	public OrderStatus status(String orderId) throws UnknownOrderId {
		Order order = memory.getOrders().get(orderId);
		if (order == null)
			throw new UnknownOrderId(orderId);
		return  order.getStatus();
	}
}
