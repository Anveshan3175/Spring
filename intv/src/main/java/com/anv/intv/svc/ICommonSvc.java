package com.anv.intv.svc;

import java.util.List;

import com.anv.intv.entities.QuestionsPojo;
import com.anv.intv.form.CandidateDetailsForm;
import com.anv.intv.form.QuestionsForm;

public interface ICommonSvc {

	boolean addCandidate(CandidateDetailsForm form); 
	public void addQuestion(QuestionsForm form);
	public List<QuestionsForm> getAllQuestions();
}
