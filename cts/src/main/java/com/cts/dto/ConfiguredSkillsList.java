package com.cts.dto;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cts.form.SkillForm;

@Component("configuredSkillsList")
public class ConfiguredSkillsList implements Serializable {

	private static final long serialVersionUID = 6741995181754974710L;

	public ConfiguredSkillsList() {
		// TODO Auto-generated constructor stub
	}

	private List<SkillForm> skillList;

	public List<SkillForm> getSkillList() {
		return skillList;
	}

	public void setSkillList(List<SkillForm> skillList) {
		this.skillList = skillList;
	}
	
	
}
