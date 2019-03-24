package com.anv.intv.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.anv.intv.form.CandidateDetailsForm;
import com.anv.intv.form.InterviewForm;
import com.anv.intv.form.Question;
import com.anv.intv.form.QuestionsListForm;
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
	
	@GetMapping("/launchEditcandidate")
	public String editPersonInfo(@RequestParam("email") String email,Model model) {
		
		CandidateDetailsForm form = commonSVC.getCandidateByEmail(email);
		if(form != null) {
			model.addAttribute("candidateDetailsForm",form);
			return "candidateDetails";
		}
		return "home"; 
	}
	
	@GetMapping("/getQuestions")
	public String getQuestionsToDisplay(@RequestParam("category") String category,Model model) {
		List<Question> questions = commonSVC.getAllQuestions();
		/*
		 * model.addAttribute("questions", questionList); QuestionsListForm wrapper =
		 * new QuestionsListForm(); wrapper.setQuestions((ArrayList<Question>)
		 * questionList); model.addAttribute("wrapper",wrapper);
		 */
		
		// add all roles to model
        model.addAttribute("allQuestions", questions);
        // add empty project to model
        model.addAttribute("qform", new QuestionsListForm());
		return "questionsList";
	}
	
	@PostMapping(value="/addQuestions", params="action=assignQuestionsToUser")
	public String assignQuestionsTocandidate(@Valid QuestionsListForm qform,BindingResult result,Model model) {
		logger.debug("-------------- assignQuestionsTocandidate invoked -----------------------"+model.asMap().get("questionsFormWrapper"));
		
		if (result.hasErrors()) {
			return "questionsList";
		}
		List<Question> selectedQtns =
        		qform.getQuestions();
		System.out.println("---selected questions--START-");
		for(Question qtn : selectedQtns) {
			System.out.println("questions is "+qtn.getId());
		}
		System.out.println("---selected questions--END-");
		
        List<Question> nonNulQtns =
        		qform.getQuestions().stream().filter(
quest -> quest.getCheckBoxId() != null).collect(Collectors.toList());
        // print selected roles properties: name and id
        nonNulQtns.forEach(quest -> System.out.println(quest.getCheckBoxId()));
        
		QuestionsListForm wrapper1 = (QuestionsListForm) model.asMap().get("wrapper");
		List<Question> list = qform.getQuestions();
		return "takeInterview"; // take interview
	}
	
	
	@GetMapping("/addNewInterview")
	public String createNewInterview(InterviewForm form) {
		return "newInterview";
	}
	
	///   Test
	
	
	
	@GetMapping("/javaQuestions")
	public String getJavaQuestions(Model model) {
		QuestionsListForm wrapper = new QuestionsListForm();
		wrapper.setQuestions((ArrayList<Question>) commonSVC.getAllQuestions());
		model.addAttribute("questionsFormWrapper",wrapper);
		model.addAttribute("newQuestion",new Question());
		logger.debug("-------------- javaQuestions invoked -----------------------");
		return "javaQuestions";
	}
	
	private List<Question> getHardCodedQuestions() {
		
		List<Question> hardCodedQuestionsList = new ArrayList<Question>();
		hardCodedQuestionsList.add(new Question().createQuestion("10","100","java","What is dynamic binding",
				"It is runtime resolution of actual object to be acted upon"));
		hardCodedQuestionsList.add(new Question().createQuestion("20","100","java","What is inheritance",
				"The child object aquires all properties and behaviour from parent"));
		
		return hardCodedQuestionsList;
	}
	
	@PostMapping(value="/addQuestions", params="action=addQuestionToDB")
	public String addQuestionToDB(@Valid Question newQuestion,BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			return "javaQuestions";
		}
		commonSVC.addQuestion(newQuestion);
		model.addAttribute("questions", getHardCodedQuestions());
		return "javaQuestions";
	}



}
