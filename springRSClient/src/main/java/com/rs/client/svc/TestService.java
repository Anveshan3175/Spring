package com.rs.client.svc;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rs.client.beans.Country;

@Service
public interface TestService {

	Country getCountry(int id);
	List<Country> getCountries();
}
