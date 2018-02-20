package com.cts.form;

import java.util.List;

import org.hibernate.validator.constraints.Range;


public class CandidateForm {

	public CandidateForm() {
		// TODO Auto-generated constructor stub
	}

	private Integer id;
	private String name;
	private String email;
	private Long mobile;
	private String city;
	private String currentCompany;
	private List<SkillForm> selectedSkills;
	private List<SkillForm> allSkills;
	@Range(min=0,max=3)
	private Integer noticePeriod; // in months
	private Float experience;
	
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


	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCurrentCompany() {
		return currentCompany;
	}
	public void setCurrentCompany(String currentCompany) {
		this.currentCompany = currentCompany;
	}


	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public Integer getNoticePeriod() {
		return noticePeriod;
	}
	public void setNoticePeriod(Integer noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	public List<SkillForm> getSelectedSkills() {
		return selectedSkills;
	}
	public void setSelectedSkills(List<SkillForm> selectedSkills) {
		this.selectedSkills = selectedSkills;
	}
	public List<SkillForm> getAllSkills() {
		return allSkills;
	}
	public void setAllSkills(List<SkillForm> allSkills) {
		this.allSkills = allSkills;
	}
	public Float getExperience() {
		return experience;
	}
	public void setExperience(Float experience) {
		this.experience = experience;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	
	
	
	
}
