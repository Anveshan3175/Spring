package com.emp.dao;

import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {

	public boolean validateLogin(){
		System.out.println("In the DAO method");
		return true;
	}
}
