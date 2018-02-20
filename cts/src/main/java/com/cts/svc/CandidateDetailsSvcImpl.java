package com.cts.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cts.dao.ICandidateDetailsDAO;
import com.cts.form.CandidateForm;
import com.cts.form.SkillForm;
import com.cts.model.CandidatePojo;
import com.cts.model.SkillsPojo;
import com.cts.util.Utils;

@Service("candidateSvc")
@Transactional
public class CandidateDetailsSvcImpl implements ICandidateDetailsSvc {

	public CandidateDetailsSvcImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private ICandidateDetailsDAO candidateDetailsDAOImpl;

	@Override
	public void saveCandidate(CandidateForm form) {

		CandidatePojo pojo = new CandidatePojo();
		Integer candidateId = candidateDetailsDAOImpl.getNextCandidateId();
		form.setId(candidateId);
		Utils.getCandidatePojoFromForm(form, pojo);
		candidateDetailsDAOImpl.saveCandidate(pojo);

	}

	@Override
	public CandidateForm getCandidateDetails(Integer candidateId) {
		// TODO Auto-generated method stub
		CandidateForm form = new CandidateForm();
		CandidatePojo pojo = candidateDetailsDAOImpl.getCandidateDetails(candidateId);
		Utils.getCandidateFormFromPojo(form, pojo);
		return form;
	}

	@Override
	public void updateCandidateDetails(CandidateForm form) {
		// TODO Auto-generated method stub
		CandidatePojo pojo = new CandidatePojo();
		Utils.getCandidatePojoFromForm(form, pojo);
		candidateDetailsDAOImpl.updateCandidateDetails(pojo);
	}

	@Override
	public List<SkillForm> listAllSkills() {
		// TODO Auto-generated method stub
		List<SkillsPojo> allSkillsPojoList = candidateDetailsDAOImpl.listAllSkills();
		return Utils.getSkillFormFromPojo(allSkillsPojoList);
	}
}
