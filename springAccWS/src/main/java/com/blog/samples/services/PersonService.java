package com.blog.samples.services;

import java.util.List;

import com.blog.samples.model.Person;



public interface PersonService {

	public boolean addPerson(Person p);

	public boolean updatePerson(Person p);

	public List<Person> listPersons();

	public Person getPersonById(int id);

	public void removePerson(int id);
	
	public boolean isValidLogin(String name, String password);
}
