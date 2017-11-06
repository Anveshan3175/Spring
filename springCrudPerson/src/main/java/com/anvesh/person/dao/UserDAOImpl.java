package com.anvesh.person.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.anvesh.person.model.Login;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public UserDAOImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Login findUserByName(String username) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Login.class);
		criteria.add(Restrictions.eq("name", username));		
		return (Login) criteria.uniqueResult();
	}

}
