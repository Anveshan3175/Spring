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
	
	@RequestMapping(value = "/addCountry" ,method = RequestMethod.GET)
	public ModelAndView addCountry(){
		System.out.println("-------------------------addCountry in TestClientController---------------");

		 Country country = svc.addCountry(new Country(5, "Syria"));
		System.out.println("-------------------------country from  test controller : addCountry ---------------"+country);
		ModelAndView page = new ModelAndView();
		page.setViewName("countries");
		return page;

	}
	
	@RequestMapping(value = "/addCountries" ,method = RequestMethod.GET)
	public ModelAndView addCountries(){
		System.out.println("-------------------------addCountries in TestClientController---------------");
		
		svc.addCountries();
		ModelAndView page = new ModelAndView();
		page.setViewName("countries");
		return page;

	}
	
	@RequestMapping(value = "/addSelectedCountry")
	public ModelAndView addSelectedCountry(){
		System.out.println("-------------------------addSelectedCountry---------------");
		Country country = new Country(5, "Syria");
		country = null;
		country = svc.addSelectedCountry(country);
		System.out.println("-------------------------country from test controller : addSelectedCountry---------------"+country);
		ModelAndView page = new ModelAndView();
		page.setViewName("countries");
		return page;

	}
}
