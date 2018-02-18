
package com.tap.ws.stubs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="getCustomerReturn" type="{http://com/customer/webservices/customerSvc}CustomerStub"/>
 *         &lt;element name="message" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getCustomerReturn",
    "message"
})
@XmlRootElement(name = "getCustomerResponse")
public class GetCustomerResponse {

    @XmlElement(required = true)
    protected CustomerStub getCustomerReturn;
    @XmlElement(required = true, nillable = true)
    protected String message;

    /**
     * Gets the value of the getCustomerReturn property.
     * 
     * @return
     *     possible object is
     *     {@link CustomerStub }
     *     
     */
    public CustomerStub getGetCustomerReturn() {
        return getCustomerReturn;
    }

    /**
     * Sets the value of the getCustomerReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link CustomerStub }
     *     
     */
    public void setGetCustomerReturn(CustomerStub value) {
        this.getCustomerReturn = value;
    }

    /**
     * Gets the value of the message property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the value of the message property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessage(String value) {
        this.message = value;
    }

}
