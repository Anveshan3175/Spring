package com.rs.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.rs.client.beans.Country;
import com.rs.client.svc.TestService;

@RestController
public class TestClientController {

	@Autowired
	private TestService svc;

	@RequestMapping(value = "/country/{id}",method = RequestMethod.GET)
	public ResponseEntity<Country> getCountry(@PathVariable("id") int id){
		
		Country country = svc.getCountry(id);
		System.out.println("country details "+country);
        if (country == null) {
            return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Country>(country, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public String getHome(){
		return "index";
	}
	
	@RequestMapping(value = "/countries",method = RequestMethod.GET)
	public ModelAndView getCountry(){
		
		List<Country> countries = svc.getCountries();
		System.out.println(countries);

		ModelAndView page = new ModelAndView();
		page.setViewName("countries");
		return page;

	}
}
