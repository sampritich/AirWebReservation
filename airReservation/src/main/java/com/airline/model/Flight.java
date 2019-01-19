package com.airline.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Flight implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String flightId;
	
	@Column(nullable=false)
	private String airlineName;
	
	@Column(nullable=false)
	private String destination;
	
	@Column(nullable=false)
	private String source;
	
	@Column(nullable=false)
	private Date date;
	
	@Column(nullable=false)
	private Time departureTime;
	
	@Column(nullable=false)
	private Time arrivalTime;
	
	@Column(nullable=false)
	private float duration;
	
	@Column(nullable=false)
	private int businessSeat;
	
	@Column(nullable=false)
	private int economySeat;
	
	@Column(nullable=false)
	private float businessPrice;
	
	@Column(nullable=false)
	private float economyPrice;

	public Flight() {
		super();
	}

	public Flight(String flightId, String airlineName, String destination, String source, Date date, Time departureTime,
			Time arrivalTime, float duration, int businessSeat, int economySeat, float businessPrice,
			float economyPrice) {
		super();
		this.flightId = flightId;
		this.airlineName = airlineName;
		this.destination = destination;
		this.source = source;
		this.date = date;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.duration = duration;
		this.businessSeat = businessSeat;
		this.economySeat = economySeat;
		this.businessPrice = businessPrice;
		this.economyPrice = economyPrice;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public float getDuration() {
		return duration;
	}

	public void setDuration(float duration) {
		this.duration = duration;
	}

	public int getBusinessSeat() {
		return businessSeat;
	}

	public void setBusinessSeat(int businessSeat) {
		this.businessSeat = businessSeat;
	}

	public int getEconomySeat() {
		return economySeat;
	}

	public void setEconomySeat(int economySeat) {
		this.economySeat = economySeat;
	}

	public float getBusinessPrice() {
		return businessPrice;
	}

	public void setBusinessPrice(float businessPrice) {
		this.businessPrice = businessPrice;
	}

	public float getEconomyPrice() {
		return economyPrice;
	}

	public void setEconomyPrice(float economyPrice) {
		this.economyPrice = economyPrice;
	}

}
