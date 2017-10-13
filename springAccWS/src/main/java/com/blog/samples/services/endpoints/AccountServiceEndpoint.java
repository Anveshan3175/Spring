package com.blog.samples.services.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.server.endpoint.annotation.SoapHeader;

import com.blog.samples.services.PersonService;
import com.blog.samples.services.PersonServiceImpl;
import com.blog.samples.webservices.personservice.AddPersonRequest;
import com.blog.samples.webservices.personservice.AddPersonResponse;
import com.blog.samples.webservices.personservice.DeletePersonRequest;
import com.blog.samples.webservices.personservice.DeletePersonResponse;
import com.blog.samples.webservices.personservice.GetAllPersonsRequest;
import com.blog.samples.webservices.personservice.GetAllPersonsResponse;
import com.blog.samples.webservices.personservice.GetPersonRequest;
import com.blog.samples.webservices.personservice.GetPersonResponse;
import com.blog.samples.webservices.personservice.Person;
import com.blog.samples.webservices.personservice.UpdatePersonRequest;
import com.blog.samples.webservices.personservice.UpdatePersonResponse;

@Endpoint
public class AccountServiceEndpoint {
	private static final String TARGET_NAMESPACE = "http://com/blog/samples/webservices/personservice";

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

	@PayloadRoot(localPart = "getPersonRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload GetPersonResponse getAccountDetails(@RequestPayload GetPersonRequest request,
			@SoapHeader("{" + TARGET_NAMESPACE + "}login") SoapHeaderElement loginElement,
			@SoapHeader("{" + TARGET_NAMESPACE + "}password") SoapHeaderElement passwordElement) {
		GetPersonResponse response = new GetPersonResponse();
		String login = loginElement.getText();
		String password = passwordElement.getText();

		if (personService.isValidLogin(login, password)) {
			System.out.println("---------------------isValidLogin----true");
			com.blog.samples.model.Person per = personService.getPersonById(request.getId());
			if (per == null) {
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
		} else {
			System.out.println("---------------------isValidLogin----false");
			response.setMessage("Credentials are invalid");
		}
		return response;
	}

	@PayloadRoot(localPart = "addPersonRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload AddPersonResponse addPersonRequest(@RequestPayload AddPersonRequest request,
			@SoapHeader("{" + TARGET_NAMESPACE + "}login") SoapHeaderElement loginElement,
			@SoapHeader("{" + TARGET_NAMESPACE + "}password") SoapHeaderElement passwordElement) {
		AddPersonResponse response = new AddPersonResponse();
		String login = loginElement.getText();
		String password = passwordElement.getText();

		if (personService.isValidLogin(login, password)) {
			Person person = request.getP();
			com.blog.samples.model.Person per = new com.blog.samples.model.Person();
			per.setName(person.getName());
			per.setAge(person.getAge());
			per.setCountry(person.getCountry());
			per.setOccupation(person.getOccupation());
			per.setId(person.getId());
			response.setAddPersonReturn(personService.addPerson(per));
			response.setMessage("Person is successfully created");
		} else {
			response.setMessage("Credentials are invalid");
		}
		return response;
	}

	@PayloadRoot(localPart = "getAllPersons", namespace = TARGET_NAMESPACE)
	public @ResponsePayload GetAllPersonsResponse getAllPersons(@RequestPayload GetAllPersonsRequest request,
			@SoapHeader("{" + TARGET_NAMESPACE + "}login") SoapHeaderElement loginElement,
			@SoapHeader("{" + TARGET_NAMESPACE + "}password") SoapHeaderElement passwordElement) {
		GetAllPersonsResponse response = new GetAllPersonsResponse();

		String login = loginElement.getText();
		String password = passwordElement.getText();

		if (personService.isValidLogin(login, password)) {

			Person person = null;
			List<Person> list = new ArrayList<Person>();

			List<com.blog.samples.model.Person> perList = personService.listPersons();
			for (com.blog.samples.model.Person per : perList) {
				person = new Person();
				person.setName(per.getName());
				person.setAge(per.getAge());
				person.setCountry(per.getCountry());
				person.setOccupation(per.getOccupation());
				person.setId(per.getId());
				list.add(person);
			}
			// response.setGetAllPersonsReturn(list);
		} else {
			response.setMessage("Credentials are invalid");
		}
		return response;
	}

	@PayloadRoot(localPart = "deletePersonRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload DeletePersonResponse deleteAccount(@RequestPayload DeletePersonRequest request,
			@SoapHeader("{" + TARGET_NAMESPACE + "}login") SoapHeaderElement loginElement,
			@SoapHeader("{" + TARGET_NAMESPACE + "}password") SoapHeaderElement passwordElement) {

		DeletePersonResponse response = new DeletePersonResponse();
		String login = loginElement.getText();
		String password = passwordElement.getText();
		if (personService.isValidLogin(login, password)) {
			System.out.println("---------------------isValidLogin----true");
			com.blog.samples.model.Person per = personService.getPersonById(request.getId());
			if (per == null) {
				response.setMessage("There is no person with given Id");
				return response;
			}

			personService.removePerson(request.getId());
			response.setMessage("Person is deleted successfully");
		} else {
			System.out.println("---------------------isValidLogin----false");
			response.setMessage("Credentials are invalid");
		}
		return response;
	}

	@PayloadRoot(localPart = "updatePersonRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload UpdatePersonResponse updatePersonRequest(@RequestPayload UpdatePersonRequest request,
			@SoapHeader("{" + TARGET_NAMESPACE + "}login") SoapHeaderElement loginElement,
			@SoapHeader("{" + TARGET_NAMESPACE + "}password") SoapHeaderElement passwordElement) {
		UpdatePersonResponse response = new UpdatePersonResponse();

		String login = loginElement.getText();
		String password = passwordElement.getText();
		if (personService.isValidLogin(login, password)) {

			com.blog.samples.model.Person per = personService.getPersonById(request.getP().getId());
			if (per == null) {
				response.setMessage("There is no person with given Id");
				return response;
			}
			Person person = request.getP();
			per = new com.blog.samples.model.Person();
			per.setName(person.getName());
			per.setAge(person.getAge());
			per.setCountry(person.getCountry());
			per.setOccupation(person.getOccupation());
			per.setId(person.getId());
			if (personService.updatePerson(per)) {
				response.setAddPersonReturn(true);
				response.setMessage("Person is successfully updated");
			} else {
				response.setAddPersonReturn(false);
				response.setMessage("Person is not  updated.Please check with admin");
			}
		} else {
			response.setMessage("Credentials are invalid");
		}
		return response;
	}
}