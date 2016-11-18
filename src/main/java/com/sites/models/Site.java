package com.sites.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Site {
	
	//Fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name;
	String description;
	String condition;	
	Double latitude;
	Double longtitude;
	Integer yearStarted;
	
	//default constructor
	public Site(){}
	
	//practical constructor
	public Site(Long id, String name, String description, String condition, Double latitude, Double longtitude, Integer yearStarted){
		this.id = id;
		this.name = name;
		this.description = description;
		this.condition = condition;		
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.yearStarted = yearStarted;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongtitude() {
		return longtitude;
	}

	public void setLongitude(Double longtitude) {
		this.longtitude = longtitude;
	}

	public Integer getYearStarted() {
		return yearStarted;
	}

	public void setYearStarted(Integer yearStarted) {
		this.yearStarted = yearStarted;
	}

}
