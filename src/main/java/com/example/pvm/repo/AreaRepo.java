package com.example.pvm.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.pvm.model.Area;

public interface AreaRepo extends JpaRepository<Area, Long> {
	@Query(value = "select * from mst_area ma \r\n"
			+ "where ma.city_id =:cityId and ma.is_active =true", nativeQuery = true)
	public List<Map<String, Object>> getAllAreas(int cityId);

}
