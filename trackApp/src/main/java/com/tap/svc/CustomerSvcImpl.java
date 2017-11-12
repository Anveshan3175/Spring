package com.tap.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tap.dao.CustomerDAO;
import com.tap.model.Customer;

@Service
@Transactional
public class CustomerSvcImpl implements CustomerSvc {

	@Autowired
	private CustomerDAO customerDao;

	public CustomerSvcImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customerDao.getCustomers();
	}

	@Override
	public int addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDao.addCustomer(customer);
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		return customerDao.getCustomerById(id);
	}

	@Override
	public boolean isValidLogin(String name, String password) {
		// TODO Auto-generated method stub
		return customerDao.isValidLogin(name, password);
	}

}
