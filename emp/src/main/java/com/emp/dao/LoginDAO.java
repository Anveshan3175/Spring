package com.emp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.emp.model.Login;

@Repository
public class LoginDAO {
	
	@Autowired
    JdbcTemplate jdbcTemplate;

	public boolean validateLogin(){
		System.out.println("In the DAO method");
		return true;
	}
	
	public boolean validateLogin(String name,String password) {
		Login person = (Login) jdbcTemplate.queryForObject("SELECT * FROM tb_login where name = ? and password = ? ",
            new Object[] { name, password}, new BeanPropertyRowMapper(Login.class));
 
        return (person != null);
    }
}
