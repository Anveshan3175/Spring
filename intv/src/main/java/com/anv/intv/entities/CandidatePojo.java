package com.anv.intv.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_candidate_details")
public class CandidatePojo {

	@Id
	@Column(name = "candidate_id")
	private int id;
	
	@Column(name = "candidate_name", nullable=false)
	private String name;
	
	@Column(name = "candidate_email", nullable=false)
	private String email;
	
	@Column(name = "candidate_primary_phone",unique=true)
	private int primaryPhone;
	
	@Column(name = "candidate_secondary_phone")
	private int secondaryPhone;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(int primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public int getSecondaryPhone() {
		return secondaryPhone;
	}

	public void setSecondaryPhone(int secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}
}
