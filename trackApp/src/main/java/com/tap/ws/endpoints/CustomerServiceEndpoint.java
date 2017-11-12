package com.tap.ws.endpoints;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.server.endpoint.annotation.SoapHeader;

import com.tap.model.Customer;
import com.tap.svc.CustomerSvc;
import com.tap.ws.stubs.AddCustomerRequest;
import com.tap.ws.stubs.AddCustomerResponse;
import com.tap.ws.stubs.CustomerStub;
import com.tap.ws.stubs.GetCustomerRequest;
import com.tap.ws.stubs.GetCustomerResponse;
import com.tap.ws.stubs.Header;
import com.tap.ws.stubs.Login;

@Endpoint
public class CustomerServiceEndpoint {
	private static final String TARGET_NAMESPACE = "http://com/customer/webservices/customerSvc";
	
	@Autowired
	private CustomerSvc service;

	/**
	 * Gets the account details.
	 * 
	 * @param accountNumber
	 *            the account number
	 * @return the account details
	 */

    private Header getHeader(SoapHeaderElement header){
    	Header hdr = null;
        try {

            JAXBContext context = JAXBContext.newInstance(Header.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            hdr = (Header) unmarshaller.unmarshal(header.getSource());

        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return hdr;
    }
    
	@PayloadRoot(localPart = "getCustomerRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload GetCustomerResponse getAccountDetails(@RequestPayload GetCustomerRequest request) {
		GetCustomerResponse response = new GetCustomerResponse();
		
		Login login = request.getLogin();
		if (service.isValidLogin(login.getName(), login.getPassword())){
			System.out.println("---------------------isValidLogin----true");
			Customer customerModel = service.getCustomerById(request.getId());
			if(customerModel == null){
				response.setMessage("There is no Customer with given Id");
				return response;
			}
			 CustomerStub custStub = new CustomerStub();
			 custStub.setFirstname(customerModel.getfName());
			 custStub.setLastname(customerModel.getlName());
			 custStub.setCity(customerModel.getCity());
			 custStub.setId(customerModel.getId());
			 custStub.setPhone(customerModel.getPhone());
			 custStub.setEmail(customerModel.getEmail());
			 response.setGetCustomerReturn(custStub);
			 response.setMessage("Person details are retrieved successfully");
		}
		else{
			System.out.println("---------------------isValidLogin----false");
			response.setMessage("Credentials are invalid");
		}
		return response;
	}
	
	@PayloadRoot(localPart = "addCustomerRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload AddCustomerResponse addCustomerRequest(@RequestPayload AddCustomerRequest request, @SoapHeader("{" + TARGET_NAMESPACE + "}header")
    SoapHeaderElement soapHeaderElement) {
		AddCustomerResponse response = new AddCustomerResponse();
		Header hdr = getHeader(soapHeaderElement);
		System.out.println("---------------------hdr"+hdr+"----"+hdr.getUserid());
		 System.out.println("---------------------request"+request);
		 System.out.println("---------------------request.getId()"+request.getCustomer());
		 
		// if (service.isValidLogin(hdr.getUserid(), hdr.getPassword())){
			 CustomerStub custStub = request.getCustomer();
			 Customer customerModel = new Customer();
			 customerModel.setfName(custStub.getFirstname());
			 customerModel.setlName(custStub.getLastname());
			 customerModel.setCity(custStub.getCity());
			 customerModel.setPhone(custStub.getPhone());
			 customerModel.setEmail(custStub.getEmail());
			 if(service.addCustomer(customerModel) != 0){
				response.setAddCustomerReturn(true);
				response.setMessage("Person is successfully created");
			 }
		/* }
			else{
				response.setMessage("Credentials are invalid");
			}*/
		return response;
	}
	
}