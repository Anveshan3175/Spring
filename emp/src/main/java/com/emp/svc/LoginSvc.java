package com.emp.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.LoginDAO;

@Service
public class LoginSvc {

	@Autowired 
	private LoginDAO dao;
	
	public boolean validateLogin(){
		System.out.println("In the svc method");
		return dao.validateLogin();
	}
}
