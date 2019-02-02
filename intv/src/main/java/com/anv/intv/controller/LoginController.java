package com.anv.intv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.anv.intv.svc.IUserDetailsSVC;

@Controller
public class LoginController {

	@Autowired
	private IUserDetailsSVC userSvc;
	
	Logger logger = LoggerFactory.getLogger(LoginController.class);
	
    @GetMapping("/login")
    public String showForm() {
    	logger.debug("-------------- login invoked -----------------------");
        return "login";
    }
    
    @GetMapping("/takeInterview")
    public String showInterviewForm() {
    	logger.debug("-------------- Interview invoked -----------------------");
    	boolean isValidlogin = userSvc.validateLoginUser("tester", "admin");
        return "takeInterview";
    }
    
    @GetMapping("/javaQuestions")
    public String getJavaQuestions() {
    	logger.debug("-------------- javaQuestions invoked -----------------------");
        return "javaQuestions";
    }
}
