package com.cts.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.cts.form.CandidateForm;
import com.cts.form.SkillForm;
import com.cts.model.CandidatePojo;
import com.cts.model.CandidateSkillsIdPojo;
import com.cts.model.CandidateSkillsPojo;
import com.cts.model.SkillsPojo;

public class Utils {

	public Utils() {
		// TODO Auto-generated constructor stub
	}

	public static void getCandidatePojoFromForm(CandidateForm form, CandidatePojo pojo) {
		pojo.setId(form.getId());
		pojo.setName(form.getName());
		pojo.setCity(form.getCity());
		pojo.setCompany(form.getCurrentCompany());
		pojo.setEmail(form.getEmail());
		pojo.setExperience(form.getExperience());
		pojo.setMobile(form.getMobile());
		pojo.setNoticePeriod(form.getNoticePeriod());

		Set<CandidateSkillsPojo> skillsSet = new HashSet<>();
		poulateSkillPojoFromForm(form.getId(), form.getSelectedSkills(), skillsSet);
		pojo.setSkills(skillsSet);
	}

	private static void poulateSkillPojoFromForm(Integer candidateId, List<SkillForm> selectedSkillsformList,
			Set<CandidateSkillsPojo> pojoSet) {
		for (SkillForm form : selectedSkillsformList) {
			CandidateSkillsPojo pojo = new CandidateSkillsPojo();
			CandidateSkillsIdPojo pojoId = new CandidateSkillsIdPojo();
			pojoId.setCandidateId(candidateId);
			pojoId.setSkillId(form.getId());
			pojo.setId(pojoId);
			pojoSet.add(pojo);
		}
	}

	public static void getCandidateFormFromPojo(CandidateForm form, CandidatePojo pojo) {
		form.setId(pojo.getId());
		form.setName(pojo.getName());
		form.setCity(pojo.getCity());
		form.setCurrentCompany(pojo.getCompany());
		form.setEmail(pojo.getEmail());
		form.setExperience(pojo.getExperience());
		form.setMobile(pojo.getMobile());
		form.setNoticePeriod(pojo.getNoticePeriod());

		Set<CandidateSkillsPojo> skillsPojoSet = pojo.getSkills();
		List<SkillForm> selectedFormSkills = new ArrayList<>();
		poulateSkillFormFromPojo(selectedFormSkills, skillsPojoSet);
		form.setSelectedSkills(selectedFormSkills);
	}

	private static void poulateSkillFormFromPojo(List<SkillForm> selectedFormSkills,
			Set<CandidateSkillsPojo> skillsPojoSet) {
		for (CandidateSkillsPojo pojo : skillsPojoSet) {
			CandidateSkillsIdPojo pojoId = pojo.getId();
			SkillForm form = new SkillForm();
			form.setId(pojoId.getSkillId());
			selectedFormSkills.add(form);
		}
	}

	/// need to revisit
	public static void populateSelectedSkillsForUI(List<SkillForm> selectedSkillList, List<SkillForm> allSkillList) {
		for (SkillForm item : selectedSkillList) {
			copyFullDataToSelectedSkill(item, allSkillList);
		}
		return;
	}

	private static void copyFullDataToSelectedSkill(SkillForm selectedSkill, List<SkillForm> allSkillList) {
		for (SkillForm item : allSkillList) {
			if (selectedSkill.getId().equals(item.getId())) {
				selectedSkill.setName(item.getName());
				selectedSkill.setDescription(item.getDescription());
				return;
			}
		}
	}

	public static void copyDataFromModifiedToExistingPojo(CandidatePojo existingPojo, CandidatePojo modifiedPojo) {
		existingPojo.setName(modifiedPojo.getName());
		existingPojo.setCity(modifiedPojo.getCity());
		existingPojo.setCompany(modifiedPojo.getCompany());
		existingPojo.setEmail(modifiedPojo.getEmail());
		existingPojo.setExperience(modifiedPojo.getExperience());
		existingPojo.setMobile(modifiedPojo.getMobile());
		existingPojo.setNoticePeriod(modifiedPojo.getNoticePeriod());
		existingPojo.setSkills(modifiedPojo.getSkills());
	}

	public static List<SkillForm> getSkillFormFromPojo(List<SkillsPojo> skillsListPojo) {
		List<SkillForm> allSkillsForm = new ArrayList<SkillForm>();
		for (SkillsPojo pojo : skillsListPojo) {
			SkillForm form = new SkillForm();
			form.setId(pojo.getId());
			form.setName(pojo.getName());
			form.setDescription(pojo.getDescription());
			allSkillsForm.add(form);
		}
		return allSkillsForm;
	}
}
