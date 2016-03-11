package fr.unice.polytech.isa.tcf.modules.customer;

import fr.unice.polytech.isa.tcf.modules.customer.entities.Customer;

import javax.ejb.Local;
import java.util.Optional;

@Local
public interface CustomerFinder {

	Optional<Customer> findByName(String name);

}

