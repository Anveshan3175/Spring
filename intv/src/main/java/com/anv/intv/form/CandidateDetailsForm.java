package com.anv.intv.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CandidateDetailsForm {

	@NotNull
    @Size(min=2, max=30)
    private String name;
	
	@NotNull(message = "Primary phone is mandatory")
	@Size(min=10,max=10,message = "Enter 10 digit phone number")
	private String primaryPhone;
	
	//@Size(min=10,max=10,message = "Enter 10 digit phone number")
	//@Nullable
	private String secondaryPhone;
	
	//@NotEmpty(message = "Email is mandatory")
	@NotEmpty(message = "{email.notempty}")
	@Email(message = "Enter valid email")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}
    
    
	
}
