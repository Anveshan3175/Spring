package com.anvesh.person.svc;

import java.util.List;

import com.anvesh.person.model.Person;

public interface PersonService {

	public void addPerson(Person p);

	public void updatePerson(Person p);

	public List<Person> listPersons();

	public Person getPersonById(int id);

	public void removePerson(int id);
	
	public boolean validateLogin(String name,String password);
}
