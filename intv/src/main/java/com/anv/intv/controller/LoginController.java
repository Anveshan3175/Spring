package com.anv.intv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
    
    @PostMapping("/validateLogin")
    public String validateLogin(Model model) {
    	logger.debug("-------------- validateLogin invoked -----------------------");
    	model.addAttribute("greeting", "Hi there , from controller");
        return "home";
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
