package com.anv.intv.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.anv.intv.dao.ICommonDao;
import com.anv.intv.entities.CandidatePojo;
import com.anv.intv.entities.QuestionsPojo;
import com.anv.intv.form.CandidateDetailsForm;
import com.anv.intv.form.QuestionsForm;

@Service("commonSVC")
public class CommonSvcImpl implements ICommonSvc {

	@Autowired
	private ICommonDao commonDao;
	
	@Override
	@Transactional
	public boolean addCandidate(CandidateDetailsForm form) {
		// TODO Auto-generated method stub
		CandidatePojo pojo = new CandidatePojo();
		populateCandidatePojo(form,pojo);
		commonDao.addCandidate(pojo);
		
		return false;
	}

	
	private void populateCandidatePojo(CandidateDetailsForm form,CandidatePojo pojo) {
		//mandatory fields
		pojo.setName(form.getName());
		pojo.setPrimaryPhone(Integer.parseInt(form.getPrimaryPhone()));
		pojo.setEmail(form.getEmail());
		
		// optional fields
		if(form.getSecondaryPhone() != null && form.getSecondaryPhone() != "") pojo.setSecondaryPhone(Integer.parseInt(form.getSecondaryPhone()));
	}


	@Override
	@Transactional
	public void addQuestion(QuestionsForm form) {
		// TODO Auto-generated method stub
		QuestionsPojo pojo = new QuestionsPojo();
		populateQuestionPojo(form,pojo);
		commonDao.addQuestion(pojo);
	}
	
	private void populateQuestionPojo(QuestionsForm form,QuestionsPojo pojo) {
		//mandatory fields
		pojo.setDescription(form.getDesc());
		pojo.setAnswer(form.getAns());
		pojo.setCategoryId(form.getCategoryId());
		pojo.setCategoryId(1000);
		
		// optional fields
	}


	@Override
	@Transactional
	public List<QuestionsForm> getAllQuestions() {
		// TODO Auto-generated method stub
		
		List<QuestionsPojo> pojos = commonDao.getAllQuestions();
		return populateQuestionForms(pojos);
	}


	private List<QuestionsForm> populateQuestionForms(List<QuestionsPojo> pojos) {
		// TODO Auto-generated method stub
		List<QuestionsForm> questionsList = new ArrayList<QuestionsForm>();
		for(QuestionsPojo pojo : pojos) {
			questionsList.add(new QuestionsForm().createQuestion(pojo.getId(),pojo.getCategoryId(),"java",pojo.getDescription(),
					pojo.getAnswer()));
		}
		return questionsList;
	}
}
