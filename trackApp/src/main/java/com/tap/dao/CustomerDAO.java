package com.tap.dao;

import java.util.List;

import com.tap.model.Customer;

public interface CustomerDAO {

	List<Customer> getCustomers();
	int addCustomer(Customer customer);
	Customer getCustomerById(int id);
	boolean isValidLogin(String name, String password);
}
