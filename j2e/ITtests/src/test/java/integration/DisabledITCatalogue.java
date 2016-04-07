/*package integration;

import arquillian.AbstractTCFTest;
import fr.unice.polytech.isa.tcf.modules.business.entities.Cookies;
import fr.unice.polytech.isa.tcf.modules.business.entities.Customer;
import fr.unice.polytech.isa.tcf.modules.business.entities.Item;
import fr.unice.polytech.isa.tcf.modules.business.entities.Order;
import fr.unice.polytech.isa.tcf.modules.business.exceptions.PaymentException;
import fr.unice.polytech.isa.tcf.modules.order.CartModifier;
import fr.unice.polytech.isa.tcf.modules.webservicesmodule.CatalogueExploration;
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
public class DisabledITCatalogue extends AbstractTCFTest {
    @EJB private CatalogueExploration catalogue;
    @EJB private CartModifier cart;
    private Customer test;
    @Before
    public void setUpContext() {
        memory.flush();
        test = new Customer("BobbyTest","Bobby");
        memory.getCustomers().put("BobbyTest",test);

    }

    @Test
    public void integrationCatalogueOrder() throws PaymentException {
        // On va vérifier que tout les cookies dans le catalogue soient disponibles à l'achat
        // et que la transition entre le retour de catalogue et l'entrée de cart correspond
        Set<Cookies> cookiesSet = catalogue.listPreMadeRecipes();

        for (Cookies c : cookiesSet) {
            cart.add(test, new Item(c, 2));
        }
        Set<Item> items = cart.contents(test);
        for (Item i : items) {
            assertTrue(cookiesSet.contains(i.getCookie()));
        }
        assertTrue(test.getOrders().isEmpty());
        cart.validate(test);
        assertTrue(!test.getOrders().isEmpty());
        Set<Order> orders = test.getOrders();
        for (Order o : orders) {
            assertEquals(o.getCustomer(), test);
            items = o.getItems();
            for (Item i : items) {
                assertTrue(cookiesSet.contains(i.getCookie()));
            }
        }
    }
}
*/