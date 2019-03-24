package com.anv.intv.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anv.intv.dao.ICommonDao;
import com.anv.intv.entities.CandidatePojo;
import com.anv.intv.entities.InterviewPojo;
import com.anv.intv.entities.QuestionsPojo;
import com.anv.intv.form.CandidateDetailsForm;
import com.anv.intv.form.InterviewForm;
import com.anv.intv.form.Question;
import com.anv.intv.util.SVCUtil;

@Service("commonSVC")
public class CommonSvcImpl implements ICommonSvc {

	@Autowired
	private ICommonDao commonDao;
	
	@Override
	@Transactional
	public boolean addCandidate(CandidateDetailsForm form) {
		// TODO Auto-generated method stub
		CandidatePojo pojo = new CandidatePojo();
		SVCUtil.populateCandidatePojo(form,pojo);
		commonDao.addCandidate(pojo);
		
		return false;
	}
	
	@Override
	@Transactional
	public void addQuestion(Question form) {
		// TODO Auto-generated method stub
		QuestionsPojo pojo = new QuestionsPojo();
		SVCUtil.populateQuestionPojo(form,pojo);
		commonDao.addQuestion(pojo);
	}
	
	@Override
	@Transactional
	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		
		List<QuestionsPojo> pojos = commonDao.getAllQuestions();
		return SVCUtil.populateQuestionForms(pojos);
	}

	@Override
	@Transactional
	public CandidateDetailsForm getCandidateByEmail(String email) {
		// TODO Auto-generated method stub
		CandidatePojo pojo = commonDao.getCandidateByEmail(email);
		CandidateDetailsForm form = new CandidateDetailsForm();
		SVCUtil.populateCandidateForm(form,pojo);
		return form;
	}
	
	@Override
	public boolean addNewInterview(InterviewForm form) {
		// TODO Auto-generated method stub
		InterviewPojo pojo = new InterviewPojo();
		SVCUtil.populateInterviewPojoPojo(form,pojo);
		return commonDao.addNewInterview(pojo);
	}
}
