package com.example.pvm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pvm.model.Country;
import com.example.pvm.repo.CountryRepo;

@Service
public class CountryService {

	@Autowired
	private CountryRepo countryRepo;

	public List<Map<String, Object>> getAllCountries() {
		List<Map<String, Object>> countries = countryRepo.getAllCountires();
		return countries;
	}
	
	public List<Map<String, Object>> getAllStateByCountryId(long countryId) {
		List<Map<String, Object>> countries = countryRepo.getAllStateByCountryId(countryId);
		return countries;
	}

}
