package com.tap.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tap.model.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		Session session = null;
		/*
		 * try { //Step-2: Implementation session =
		 * sessionFactory.getCurrentSession(); } catch (HibernateException e) {
		 * //Step-3: Implementation session = sessionFactory.openSession(); }
		 */
		session = sessionFactory.getCurrentSession();
		List<Customer> customerList = session.createQuery("from Customer").list();
		return customerList;
	}

	@Override
	public int addCustomer(Customer customer) {
		Session session = this.sessionFactory.getCurrentSession();
		customer.setId(getMaxId());
		session.persist(customer);
		return customer.getId();
	}

	private int getMaxId() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Customer.class).setProjection(Projections.max("id"));
		Integer maxId = (Integer) criteria.uniqueResult();
		return (maxId == null ? 1000 : maxId + 1);
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer cust = (Customer) session.get(Customer.class, new Integer(id));
		return cust;
	}

	@Override
	public boolean isValidLogin(String name, String password) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "Select user.name from User user where user.name=:name and user.password=:password";
		System.out.println(hql);
		Query query = session.createQuery(hql);

		query.setParameter("name", name);
		query.setParameter("password", password);
		List result = query.list();
		return (result.size() > 0);
	}
}
