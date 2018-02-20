package com.cts.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "tb_candidate_dtls")
public class CandidatePojo implements Serializable {

	private static final long serialVersionUID = -6921694301402650867L;

	public CandidatePojo() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "id")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "name",unique=true)
	private String name;
	@Column(name = "email",unique=true)
	private String email;
	@Column(name = "mobile")
	private long mobile;
	@Column(name = "experience")
	private float experience;
	@Column(name = "city")
	private String city;
	@Column(name = "company")
	private String company;
	@Column(name = "noticePeriod")
	private int noticePeriod;

	@SuppressWarnings("deprecation")
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "candidatePojo",orphanRemoval=true)
	@Cascade({org.hibernate.annotations.CascadeType.DELETE,org.hibernate.annotations.CascadeType.DELETE_ORPHAN})
	private Set<CandidateSkillsPojo> skills;

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

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

	public Set<CandidateSkillsPojo> getSkills() {
		return skills;
	}

	public void setSkills(Set<CandidateSkillsPojo> skills) {
		this.skills = skills;
	}



}
