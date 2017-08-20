package com.emp.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emp.model.Login;

@Repository
public class LoginDAO {
	
	private static final Logger logger = Logger.getLogger(LoginDAO.class);
	
	@Autowired
    JdbcTemplate jdbcTemplate;

	public boolean validateLogin(){
		System.out.println("In the DAO method");
		return true;
	}
	
	public boolean validateLogin(String name,String password) {
		Login person = null;
		boolean isSuccess = false;
		
		try{
			person = (Login) jdbcTemplate.queryForObject("SELECT * FROM tb_login where name = ? and password = ? ",
		            new Object[] { name, password}, new BeanPropertyRowMapper(Login.class));
			isSuccess = true;
		}
		catch(IncorrectResultSizeDataAccessException ex){
			logger.error("No records found for user "+name);
		}
        return isSuccess;
    }
}
