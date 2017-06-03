package com.spring.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.spring.beans.Address;
import com.spring.beans.Student;
import com.spring.config.AppConfiguration;

public class MainApp {

	public MainApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
		
		Student std = (Student)context.getBean("student");
		System.out.println(std.getName());
		std.getAddress().setLine1("Test");
		
		Address homeAddr = (Address)context.getBean("address");
		System.out.println(homeAddr.getLine1());
		
		/*Address officeAddr = (Address)context.getBean("officeAddress");
		System.out.println(officeAddr.getLine1());*/
	}

}
