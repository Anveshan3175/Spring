package com.anv.intv.svc;

import java.util.List;

import com.anv.intv.form.CandidateDetailsForm;
import com.anv.intv.form.InterviewForm;
import com.anv.intv.form.Question;

public interface ICommonSvc {

	boolean addCandidate(CandidateDetailsForm form); 
	public void addQuestion(Question form);
	public List<Question> getAllQuestions();
	public CandidateDetailsForm getCandidateByEmail(String email);
	
	boolean addNewInterview(InterviewForm form); 
}
