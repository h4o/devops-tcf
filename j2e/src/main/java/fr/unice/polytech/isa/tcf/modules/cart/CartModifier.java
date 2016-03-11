package fr.unice.polytech.isa.tcf.modules.cart;

import fr.unice.polytech.isa.tcf.modules.customer.entities.Customer;
import fr.unice.polytech.isa.tcf.modules.cart.entities.Item;
import fr.unice.polytech.isa.tcf.modules.order.exceptions.PaymentException;

import javax.ejb.Local;
import java.util.Set;

@Local
public interface CartModifier {

	boolean add(Customer c, Item item);

	boolean remove(Customer c, Item item);

	Set<Item> contents(Customer c);

	String validate(Customer c) throws PaymentException;

}
