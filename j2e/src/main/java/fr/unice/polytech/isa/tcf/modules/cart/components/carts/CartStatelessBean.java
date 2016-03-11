package fr.unice.polytech.isa.tcf.modules.cart.components.carts;

import fr.unice.polytech.isa.tcf.modules.cart.components.CartBean;
import fr.unice.polytech.isa.tcf.modules.customer.entities.Customer;
import fr.unice.polytech.isa.tcf.modules.cart.entities.Item;
import fr.unice.polytech.isa.tcf.modules.database.Database;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.*;


@Stateless(name = "cart-stateless")
public class CartStatelessBean extends CartBean {

	@EJB
	private Database memory;

	@Override
	public boolean add(Customer c, Item item) {
		memory.getCarts().put(c, updateCart(c, item));
		return true;
	}

	@Override
	public Set<Item> contents(Customer c) {
		return memory.getCarts().getOrDefault(c, new HashSet<Item>());
	}

}
