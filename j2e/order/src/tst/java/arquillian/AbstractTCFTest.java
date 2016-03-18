package arquillian;

import fr.unice.polytech.isa.tcf.modules.cart.CartModifier;
import fr.unice.polytech.isa.tcf.modules.cart.components.CartBean;
import fr.unice.polytech.isa.tcf.modules.cart.components.carts.CartStatefulBean;
import fr.unice.polytech.isa.tcf.modules.customer.entities.Customer;
import fr.unice.polytech.isa.tcf.modules.customer.exceptions.AlreadyExistingCustomerException;
import fr.unice.polytech.isa.tcf.modules.cart.interceptors.Logger;
import fr.unice.polytech.isa.tcf.modules.database.Database;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

import javax.ejb.EJB;

public abstract class AbstractTCFTest {


	@EJB
	protected Database memory;

	@Deployment
	public static WebArchive createDeployment() {
		// Building a Web ARchive (WAR) containing the following elements:
		return ShrinkWrap.create(WebArchive.class)
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				// Utils
				.addPackage(Database.class.getPackage())
				// Entities
				.addPackage(Customer.class.getPackage())
				// Components Interfaces
				.addPackage(CartModifier.class.getPackage())
				// Cart components
				.addPackage(CartStatefulBean.class.getPackage())
				// Interceptors
				.addPackage(Logger.class.getPackage())
				// Exceptions
				.addPackage(AlreadyExistingCustomerException.class.getPackage())
				// Components implementations
				.addPackage(CartBean.class.getPackage());
	}

}
