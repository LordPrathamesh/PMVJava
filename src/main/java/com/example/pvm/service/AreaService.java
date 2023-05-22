package com.example.pvm.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.pvm.repo.AreaRepo;

@Service
public class AreaService {

	@Autowired
	private AreaRepo areaRepo;

	public List<Map<String, Object>> getAllAreas(int cityId) {
		return areaRepo.getAllAreas(cityId);
	}

	public List<Map<String, Object>> getAllAreas() {
		return areaRepo.getAllAreas();
	}

}
