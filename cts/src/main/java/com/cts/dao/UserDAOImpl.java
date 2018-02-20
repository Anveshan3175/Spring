package com.cts.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.model.User;


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
	public User findUserByName(String username) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("name", username));		
		return (User) criteria.uniqueResult();
	}

}
