package com.example.pvm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pvm.dto.CountryDTO;
import com.example.pvm.repo.CountryRepo;

@Service
public class CountryService {

	@Autowired
	private CountryRepo countryRepo;

	@Autowired
	private CountryDTO countryDto;

	public List<Map<String, Object>> getAllCountries() {
		List<Map<String, Object>> countries = countryRepo.getAllCountires();
		return countries;
	}

	public List<Map<String, Object>> getAllState() {
		List<Map<String, Object>> countries = countryRepo.getAllState();
		if (countries.size() > 0) {
			return countryDto.getAllStateByCountryIdDto(countries);
		}
		return countries;
//		return countries;
	}

}
