package com.anvesh.person.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.anvesh.person.model.Login;
import com.anvesh.person.model.Person;
import com.anvesh.person.svc.PersonService;

@Controller
public class PersonController {

	private PersonService personService;

	@Autowired(required = true)
	@Qualifier(value = "personService")
	public void setPersonService(PersonService ps) {
		this.personService = ps;
	}

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}

	// For add and update person both
	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person p) {

		if (p.getName() == null || "".equals(p.getName())) {
			System.out.println("Person is empty");
		} else if (p.getId() == null || p.getId() == 0) {
			// new person, add it
			this.personService.addPerson(p);
		} else {
			// existing person, call update
			this.personService.updatePerson(p);
		}

		return "redirect:/persons";

	}

	@RequestMapping("/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {

		this.personService.removePerson(id);
		return "redirect:/persons";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("person", this.personService.getPersonById(id));
		model.addAttribute("listPersons", this.personService.listPersons());
		return "person";
	}

	// For add and update person both
	@RequestMapping(value = "/loginValidatew", method = RequestMethod.POST)
	public String validateLogin(@ModelAttribute("login") Login login) {

		if (login.getName() != null || login.getPassword() != null) {
			// new person, add it
			if (personService.validateLogin(login.getName(), login.getPassword())) {
				return "redirect:/persons";
			}
		} else {
			// existing person, call update
			System.out.println(
					"===================================================================Hi THere " + login.getName());
			return "redirect:/login";
		}
		return "redirect:/login";

	}
}
