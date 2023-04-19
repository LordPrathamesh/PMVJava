package com.example.pvm.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CountryDTO {

	public List<Map<String, Object>> getAllStateByCountryIdDto(List<Map<String, Object>> payload) {
	    List<Map<String, Object>> finalResp = new ArrayList<>();
	    Map<Integer, Map<String, Object>> stateMap = new HashMap<>();

	    for (Map<String, Object> map : payload) {
	        int stateId = Integer.parseInt(map.get("stateid").toString());
//	        System.out.println(stateId);
	        Map<String, Object> state = stateMap.get(stateId);

	        if (state == null) {
	            state = new HashMap<>();
	            state.put("stateid", stateId);
	            state.put("statename", map.get("statename"));

	            List<Map<String, Object>> cities = new ArrayList<>();
	            Map<String, Object> city = new HashMap<>();
	            city.put("cityid", map.get("cityid"));
	            city.put("cityname", map.get("cityname"));
	            cities.add(city);

	            state.put("cities", cities);
	            stateMap.put(stateId, state);
//	            System.out.println("1==>>"+stateMap);

	        } else {
	            List<Map<String, Object>> cities = (List<Map<String, Object>>) state.get("cities");
	            Map<String, Object> city = new HashMap<>();
	            city.put("cityid", map.get("cityid"));
	            city.put("cityname", map.get("cityname"));
	            cities.add(city);
//	            System.out.println("2==>>"+cities);
	        }
	    }

	    for (Map<String, Object> state : stateMap.values()) {
	        finalResp.add(state);
	    }

	    return finalResp;
	}

}

//payload.forEach(x -> {
//	List<Map<String, Object>> cities = new ArrayList<>();
//	x.keySet().forEach(y -> {
//		Map<String, Object> city = new HashMap<>();
//		city.put("cityname", x.get("cityname"));
//		city.put("cityid", x.get("cityid"));
//		System.out.println(city);
//		cities.add(city);
//	});
//	finalResp.add(new HashMap<String,Object>() {
//		{
//			put("stateid", x.get("stateid"));
//			put("statename", x.get("statename"));
//			put("cities", cities);
//		}
//	});
//});