package com.anv.intv.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CandidateDetailsForm {

	@NotNull
    @Size(min=2, max=30)
    private String name;
	
	@NotNull
	private Integer primaryPhone;
	
	private Integer secondaryPhone;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(Integer primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public Integer getSecondaryPhone() {
		return secondaryPhone;
	}

	public void setSecondaryPhone(Integer secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}
    
    
	
}
