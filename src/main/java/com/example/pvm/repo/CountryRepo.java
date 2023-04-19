package com.example.pvm.repo;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.pvm.model.Country;

public interface CountryRepo extends JpaRepository<Country, Long> {

	@Query(value = "select * from mst_country mc \r\n" + "where mc.is_active =true", nativeQuery = true)
	public List<Map<String, Object>> getAllCountires();
	
	@Query(value = "select ms.id as stateId ,ms.\"name\" as stateName,mc2.id as cityId  ,mc2.\"name\" as cityName\r\n"
			+ "from mst_country mc \r\n"
			+ "inner join mst_state ms \r\n"
			+ "on ms.country_id =mc.id and ms.is_active =true\r\n"
			+ "inner join mst_city mc2 \r\n"
			+ "on mc2.state_id =ms.id and mc2.is_active =true\r\n"
			+ "where  mc.is_active =true\r\n"
			+ "order by ms.id", nativeQuery = true)
	public List<Map<String, Object>> getAllState();

}
