package com.tap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user_login")
public class User {

	public User() {

	}

	@Id
	@Column(name = "userid")
	private int id;

	@Column(name = "username", unique = true)
	private String name;

	@Column(name = "password")
	private String password;

	@Column(name = "salt")
	private String salt;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", salt=" + salt + "]";
	}

}
