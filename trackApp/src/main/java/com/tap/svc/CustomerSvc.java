package com.tap.svc;

import java.util.List;

import com.tap.model.Customer;

public interface CustomerSvc {

	List<Customer> getCustomers();
	int addCustomer(Customer customer);
	Customer getCustomerById(int id);
	boolean isValidLogin(String name, String password);
}
