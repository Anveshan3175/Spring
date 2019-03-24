package com.anv.intv.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InterviewForm {

	@NotNull
    private String mode;
	
	@NotNull
	@Size(min=10,max=30,message = "Enter title of length between 10 and 30 characters")
    private String title;
	
	@NotNull
	private String date;
	
	@NotNull
    private String requestor;
	
	@NotNull
    private String desc;
	
	private String id;

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "InterviewForm [mode=" + mode + ", title=" + title + ", date=" + date + ", requestor=" + requestor
				+ ", desc=" + desc + ", id=" + id + "]";
	}
}
