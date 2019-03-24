package com.anv.intv.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.anv.intv.entities.CandidatePojo;
import com.anv.intv.entities.InterviewPojo;
import com.anv.intv.entities.QuestionsPojo;
import com.anv.intv.form.CandidateDetailsForm;
import com.anv.intv.form.InterviewForm;
import com.anv.intv.form.Question;

public class SVCUtil {

	public static void populateCandidatePojo(CandidateDetailsForm form,CandidatePojo pojo) {
		//mandatory fields
		pojo.setName(form.getName());
		pojo.setPrimaryPhone(Integer.parseInt(form.getPrimaryPhone()));
		pojo.setEmail(form.getEmail());
		
		// optional fields
		if(form.getSecondaryPhone() != null && form.getSecondaryPhone() != "") pojo.setSecondaryPhone(Integer.parseInt(form.getSecondaryPhone()));
	}
	
	public static void populateQuestionPojo(Question form,QuestionsPojo pojo) {
		//mandatory fields
		pojo.setDescription(form.getDesc());
		pojo.setAnswer(form.getAns());
		pojo.setCategoryId(Integer.parseInt(form.getCategoryId()));
		pojo.setCategoryId(1000);
		
		// optional fields
	}
	
	public static List<Question> populateQuestionForms(List<QuestionsPojo> pojos) {
		// TODO Auto-generated method stub
		List<Question> questionsList = new ArrayList<Question>();
		for(QuestionsPojo pojo : pojos) {
			questionsList.add(new Question().createQuestion(pojo.getId().toString(),pojo.getCategoryId().toString(),"java",pojo.getDescription(),
					pojo.getAnswer()));
		}
		return questionsList;
	}
	
	public static void populateCandidateForm(CandidateDetailsForm form,CandidatePojo pojo) {
		//mandatory fields		
		form.setName(pojo.getName());
		form.setEmail(pojo.getEmail());
		form.setPrimaryPhone(Integer.toString(pojo.getPrimaryPhone()));
		
		// optional fields
		if(pojo.getSecondaryPhone() != 0 ) form.setSecondaryPhone(Integer.toString(pojo.getSecondaryPhone()));
	}

	public static void populateInterviewPojoPojo(InterviewForm form, InterviewPojo pojo) {
		// TODO Auto-generated method stub
		//pojo.setDay(Date.parse(form.getDate()));
		pojo.setTitle(form.getTitle());
		pojo.setDesc(form.getDesc());
		pojo.setMode(form.getMode());
		pojo.setRequestor(form.getRequestor());
		
	}
}
