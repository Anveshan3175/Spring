package com.anvesh.person.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Login")
public class Login {

	public Login() {

	}

	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="password")
	private String password;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [name=" + name + ", password=" + password + "]";
	}
	
	
}
