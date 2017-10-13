package com.anvesh.spring.wssecurity.svc;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anvesh.spring.wssecurity.dao.PersonDAO;
import com.anvesh.spring.wssecurity.dao.PersonDAOImpl;
import com.anvesh.spring.wssecurity.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonDAO personDAO = new PersonDAOImpl();

	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	@Transactional
	public boolean addPerson(Person p) {
		// TODO Auto-generated method stub
		return personDAO.savePersonDetails(p);
	}

	@Transactional
	public boolean updatePerson(Person p) {
		// TODO Auto-generated method stub
		return this.personDAO.updatePerson(p);
	}

	@Transactional
	public List<Person> listPersons() {
		// TODO Auto-generated method stub
		return this.personDAO.listPersons();
	}

	@Transactional
	public Person getPersonById(int id) {
		// TODO Auto-generated method stub
		return personDAO.getPersonDetails(id);
	}

	@Transactional
	public void removePerson(int id) {
		// TODO Auto-generated method stub
		personDAO.removePerson(id);
	}

	@Transactional
	public boolean isValidLogin(String name, String password) {
		// TODO Auto-generated method stub
		return personDAO.isValidLogin(name, password);
	}

}
