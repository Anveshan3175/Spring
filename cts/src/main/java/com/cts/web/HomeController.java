package com.cts.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cts.dto.ConfiguredSkillsList;
import com.cts.exception.CustomGenericException;
import com.cts.form.CandidateForm;
import com.cts.form.SkillForm;
import com.cts.formatter.SkillFormEditor;
import com.cts.svc.ICandidateDetailsSvc;
import com.cts.util.Utils;

@Controller
public class HomeController {

	public HomeController() {
		// TODO Auto-generated constructor stub
	}

	// Autowire components
	@Autowired
	private ICandidateDetailsSvc candidateSvc;

	@Autowired
	private ConfiguredSkillsList configuredSkillsList;
	
	// Logger
	private static final Logger logger = Logger.getLogger(HomeController.class);
	

	// Controller methods
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		return "homePage";
	}

	/* Add and save new candidate */
	@RequestMapping(value = "/candidate/add", method = RequestMethod.GET)
	public String newCandidateForm(Model model) {
		CandidateForm form = new CandidateForm();
		form.setAllSkills(getAllSkillsForm());
		model.addAttribute("candidate", form);
		return "newCandidate";
	}

	// Path is configured relatively here
	@RequestMapping(value = "/candidate/submit", method = RequestMethod.POST)
	public String submitNewCandidate(ModelMap model,@Valid  @ModelAttribute("candidate") CandidateForm form,
			BindingResult bindingResult) {
		if (logger.isDebugEnabled()) {
			logger.debug("createCandidate is executed!");
		}
		if (bindingResult.hasErrors()) {
			return "newCandidate";
		}
		try {
			form.setAllSkills(getAllSkillsForm());
			candidateSvc.saveCandidate(form);
		}catch(RuntimeException e) {
			 ModelAndView mv = new ModelAndView();
			 mv.addObject("exception", e);
			 //mv.addObject("url", req.getRequestURL());
			 mv.addObject("errMsg", e.getMessage());
			 mv.setViewName("newCandidate");
			 mv.addObject("candidate", form);
			 Utils.populateSelectedSkillsForUI(form.getSelectedSkills(), form.getAllSkills());
			throw new CustomGenericException("500",mv);
		}
		model.addAttribute("candidate", form);
		return "newCandidate";
	}

	/* Edit and save existing candidate */
	@RequestMapping(value = "/candidate/edit", method = RequestMethod.GET)
	public String editCandidateForm(Model model) {
		Integer canId = 1008;
		CandidateForm form = candidateSvc.getCandidateDetails(canId);
		form.setAllSkills(getAllSkillsForm());
		Utils.populateSelectedSkillsForUI(form.getSelectedSkills(), form.getAllSkills());
		model.addAttribute("candidate", form);
		return "editCandidate";
	}

	// Path is configured relatively here
	@RequestMapping(value = "/candidate/editSubmit", method = RequestMethod.POST)
	public String submitEditCandidate(ModelMap model, @ModelAttribute("candidate") CandidateForm form,
			BindingResult bindingResult) {
		if (logger.isDebugEnabled()) {
			logger.debug("createCandidate is executed!");
		}
		if (bindingResult.hasErrors()) {
			return "editCandidate";
		}
		form.setAllSkills(getAllSkillsForm()); // Not sure this is still needed
		candidateSvc.updateCandidateDetails(form);
		Utils.populateSelectedSkillsForUI(form.getSelectedSkills(), form.getAllSkills());
		model.addAttribute("candidate", form);
		return "editCandidate";
	}

	@RequestMapping(value = "/skill/add", method = RequestMethod.GET)
	public String newSkillForm(Model model) {
		model.addAttribute("skill", new SkillForm());
		return "newSkill";
	}

	@RequestMapping(value = "/skill/save", method = RequestMethod.POST)
	public String saveNewSkill(ModelMap model, @ModelAttribute("skill") SkillForm form, BindingResult bindingResult) {
		if (logger.isDebugEnabled()) {
			logger.debug("saveNewSkill is executed!");
			logger.debug(form.getName());
			logger.debug(form.getDescription());
		}
		model.addAttribute("skill", form);
		return "newSkill";
	}

	@RequestMapping(value = "/technology/add", method = RequestMethod.GET)
	public String newTechnologyForm(Model model) {
		model.addAttribute("technology", new SkillForm());
		return "newTechnology";
	}

	@RequestMapping(value = "/technology/save", method = RequestMethod.POST)
	public String saveNewTechnology(ModelMap model, @ModelAttribute("technology") SkillForm form,
			BindingResult bindingResult) {
		if (logger.isDebugEnabled()) {
			logger.debug("saveNewTechnology is executed!");
			logger.debug(form.getName());
			logger.debug(form.getDescription());
		}
		model.addAttribute("technology", form);
		return "newTechnology";
	}

	/* Customize binding */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields(new String[] { "allSkills" });
		binder.registerCustomEditor(SkillForm.class, new SkillFormEditor());
	}

	public List<SkillForm> getAllSkillsForm() {
		/*
		 * List<SkillForm> skills = new ArrayList<SkillForm>(); skills.add(new
		 * SkillForm(1, "JAVA", "Java Lanaguage")); skills.add(new SkillForm(2,
		 * "J2EE", "J2EE Lanaguage")); skills.add(new SkillForm(3, "ORACLE",
		 * "ORACLE Lanaguage")); skills.add(new SkillForm(4, "SALESFORCE",
		 * "SALESFORCE Lanaguage")); skills.add(new SkillForm(5, "ADF",
		 * "ADF Lanaguage")); skills.add(new SkillForm(6, "BI", "BI Lanaguage"
		 * ));
		 */
		logger.debug("getAllSkillsForm : Begin");
		List<SkillForm> skills = configuredSkillsList.getSkillList();
		logger.debug("configuredSkillsList : "+skills);
		logger.debug("getAllSkillsForm : End");
		return skills;
	}
	
	@ExceptionHandler(value = {CustomGenericException.class})
	public ModelAndView handleAllException(CustomGenericException ex, 
	HttpServletRequest req) {
	    ModelAndView model = ex.getView();
	    model.addObject("url", req.getRequestURL());
	    return model;
	}

}
