package com.test.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rs.beans.Country;
import com.rs.beans.CountryList;


public class SpringRestTemplateMain {

	public static void main(String[] args) {
		RestfulClient restfulClient = new RestfulClient();
		restfulClient.getEntity();
		restfulClient.getEntities();
		restfulClient.listEntities();
	}
}

class RestfulClient {
	RestTemplate restTemplate;
	
	public RestfulClient(){
		restTemplate = new RestTemplate();
	}
	
	/**
	 * get entity
	 */
	public void getEntity(){
		System.out.println("Begin /GET request!");
		String getUrl = "http://localhost:9090/springRest/country/2";	
		ResponseEntity<Country> getResponse = restTemplate.getForEntity(getUrl, Country.class);
		if(getResponse.getBody() != null){
			System.out.println("Response for Get Request: " + getResponse.getBody().toString());	
		}else{
			System.out.println("Response for Get Request: NULL");
		}
	}
	
	public void getEntities(){
		String getUrl = "http://localhost:9090/springRest/countries";
		ResponseEntity<CountryList> getResponse = restTemplate.getForEntity(getUrl, CountryList.class);
		
		if(getResponse.getBody() != null){
			System.out.println("Response for Get Request: " + getResponse.getBody().toString());	
		}else{
			System.out.println("Response for Get Request: NULL");
		}
	}
	
	public void listEntities(){
		String getUrl = "http://localhost:9090/springRest/listCountries";
		
		ResponseEntity<List<Country>> getResponse =
		        restTemplate.exchange(getUrl,
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Country>>() {
		            });	
		if(getResponse.getBody() != null){
			System.out.println("Response for Get Request: " + getResponse.getBody().toString());	
		}else{
			System.out.println("Response for Get Request: NULL");
		}
	}
	
	/**
	 * put entity
	 */
/*	public void putEntity(){
		System.out.println("Begin /PUT request!");
		String putUrl = "http://localhost:8080/put/2";
		Customer puttCustomer = new Customer("Bush", 23);
		restTemplate.put(putUrl, puttCustomer);
	}*/
	
	/**
	 * delete entity
	 */
/*	public void deleteEntity(){
		System.out.println("Begin /DELETE request!");
		String deleteUl = "http://localhost:8080/delete/1";
		restTemplate.delete(deleteUl);
	}*/
	
	/**
	 * post entity
	 */
/*	public void postEntity(){
		System.out.println("Begin /POST request!");
		String postUrl = "http://localhost:9090/post";
		Customer customer = new Customer(123, "Jack", 23);
		ResponseEntity<String> postResponse = restTemplate.postForEntity(postUrl, customer, String.class);
		System.out.println("Response for Post Request: " + postResponse.getBody());
	}*/

}
