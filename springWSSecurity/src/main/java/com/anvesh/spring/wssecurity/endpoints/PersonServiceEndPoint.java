package com.anvesh.spring.wssecurity.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.anvesh.spring.wssecurity.stubs.AddPersonRequest;
import com.anvesh.spring.wssecurity.stubs.AddPersonResponse;
import com.anvesh.spring.wssecurity.stubs.DeletePersonRequest;
import com.anvesh.spring.wssecurity.stubs.DeletePersonResponse;
import com.anvesh.spring.wssecurity.stubs.GetAllPersonsRequest;
import com.anvesh.spring.wssecurity.stubs.GetAllPersonsResponse;
import com.anvesh.spring.wssecurity.stubs.GetPersonRequest;
import com.anvesh.spring.wssecurity.stubs.GetPersonResponse;
import com.anvesh.spring.wssecurity.stubs.Person;
import com.anvesh.spring.wssecurity.stubs.UpdatePersonRequest;
import com.anvesh.spring.wssecurity.stubs.UpdatePersonResponse;
import com.anvesh.spring.wssecurity.svc.PersonService;
import com.anvesh.spring.wssecurity.svc.PersonServiceImpl;

@Endpoint
public class PersonServiceEndPoint {

	private static final String TARGET_NAMESPACE = "http://com/anvesh/spring/wssecurity/pns";

	private PersonService personService = new PersonServiceImpl();

	@PayloadRoot(localPart = "getPersonRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload GetPersonResponse getPersonDetails(@RequestPayload GetPersonRequest request) {
		GetPersonResponse response = new GetPersonResponse();

		/*
		 * Person person = new Person(); person.setName("Rocket");
		 * person.setAge(50); person.setCountry("Iran");
		 * person.setOccupation("Farmer"); person.setId(32);
		 * response.setGetPersonReturn(person); response.setMessage(
		 * "Person details are retrieved successfully");
		 */

		// Login login = request.getLogin();
		com.anvesh.spring.wssecurity.model.Person per = personService.getPersonById(request.getId());
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
		return response;
	}

	@PayloadRoot(localPart = "addPersonRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload AddPersonResponse addPersonRequest(@RequestPayload AddPersonRequest request) {
		AddPersonResponse response = new AddPersonResponse();

		Person person = request.getP();
		com.anvesh.spring.wssecurity.model.Person per = new com.anvesh.spring.wssecurity.model.Person();
		per.setName(person.getName());
		per.setAge(person.getAge());
		per.setCountry(person.getCountry());
		per.setOccupation(person.getOccupation());
		per.setId(person.getId());
		response.setAddPersonReturn(personService.addPerson(per));
		response.setMessage("Person is successfully created");

		return response;
	}

	@PayloadRoot(localPart = "getAllPersons", namespace = TARGET_NAMESPACE)
	public @ResponsePayload GetAllPersonsResponse getAllPersons(@RequestPayload GetAllPersonsRequest request) {
		GetAllPersonsResponse response = new GetAllPersonsResponse();

		Person person = null;
		List<Person> list = new ArrayList<Person>();

		List<com.anvesh.spring.wssecurity.model.Person> perList = personService.listPersons();
		for (com.anvesh.spring.wssecurity.model.Person per : perList) {
			person = new Person();
			person.setName(per.getName());
			person.setAge(per.getAge());
			person.setCountry(per.getCountry());
			person.setOccupation(per.getOccupation());
			person.setId(per.getId());
			list.add(person);
		}

		return response;
	}

	@PayloadRoot(localPart = "deletePersonRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload DeletePersonResponse deleteAccount(@RequestPayload DeletePersonRequest request) {

		DeletePersonResponse response = new DeletePersonResponse();

		com.anvesh.spring.wssecurity.model.Person per = personService.getPersonById(request.getId());
		if (per == null) {
			response.setMessage("There is no person with given Id");
			return response;
		}

		personService.removePerson(request.getId());
		response.setMessage("Person is deleted successfully");

		return response;
	}

	@PayloadRoot(localPart = "updatePersonRequest", namespace = TARGET_NAMESPACE)
	public @ResponsePayload UpdatePersonResponse updatePersonRequest(@RequestPayload UpdatePersonRequest request) {
		UpdatePersonResponse response = new UpdatePersonResponse();

		com.anvesh.spring.wssecurity.model.Person per = personService.getPersonById(request.getP().getId());
		if (per == null) {
			response.setMessage("There is no person with given Id");
			return response;
		}
		Person person = request.getP();
		per = new com.anvesh.spring.wssecurity.model.Person();
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

		return response;
	}

}
