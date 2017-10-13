package com.blog.samples.dao;

import java.util.List;

import com.blog.samples.model.Person;



public interface PersonDAO {

	public boolean savePersonDetails(Person p);
	public boolean updatePerson(Person p);
	public List<Person> listPersons();
	Person getPersonDetails(int userId);
	public void removePerson(int id);
	public boolean isValidLogin(String name, String password);
}
