package com.tap.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tap.model.Customer;
import com.tap.svc.CustomerSvc;

@Controller
public class CustomerController {

	@Autowired
	private CustomerSvc customerSvc;

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String listCustomers(Model model) {
		model.addAttribute("customer", new Customer());
		model.addAttribute("listCustomers", customerSvc.getCustomers());
		return "customer";
	}

	@RequestMapping(value = "/addCustomer", method = RequestMethod.POST)
	public String addCustomers(@ModelAttribute("customer") Customer cust, ModelMap model) {
		try {
			customerSvc.addCustomer(cust);
		} catch (Exception e) {
			model.addAttribute("error", "Unable to add error");
		}
		model.addAttribute("customer", new Customer());
		model.addAttribute("listCustomers", customerSvc.getCustomers());
		return "customer";
	}
	
	@RequestMapping(value = "/searchCustomer", method = RequestMethod.GET)
	public String searchCustomers(@ModelAttribute("customer") Customer cust, ModelMap model) {
		
		if(null != cust.getId() &&  !("".equals(cust.getId()))){
			Customer searchedCustomer  = customerSvc.getCustomerById(cust.getId());
			
			if(searchedCustomer != null){
				List<Customer> searchList = new ArrayList<>();
				searchList.add(searchedCustomer);
				model.addAttribute("listCustomers", searchList);
			}
			else {
				model.addAttribute("listCustomers", new ArrayList<Customer>());
				model.addAttribute("error", "No customers found");
			}
		}
		else {
			model.addAttribute("listCustomers", customerSvc.getCustomers());
		}
		
		model.addAttribute("customer", new Customer());		
		return "customer";
	}
}
