package com.example.pvm.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mst_city")
public class City {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int latitude;
	
	private int longitude;
	
	private String name;
	
	private boolean isActive;
	
	@ManyToOne
	@JoinColumn(name = "state_id")
	private State state;
	
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
	private List<Area> areas = new ArrayList<>();

	public City() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getLatitude() {
		return latitude;
	}



	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}



	public int getLongitude() {
		return longitude;
	}



	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}
	

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}


	@Override
	public String toString() {
		return "City [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", name=" + name
				+ ", isActive=" + isActive + ", state=" + state + ", areas=" + areas + "]";
	}

	
	
	

}
