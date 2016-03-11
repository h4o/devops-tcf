package fr.unice.polytech.isa.tcf.modules.order;


import fr.unice.polytech.isa.tcf.modules.order.entities.Order;

import javax.ejb.Local;

@Local
public interface OrderProcessing {

	void process(Order order);

}
