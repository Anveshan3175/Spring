package com.anv.intv.dao;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

// To use criteria uncomment below
//import org.hibernate.Criteria;
//import org.hibernate.criterion.Restrictions;

import com.anv.intv.entities.User;

@Repository("userDao")
public class UserDAOImpl implements IUserDAO{

	
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public User validateLoginUser(String userName, String password) {
		// TODO Auto-generated method stub
	
		 Session session = sessionFactory.getCurrentSession(); 
		 CriteriaBuilder builder = session.getCriteriaBuilder();
		 CriteriaQuery<User> criteriaQuery = builder.createQuery(User.class);
		 Root<User> root = criteriaQuery.from(User.class);
		 
		 Predicate[] predicates = new Predicate[2];
		 predicates[0] = builder.equal(root.get("name"), userName);
		 predicates[1] = builder.equal(root.get("password"), password);
		 
		 criteriaQuery.select(root).where(predicates);
		 
		 Query<User> query = session.createQuery(criteriaQuery);
		 List<User> results = query.getResultList();
		 
		 return (results != null && !results.isEmpty()) ? results.get(0) : null;
	}
	
	// old way
	/* 
	 * @Override public User validateLoginUser(String userName, String password) {
	 * // TODO Auto-generated method stub Criteria criteria =
	 * sessionFactory.getCurrentSession().createCriteria(User.class);
	 * criteria.add(Restrictions.eq("name", userName));
	 * criteria.add(Restrictions.eq("password", password)); return (User)
	 * criteria.uniqueResult(); }
	 */

}
