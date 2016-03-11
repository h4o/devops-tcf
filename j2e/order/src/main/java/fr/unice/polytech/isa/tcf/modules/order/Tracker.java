package fr.unice.polytech.isa.tcf.modules.order;

import fr.unice.polytech.isa.tcf.modules.order.entities.OrderStatus;
import fr.unice.polytech.isa.tcf.modules.order.exceptions.UnknownOrderId;

import javax.ejb.Local;

@Local
public interface Tracker {

	OrderStatus status(String orderId) throws UnknownOrderId;

}
