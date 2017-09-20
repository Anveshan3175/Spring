package com.rs.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rs.beans.Country;
import com.rs.beans.CountryList;
import com.rs.beans.Greeting;

@RestController
public class TestController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    
    @RequestMapping(value = "/countries", method = RequestMethod.GET)
    public CountryList getCountries()
    {
     CountryList countryList=createCountryList();
     return countryList;
    }
    
    @RequestMapping(value = "/country/{id}", method = RequestMethod.GET)
    public Country getCountryById(@PathVariable int id)
    {
     List<Country> listOfCountries = new ArrayList<Country>();
     CountryList countryList=createCountryList();
     listOfCountries=countryList.getListOfCountries();
     for (Country country: listOfCountries) {
      if(country.getId()==id)
       return country;
     } 
     return null;
    }
    
    @RequestMapping(value = "/listCountries", method = RequestMethod.GET)
    public List<Country> listCountries()
    {
     CountryList countryList=createCountryList();
     return countryList.getListOfCountries();
    }
   
    @RequestMapping(value = "/addCountry", method = RequestMethod.POST)
    public ResponseEntity<Country> addCountry(@RequestBody Country country)
    {
    	System.out.println("--------------------in coming country is ------"+country);
    	return new ResponseEntity<Country>(country,HttpStatus.CREATED);
    }
    
   
    @RequestMapping(value = "/addSelectedCountry", method = RequestMethod.POST)
    public Country addSelectedCountry(@RequestBody Country country)
    {
    	System.out.println("--------------------in coming addSelectedCountry is ------"+country);
    	return country;
    }
    
    @RequestMapping(value = "/addCountries", method = RequestMethod.POST)
    public ResponseEntity<List<Country>> addCountries(@RequestBody List<Country> countries)
    {
    	System.out.println("-------addCountries-------------in coming Countries is ---------------"+countries);
    	return new ResponseEntity<List<Country>>(countries,HttpStatus.CREATED);
    }
    
   /// Utiliy method to create country list.
    public CountryList createCountryList()
    {
     Country indiaCountry=new Country(1, "India");
     Country chinaCountry=new Country(4, "China");
     Country nepalCountry=new Country(3, "Nepal");
     Country bhutanCountry=new Country(2, "Bhutan");
    
     List<Country> listOfCountries = new ArrayList<Country>();
     listOfCountries.add(indiaCountry);
     listOfCountries.add(chinaCountry);
     listOfCountries.add(nepalCountry);
     listOfCountries.add(bhutanCountry);
     return new CountryList(listOfCountries);
    }
}
