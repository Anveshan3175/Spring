package com.anv.intv.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_candidate_interview")
public class CandidateInterviewPojo {

	@Column(name = "candidate_id")
	private int candidateId;
	
	@Column(name = "interview_id")
	private int interviewId;
	
	@Column(name = "interview_time")
	private Date time;
	
	@Column(name = "interview_result")
	private String result;

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

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	
}
