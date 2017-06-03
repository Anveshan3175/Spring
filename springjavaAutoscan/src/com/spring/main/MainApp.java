package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.Address;
import com.spring.beans.Student;

public class MainApp {

	public MainApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });
		
		Student std = (Student)context.getBean("student");
		System.out.println(std.getName());
		std.getAddress().setLine1("Test");
		
		Address homeAddr = (Address)context.getBean("address");
		System.out.println(homeAddr.getLine1());
		
		/*Address officeAddr = (Address)context.getBean("officeAddress");
		System.out.println(officeAddr.getLine1());*/
	}

}
