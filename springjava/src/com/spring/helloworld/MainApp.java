package com.spring.helloworld;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.beans.Address;
import com.spring.beans.Student;

public class MainApp {

	public MainApp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "services.xml", "daos.xml", "applicationContext.xml" });
		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
		obj.getMessage();

		TestAutowired tw = (TestAutowired) context.getBean("customer");
		tw.getHelloWorld().getMessage();
		
		Student std = (Student)context.getBean("student");
		System.out.println(std.getName());
		System.out.println(std.getAddress().getLine1());
		
		Address addr = (Address)context.getBean("address");
		System.out.println(addr.getCity());
	}

}
