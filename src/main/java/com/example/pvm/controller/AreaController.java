package com.example.pvm.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pvm.service.AreaService;

@RestController
@RequestMapping("/api/Area")
public class AreaController {

	@Autowired
	private AreaService areaService;

	@GetMapping("/{cityId}")
	public ResponseEntity<List<Map<String, Object>>> getAllAreas(@PathVariable int cityId) throws Exception {
		try {
			return new ResponseEntity<List<Map<String, Object>>>(areaService.getAllAreas(cityId), HttpStatus.OK);

		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception();
		}
	}

}
