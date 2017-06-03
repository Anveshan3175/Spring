package com.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public class Student {

	public Student(int rollNo, String name) {
		// TODO Auto-generated constructor stub
		this.rollNo = rollNo;
		this.name = name;
	}
	
	private int rollNo;
	private String name;
	
	@Autowired
	@Qualifier("officeAddress")
	private Address address;
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
