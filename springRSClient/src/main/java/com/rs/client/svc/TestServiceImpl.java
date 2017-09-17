package com.rs.client.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rs.client.beans.Country;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	private RestTemplate restTemplate;

	
	@Override
	public Country getCountry(int id) {
		// TODO Auto-generated method stub
		//restTemplate = new RestTemplate();
		System.out.println("restTemplate -----"+restTemplate);
		String getUrl = "http://localhost:9090/springRest/country/" + id;
		Country response = restTemplate.getForObject(getUrl, Country.class);
		return response;
	}


	@Override
	public List<Country> getCountries() {
		// TODO Auto-generated method stub
		String getUrl = "http://localhost:9090/springRest/listCountries";
		ResponseEntity<List<Country>> getResponse =
		        restTemplate.exchange(getUrl,
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Country>>() {
		            });
		List<Country> countries = getResponse.getBody();
		return countries;
	}

}
