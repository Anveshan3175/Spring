package com.rs.client.svc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rs.client.beans.Country;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Country getCountry(int id) {
		// TODO Auto-generated method stub
		System.out.println("restTemplate -----" + restTemplate);
		String getUrl = "http://localhost:9090/springRest/country/" + id;
		Country response = restTemplate.getForObject(getUrl, Country.class);
		return response;
	}

	@Override
	public List<Country> getCountries() {
		// TODO Auto-generated method stub
		String getUrl = "http://localhost:9090/springRest/listCountries";
		ResponseEntity<List<Country>> getResponse = restTemplate.exchange(getUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Country>>() {
				});
		List<Country> countries = getResponse.getBody();
		return countries;
	}

	@Override
	public Country addCountry(Country country) {
		// TODO Auto-generated method stub
		String postUrl = "http://localhost:9090/springRest/addCountry";

		// make the object

		// set your headers
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		HttpEntity<Country> httpEntity = new HttpEntity<Country>(country, headers);
		ResponseEntity<Country> responseEntity = restTemplate.exchange(postUrl, HttpMethod.POST, httpEntity,
				Country.class);
		HttpStatus statusCode = responseEntity.getStatusCode();

		if (statusCode == HttpStatus.CREATED) {
			country = responseEntity.getBody();
		}
		return country;
	}

	@Override
	public Country addSelectedCountry(Country coutry) {
		// TODO Auto-generated method stub
		String postUrl = "http://localhost:9090/springRest/addSelectedCountry";
		Country country = new Country(5, "Syria");
		Country result = restTemplate.postForObject(postUrl, country, Country.class);
		return result;
	}

	@Override
	public void addCountries() {
		// TODO Auto-generated method stub
		String postUrl = "http://localhost:9090/springRest/addCountries";
		HttpHeaders headers = new HttpHeaders();
		//headers.setContentType(MediaType.APPLICATION_XML);
		
		List<Country> list = new ArrayList<Country>();
		list.add(new Country(6,"Egypt"));
		list.add(new Country(7,"Libya"));
		list.add(new Country(8,"Australia"));
		
		HttpEntity<List<Country>> httpEntity = new HttpEntity<List<Country>>(list, headers);
		
		ResponseEntity<List<Country>> getResponse = restTemplate.exchange(postUrl, HttpMethod.POST, httpEntity,
				new ParameterizedTypeReference<List<Country>>() {
				});
		list = null;
		list = getResponse.getBody();
		System.out.println("----------------------addCountries reponse in client -------------------"+list);
		System.out.println("----------------------addCountries status  in client -------------------"+getResponse.getStatusCode());
		
	}

}
