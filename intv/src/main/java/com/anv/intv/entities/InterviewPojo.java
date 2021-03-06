package com.anv.intv.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_interviews")
public class InterviewPojo {

	@Id
	@Column(name = "interview_id")
	private int id;
	
	@Column(name = "interview_title")
	private String title;
	
	@Column(name = "interview_mode")
	private String mode;
	
	@Column(name = "interview_date")
	private Date day;

	@Column(name = "interview_requestor")
	private String requestor;
	
	@Column(name = "interview_desc")
	private String desc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getRequestor() {
		return requestor;
	}

	public void setRequestor(String requestor) {
		this.requestor = requestor;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
		
	public Date getDay() {
		return day;
	}

	public void setDay(Date day) {
		this.day = day;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
}
