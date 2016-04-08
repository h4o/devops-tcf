package integration;

import arquillian.AbstractTCFTest;
import fr.unice.polytech.isa.tcf.modules.business.entities.*;
import fr.unice.polytech.isa.tcf.modules.business.exceptions.AlreadyExistingCustomerException;
import fr.unice.polytech.isa.tcf.modules.business.exceptions.PaymentException;
import fr.unice.polytech.isa.tcf.modules.customer.CustomerFinder;
import fr.unice.polytech.isa.tcf.modules.customer.CustomerRegistration;
import fr.unice.polytech.isa.tcf.modules.order.CartModifier;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class ITCart extends AbstractTCFTest {
    @EJB private CartModifier cart;
    private Set<Item> items;
    @EJB private CustomerRegistration registration;
    @EJB private CustomerFinder finder;

    @Before
    public void setUpContext() {
        memory.flush();
        items = new HashSet<>();
        items.add(new Item(Cookies.CHOCOLALALA, 3));
        items.add(new Item(Cookies.DARK_TEMPTATION, 2));
    }
    @Test
    public void integrationBetweenCartAndCustomer() throws PaymentException, AlreadyExistingCustomerException {
        // Enregistrement
        String name = "Bobby";
        registration.register(name, "1234-896983");
        Customer retrieved = finder.findByName(name).get();
        assertEquals(retrieved.getName(), name);
        // Cart
        for (Item i : items) {
            cart.add(retrieved, i);
        }
        assertEquals(cart.contents(retrieved), items);
        assertTrue(retrieved.getOrders().isEmpty());
        cart.validate(retrieved);
        assertTrue(!retrieved.getOrders().isEmpty());
    }
}
