package com.person.services.endpoints;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
//import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.saaj.SaajSoapMessage;


import com.person.services.PersonService;
import com.person.services.PersonServiceImpl;
import com.person.webservices.personservice.AddPersonRequest;
import com.person.webservices.personservice.AddPersonResponse;
import com.person.webservices.personservice.DeletePersonRequest;
import com.person.webservices.personservice.DeletePersonResponse;
import com.person.webservices.personservice.GetAllPersonsRequest;
import com.person.webservices.personservice.GetAllPersonsResponse;
import com.person.webservices.personservice.GetPersonRequest;
import com.person.webservices.personservice.GetPersonResponse;
import com.person.webservices.personservice.Header;
import com.person.webservices.personservice.Login;
import com.person.webservices.personservice.ObjectFactory;
import com.person.webservices.personservice.Person;
import com.person.webservices.personservice.UpdatePersonRequest;
import com.person.webservices.personservice.UpdatePersonResponse;

import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.server.endpoint.annotation.SoapHeader;

@Endpoint
public class AccountServiceEndpoint {
	private static final String TARGET_NAMESPACE = "http://com/person/webservices/personSvc";
	
	private PersonService personService = new PersonServiceImpl();

	/**
	 * Gets the account details.
	 * 
	 * @param accountNumber
	 *            the account number
	 * @return the account details
	 */


	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
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
    
	@PayloadRoot(localPart = "getPersonRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload GetPersonResponse getAccountDetails(@RequestPayload GetPersonRequest request) {
		GetPersonResponse response = new GetPersonResponse();
		
		Login login = request.getLogin();
		if (personService.isValidLogin(login.getName(), login.getPassword())){
			System.out.println("---------------------isValidLogin----true");
			com.person.model.Person per = personService.getPersonById(request.getId());
			if(per == null){
				response.setMessage("There is no person with given Id");
				return response;
			}
			 Person person = new Person();
			 person.setName(per.getName());
			 person.setAge(per.getAge());
			 person.setCountry(per.getCountry());
			 person.setOccupation(per.getOccupation());
			 person.setId(per.getId());
			 response.setGetPersonReturn(person);
			 response.setMessage("Person details are retrieved successfully");
		}
		else{
			System.out.println("---------------------isValidLogin----false");
			response.setMessage("Credentials are invalid");
		}
		return response;
	}
	
	@PayloadRoot(localPart = "addPersonRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload AddPersonResponse addPersonRequest(@RequestPayload AddPersonRequest request, @SoapHeader("{" + TARGET_NAMESPACE + "}header")
    SoapHeaderElement soapHeaderElement) {
		AddPersonResponse response = new AddPersonResponse();
		Header hdr = getHeader(soapHeaderElement);
		System.out.println("---------------------hdr"+hdr+"----"+hdr.getUserid());
		 System.out.println("---------------------request"+request);
		 System.out.println("---------------------request.getId()"+request.getP());
		 
		 if (personService.isValidLogin(hdr.getUserid(), hdr.getPassword())){
			 Person person = request.getP();
			 com.person.model.Person per = new com.person.model.Person();
			 per.setName(person.getName());
			 per.setAge(person.getAge());
			 per.setCountry(person.getCountry());
			 per.setOccupation(person.getOccupation());
			 per.setId(person.getId());
			response.setAddPersonReturn(personService.addPerson(per));
			response.setMessage("Person is successfully created");
		 }
			else{
				response.setMessage("Credentials are invalid");
			}
		return response;
	}
	
	@PayloadRoot(localPart = "getAllPersons", namespace = TARGET_NAMESPACE)
	public @ResponsePayload GetAllPersonsResponse getAllPersons(@RequestPayload GetAllPersonsRequest request) {
		GetAllPersonsResponse response = new GetAllPersonsResponse();
		

		 System.out.println("---------------------request"+request);
		 System.out.println("---------------------request.getId()"+request.getLogin());
		 Login login = request.getLogin();
		 
		 if (personService.isValidLogin(login.getName(), login.getPassword())){
			 
			 Person person = null;
			 List<Person> list = new ArrayList<Person>();
			 
			 List<com.person.model.Person> perList = personService.listPersons();
			 for(com.person.model.Person per :  perList){
				 person = new Person();
				 person.setName(per.getName());
				 person.setAge(per.getAge());
				 person.setCountry(per.getCountry());
				 person.setOccupation(per.getOccupation());
				 person.setId(per.getId());
				 list.add(person);
			 }
		 }
			else{
				response.setMessage("Credentials are invalid");
			}
		return response;
	}
	
	
	@PayloadRoot(localPart = "deletePersonRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload DeletePersonResponse deleteAccount(@RequestPayload DeletePersonRequest request, @SoapHeader("{" + TARGET_NAMESPACE + "}header")
    SoapHeaderElement soapHeaderElement) {
		
		DeletePersonResponse response = new DeletePersonResponse();
		
		Login login = request.getLogin();
		if (personService.isValidLogin(login.getName(), login.getPassword())){
			System.out.println("---------------------isValidLogin----true");
			com.person.model.Person per = personService.getPersonById(request.getId());
			if(per == null){
				response.setMessage("There is no person with given Id");
				return response;
			}
			
			personService.removePerson(request.getId());
			response.setMessage("Person is deleted successfully");
		}
		else{
			System.out.println("---------------------isValidLogin----false");
			response.setMessage("Credentials are invalid");
		}
		return response;
	}
	
	
	@PayloadRoot(localPart = "updatePersonRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload UpdatePersonResponse updatePersonRequest(@RequestPayload UpdatePersonRequest request,@SoapHeader("{" + TARGET_NAMESPACE + "}header")
    SoapHeaderElement soapHeaderElement) {
		UpdatePersonResponse response = new UpdatePersonResponse();
		
		Header hdr = getHeader(soapHeaderElement);
		System.out.println("---------------------hdr"+hdr+"----"+hdr.getUserid());
		 System.out.println("---------------------request"+request);
		 System.out.println("---------------------request.getId()"+request.getP());
		 
		 if (personService.isValidLogin(hdr.getUserid(), hdr.getPassword())){
			 
			com.person.model.Person per = personService.getPersonById(request.getP().getId());
			if(per == null){
				response.setMessage("There is no person with given Id");
				return response;
			} 
			 Person person = request.getP();
			 per = new com.person.model.Person();
			 per.setName(person.getName());
			 per.setAge(person.getAge());
			 per.setCountry(person.getCountry());
			 per.setOccupation(person.getOccupation());
			 per.setId(person.getId());
			 if(personService.updatePerson(per)){
				 response.setAddPersonReturn(true);
				 response.setMessage("Person is successfully updated");
			 }
			 else {
				 response.setAddPersonReturn(false);
				 response.setMessage("Person is not  updated.Please check with admin");
			 }
		 }
			else{
				response.setMessage("Credentials are invalid");
			}
		return response;
	}
}