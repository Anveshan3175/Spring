package com.anv.intv.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.anv.intv.form.CandidateDetailsForm;
import com.anv.intv.form.QuestionsForm;
import com.anv.intv.svc.ICommonSvc;

@Controller
public class CommonController {

	@Autowired
	private ICommonSvc commonSVC;
	
	Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@GetMapping("/addcandidate")
	public String showForm(CandidateDetailsForm candidateDetailsForm) {
		return "candidateDetails";
	}
	
	@PostMapping("/validatecandidate")
	public String checkPersonInfo(@Valid CandidateDetailsForm form, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "candidateDetails";
		}
		if(commonSVC.addCandidate(form)) {
			model.addAttribute("addCondidate","Candidate is added successfully");
		}
		else {
			model.addAttribute("addCondidate","Candidate is not added");
		}
		return "home"; 
	}
	
	@GetMapping("/getQuestions")
	public String getQuestionsToDisplay(QuestionsForm questionsForm, Model model) {
		model.addAttribute("questions", getHardCodedQuestions());
		return "javaQuestions";
	}
	
	@GetMapping("/javaQuestions")
	public String getJavaQuestions(QuestionsForm questionsForm,Model model) {
		model.addAttribute("questions", commonSVC.getAllQuestions());
		logger.debug("-------------- javaQuestions invoked -----------------------");
		return "javaQuestions";
	}
	
	private List<QuestionsForm> getHardCodedQuestions() {
		
		List<QuestionsForm> hardCodedQuestionsList = new ArrayList<QuestionsForm>();
		hardCodedQuestionsList.add(new QuestionsForm().createQuestion(10,100,"java","What is dynamic binding",
				"It is runtime resolution of actual object to be acted upon"));
		hardCodedQuestionsList.add(new QuestionsForm().createQuestion(20,100,"java","What is inheritance",
				"The child object aquires all properties and behaviour from parent"));
		
		return hardCodedQuestionsList;
	}
	
	@PostMapping(value="/addQuestions", params="action=addQuestionToDB")
	public String addQuestionToDB(@Valid QuestionsForm form,BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			return "javaQuestions";
		}
		commonSVC.addQuestion(form);
		model.addAttribute("questions", getHardCodedQuestions());
		return "javaQuestions";
	}


	@PostMapping(value="/addQuestions", params="action=assignQuestionsToUser")
	public String assignQuestionsTocandidate() {
		return "javaQuestions"; // take interview
	}
}
