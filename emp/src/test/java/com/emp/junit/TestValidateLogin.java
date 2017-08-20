package com.emp.junit;

import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.emp.configuration.SpringJDBCConfiguration;
import com.emp.configuration.SpringRootConfig;
import com.emp.dao.LoginDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringRootConfig.class, SpringJDBCConfiguration.class}, loader=AnnotationConfigContextLoader.class)
public class TestValidateLogin {

	@Autowired
	private LoginDAO loginDAO;

	
    @Test
    public void testInsert() {	
        assertTrue(loginDAO.validateLogin("test", "test"));
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void testConnection() {
		// TODO Auto-generated method stub	
		try{  
			//step1 load the driver class  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			//step2 create  the connection object  
			Connection con=DriverManager.getConnection(  
			"jdbc:oracle:thin:@localhost:1521:xe","hib","hib");  
			  
			//step3 create the statement object  
			Statement stmt=con.createStatement();  
			  
			//step4 execute query  
			ResultSet rs=stmt.executeQuery("select * from tb_login");  
			while(rs.next())  
			System.out.println(rs.getString(1)+"  "+rs.getString(2));  
			  
			//step5 close the connection object  
			con.close();  
			  
			}catch(Exception e){ System.out.println(e);
			}  
	}
	

}
