package com.emp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SalaryController {

	@RequestMapping(value="/salaryDetailsPage")
	public String viewSalaryDetails(){
		return "salaryDetails";
	}
}
