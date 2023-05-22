package com.example.pvm.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.pvm.service.AreaService;

@RestController
@RequestMapping("/api/Area")
public class AreaController {

	@Autowired
	private AreaService areaService;

	@GetMapping("")
	public ResponseEntity<List<Map<String, Object>>> getAllAreas(@RequestParam Optional<Integer> cityId)
			throws Exception {
		try {
			if (cityId.isPresent()) {
				return new ResponseEntity<List<Map<String, Object>>>(areaService.getAllAreas(cityId.get()),
						HttpStatus.OK);
			} else {
				// Handle the case when cityId is not provided
				// Return an appropriate response or throw an exception
				return new ResponseEntity<List<Map<String, Object>>>(areaService.getAllAreas(),
						HttpStatus.OK);
			}

		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception();
		}
	}

}
