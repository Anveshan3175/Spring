package com.anv.intv.dao;

import java.util.List;

import com.anv.intv.entities.CandidatePojo;
import com.anv.intv.entities.QuestionsPojo;

public interface ICommonDao {

	public boolean addCandidate(CandidatePojo pojo);
	public void addQuestion(QuestionsPojo pojo);
	public List<QuestionsPojo> getAllQuestions();
}
