package com.cts.dao;

import java.util.List;

import com.cts.model.CandidatePojo;
import com.cts.model.SkillsPojo;

public interface ICandidateDetailsDAO {

	void saveCandidate(CandidatePojo pojo);
	Integer getNextCandidateId();
	CandidatePojo getCandidateDetails(Integer candidateId);
	void updateCandidateDetails(CandidatePojo pojo);
	List<SkillsPojo> listAllSkills();
}
