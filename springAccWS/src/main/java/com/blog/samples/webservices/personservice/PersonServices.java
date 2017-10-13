
package com.blog.samples.webservices.personservice;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "PersonServices", targetNamespace = "http://com/blog/samples/webservices/personservice", wsdlLocation = "file:/C:/Workspace/GenralWorkSpace/springAccWS/src/main/webapp/schemas/PersonSvc.wsdl")
public class PersonServices
    extends Service
{

    private final static URL PERSONSERVICES_WSDL_LOCATION;
    private final static WebServiceException PERSONSERVICES_EXCEPTION;
    private final static QName PERSONSERVICES_QNAME = new QName("http://com/blog/samples/webservices/personservice", "PersonServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("file:/C:/Workspace/GenralWorkSpace/springAccWS/src/main/webapp/schemas/PersonSvc.wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        PERSONSERVICES_WSDL_LOCATION = url;
        PERSONSERVICES_EXCEPTION = e;
    }

    public PersonServices() {
        super(__getWsdlLocation(), PERSONSERVICES_QNAME);
    }

    public PersonServices(WebServiceFeature... features) {
        super(__getWsdlLocation(), PERSONSERVICES_QNAME, features);
    }

    public PersonServices(URL wsdlLocation) {
        super(wsdlLocation, PERSONSERVICES_QNAME);
    }

    public PersonServices(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PERSONSERVICES_QNAME, features);
    }

    public PersonServices(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PersonServices(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PersonService
     */
    @WebEndpoint(name = "PersonServiceSoap11")
    public PersonService getPersonServiceSoap11() {
        return super.getPort(new QName("http://com/blog/samples/webservices/personservice", "PersonServiceSoap11"), PersonService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PersonService
     */
    @WebEndpoint(name = "PersonServiceSoap11")
    public PersonService getPersonServiceSoap11(WebServiceFeature... features) {
        return super.getPort(new QName("http://com/blog/samples/webservices/personservice", "PersonServiceSoap11"), PersonService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PERSONSERVICES_EXCEPTION!= null) {
            throw PERSONSERVICES_EXCEPTION;
        }
        return PERSONSERVICES_WSDL_LOCATION;
    }

}
