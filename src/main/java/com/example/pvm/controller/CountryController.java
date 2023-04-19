package com.example.pvm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pvm.model.Country;
import com.example.pvm.service.CountryService;

@RestController
@RequestMapping("/api/Country")
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("")
	public ResponseEntity<List<Map<String, Object>>> getAllCountries() throws Exception {
		try {
			List<Map<String, Object>> countries = countryService.getAllCountries();
			System.out.println(countries);
			return new ResponseEntity<List<Map<String, Object>>>(countries, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception();
		}

	}
	
	@GetMapping("/{countryId}")
	public ResponseEntity<List<Map<String, Object>>> getAllStateByCountryId(@PathVariable long countryId) throws Exception {
		try {
			List<Map<String, Object>> countries = countryService.getAllStateByCountryId(countryId);
			System.out.println(countries);
			return new ResponseEntity<List<Map<String, Object>>>(countries, HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception();
		}

	}

}
