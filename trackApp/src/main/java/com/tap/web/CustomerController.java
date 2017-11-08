package com.tap.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tap.svc.CustomerSvc;

@Controller
public class CustomerController {

	@Autowired
	private CustomerSvc customerSvc;

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		model.addAttribute("listCustomers", customerSvc.getCustomers());
		return "customer";
	}


}
