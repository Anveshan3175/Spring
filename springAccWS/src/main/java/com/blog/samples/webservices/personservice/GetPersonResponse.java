
package com.blog.samples.webservices.personservice;

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
 *         &lt;element name="getPersonReturn" type="{http://com/blog/samples/webservices/personservice}Person"/>
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
    "getPersonReturn",
    "message"
})
@XmlRootElement(name = "getPersonResponse")
public class GetPersonResponse {

    @XmlElement(required = true)
    protected Person getPersonReturn;
    @XmlElement(required = true, nillable = true)
    protected String message;

    /**
     * Gets the value of the getPersonReturn property.
     * 
     * @return
     *     possible object is
     *     {@link Person }
     *     
     */
    public Person getGetPersonReturn() {
        return getPersonReturn;
    }

    /**
     * Sets the value of the getPersonReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link Person }
     *     
     */
    public void setGetPersonReturn(Person value) {
        this.getPersonReturn = value;
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
