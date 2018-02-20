package com.cts.svc;

import java.util.List;

import com.cts.form.CandidateForm;
import com.cts.form.SkillForm;

public interface ICandidateDetailsSvc {

	void saveCandidate(CandidateForm form);
	CandidateForm getCandidateDetails(Integer candidateId);
	void updateCandidateDetails(CandidateForm form);
	List<SkillForm> listAllSkills();
}
