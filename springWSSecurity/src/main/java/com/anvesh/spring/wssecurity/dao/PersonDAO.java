package com.anvesh.spring.wssecurity.dao;

import java.util.List;

import com.anvesh.spring.wssecurity.model.Person;



public interface PersonDAO {

	public boolean savePersonDetails(Person p);
	public boolean updatePerson(Person p);
	public List<Person> listPersons();
	Person getPersonDetails(int userId);
	public void removePerson(int id);
	public boolean isValidLogin(String name, String password);
}
