package com.person.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.person.dao.PersonDAO;
import com.person.dao.PersonDAOImpl;
import com.person.model.Person;



@Service
public class PersonServiceImpl implements PersonService {

	
	private PersonDAO personDAO = new PersonDAOImpl() ;

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}

	@Override
	@Transactional
	public boolean addPerson(Person p) {
		// TODO Auto-generated method stub
		return personDAO.savePersonDetails(p);
	}
	
	@Override
	@Transactional
	public boolean updatePerson(Person p) {
		return this.personDAO.updatePerson(p);
	}

	@Override
	@Transactional
	public List<Person> listPersons() {
		return this.personDAO.listPersons();
	}

	@Override
	@Transactional
	public Person getPersonById(int id) {
		//return this.personDAO.getPersonById(id);
		return personDAO.getPersonDetails(id);
	}

	@Override
	@Transactional
	public void removePerson(int id) {
		personDAO.removePerson(id);
	}
	
	public boolean isValidLogin(String name, String password){
		return personDAO.isValidLogin(name, password);
	}
}
