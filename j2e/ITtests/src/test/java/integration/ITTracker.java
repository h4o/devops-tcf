package integration;

import arquillian.AbstractTCFTest;
import fr.unice.polytech.isa.tcf.modules.business.entities.*;
import fr.unice.polytech.isa.tcf.modules.business.exceptions.AlreadyExistingCustomerException;
import fr.unice.polytech.isa.tcf.modules.business.exceptions.PaymentException;
import fr.unice.polytech.isa.tcf.modules.business.exceptions.UnknownOrderId;
import fr.unice.polytech.isa.tcf.modules.customer.CustomerFinder;
import fr.unice.polytech.isa.tcf.modules.customer.CustomerRegistration;
import fr.unice.polytech.isa.tcf.modules.kitchen.OrderProcessing;
import fr.unice.polytech.isa.tcf.modules.kitchen.Tracker;
import fr.unice.polytech.isa.tcf.modules.order.Payment;
import org.jboss.arquillian.junit.Arquillian;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Arquillian.class)
public class ITTracker  extends AbstractTCFTest {

    @EJB private Payment cashier;
    @EJB private OrderProcessing orderProc;
    @EJB private CustomerRegistration registration;
    @EJB private CustomerFinder finder;
    @EJB private Tracker tracker;
    private Set<Item> items;

    @Before
    public void setUpContext() {
        memory.flush();
        items = new HashSet<>();
        items.add(new Item(Cookies.CHOCOLALALA, 3));
        items.add(new Item(Cookies.DARK_TEMPTATION, 2));
    }

    @Test
    public void integrationBetweenCustomerBAndTracker() throws AlreadyExistingCustomerException, PaymentException, UnknownOrderId {
        String name = "Bobbyp";
        registration.register(name, "1234-896983");
        Customer retrieved = finder.findByName(name).get();
        assertTrue(retrieved.getOrders().isEmpty());
        Order orderDeBobby = new Order(retrieved, items);
        memory.getOrders().put(name, orderDeBobby);
        orderProc.process(orderDeBobby);
        assertEquals(tracker.status(orderDeBobby.getId()), OrderStatus.IN_PROGRESS);
        assertEquals(tracker.status(orderDeBobby.getId()), memory.getOrders().get(orderDeBobby.getId()).getStatus());
    }

    @Test
    public void integrationBetweenCustomerRAndTracker() throws AlreadyExistingCustomerException, PaymentException, UnknownOrderId {
        String name = "rBobby";
        registration.register(name, "1234-896983");
        Customer retrieved = finder.findByName(name).get();
        assertTrue(retrieved.getOrders().isEmpty());
        Order orderDeBobby = new Order(retrieved, items);
        memory.getOrders().put(name, orderDeBobby);
        orderProc.process(orderDeBobby);
        assertEquals(orderDeBobby.getCustomer().getName(), name);
        assertEquals(tracker.status(orderDeBobby.getId()), OrderStatus.READY);
        assertEquals(tracker.status(orderDeBobby.getId()), memory.getOrders().get(orderDeBobby.getId()).getStatus());
   }


}
