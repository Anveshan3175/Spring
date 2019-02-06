package com.anv.intv.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_candidate_interview_questions")
public class CandidateInterviewQuestionsPojo {

	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "candidate_id")
	private int candidateId;
	
	@Column(name = "interview_id")
	private int interviewId;
	
	@Column(name = "question_id")
	private int questionId;
	
	@Column(name = "candidate_ans")
	private String candidateAnswer;

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public int getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getCandidateAnswer() {
		return candidateAnswer;
	}

	public void setCandidateAnswer(String candidateAnswer) {
		this.candidateAnswer = candidateAnswer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
