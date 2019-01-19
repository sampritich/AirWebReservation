package com.airline.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table
public class Cities implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String cityName;
	@Column(nullable=false)
	private String abbreviations;
	
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getAbbreviations() {
		return abbreviations;
	}
	public void setAbbreviations(String abbreviations) {
		this.abbreviations = abbreviations;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Cities(String cityName, String abbreviations) {
		super();
		this.cityName = cityName;
		this.abbreviations = abbreviations;
	}
	public Cities() {
		super();
	}
	
	
	

}
