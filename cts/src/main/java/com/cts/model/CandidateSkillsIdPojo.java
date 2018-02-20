package com.cts.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CandidateSkillsIdPojo implements Serializable {

	private static final long serialVersionUID = 1L;

	public CandidateSkillsIdPojo() {
		// TODO Auto-generated constructor stub
	}

	@Column(name = "candidateid")
	private int candidateId;
	@Column(name = "skillid")
	private int skillId;

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public int getSkillId() {
		return skillId;
	}

	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + candidateId;
		result = prime * result + skillId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CandidateSkillsIdPojo other = (CandidateSkillsIdPojo) obj;
		if (candidateId != other.candidateId)
			return false;
		if (skillId != other.skillId)
			return false;
		return true;
	}
	
	
}
