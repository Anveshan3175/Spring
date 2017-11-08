package com.tap.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CustomerController {


	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String listPersons(Model model) {
		return "customer";
	}


}
