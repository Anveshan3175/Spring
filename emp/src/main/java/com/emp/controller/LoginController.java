package com.emp.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.emp.forms.LoginForm;
import com.emp.svc.LoginSvc;

/*
 * http://www.codejava.net/frameworks/spring/configuring-spring-mvc-jdbctemplate-with-jndi-data-source-in-tomcat
 * http://stackoverflow.com/questions/9183321/how-to-use-jndi-datasource-provided-by-tomcat-in-spring
 * https://tomcat.apache.org/tomcat-7.0-doc/jndi-resources-howto.html#context.xml_configuration
 */
@Controller
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginSvc svc;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView launchLoginPage() {
		logger.debug("Entering : launchLoginPage ");

		ModelAndView model = new ModelAndView();
		model.setViewName("login");

		logger.debug("Exiting : launchLoginPage ");
		return model;
	}

	@RequestMapping(value = { "/welcome" }, method = RequestMethod.GET)
	public ModelAndView validateLogin(@ModelAttribute("loginForm") LoginForm form) {

		logger.debug("Entering : validateLogin ");

		ModelAndView model = new ModelAndView();

		logger.info("Login Name :" + form.getLoginName());
		logger.info("Login Password :" + form.getPassword());
		
		if(null == svc){
			logger.error("svc is null. Issue in Injection of the SVC bean");
			throw new RuntimeException("svc is null. Issue in Injection of the SVC bean");
		}
		
		if (svc.validateLogin(form.getLoginName(),form.getPassword())) {
			model.setViewName("welcome");
		} else {
			model.setViewName("login");
		}
		
		logger.debug("Exiting : validateLogin ");
		return model;
	}

	/*
	 * @RequestMapping(value = {"/welcome"},method = RequestMethod.GET) public
	 * ModelAndView validateLogin(){ ModelAndView model = new ModelAndView();
	 * model.setViewName("welcome"); return model; }
	 */
}
