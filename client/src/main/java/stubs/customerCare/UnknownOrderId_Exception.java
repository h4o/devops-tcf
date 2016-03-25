
package stubs.customerCare;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "UnknownOrderId", targetNamespace = "http://webservice.customerwebservice.modules.tcf.isa.polytech.unice.fr/")
public class UnknownOrderId_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private UnknownOrderId faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public UnknownOrderId_Exception(String message, UnknownOrderId faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public UnknownOrderId_Exception(String message, UnknownOrderId faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: stubs.customerCare.UnknownOrderId
     */
    public UnknownOrderId getFaultInfo() {
        return faultInfo;
    }

}
