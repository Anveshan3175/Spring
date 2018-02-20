package com.cts.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_candidate_skills")
public class CandidateSkillsPojo implements Serializable {

	private static final long serialVersionUID = 1L;

	public CandidateSkillsPojo() {
		// TODO Auto-generated constructor stub
	}
	
	@EmbeddedId
	private CandidateSkillsIdPojo id;
	
	public CandidateSkillsIdPojo getId() {
		return id;
	}

	public void setId(CandidateSkillsIdPojo id) {
		this.id = id;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "candidateid",insertable=false, updatable=false)
	private CandidatePojo candidatePojo;

	public CandidatePojo getCandidatePojo() {
		return candidatePojo;
	}

	public void setCandidatePojo(CandidatePojo candidatePojo) {
		this.candidatePojo = candidatePojo;
	}
}
