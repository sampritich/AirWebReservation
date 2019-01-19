package com.airline.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table
public class Passenger implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int passengerId;
	
	@Column(nullable=false)
	private String salutation;
	
	@Column(nullable=false)
	private String firstName;
	
	@Column(nullable=false)
	private String lastName;
	
	@Column(nullable=false)
	private String passengerType;
	
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn(name="specialServiceId")
	
	private SpecialService specialService;


	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassengerType() {
		return passengerType;
	}

	public void setPassengerType(String passengerType) {
		this.passengerType = passengerType;
	}

	public SpecialService getSpecialService() {
		return specialService;
	}

	public void setSpecialService(SpecialService specialService) {
		this.specialService = specialService;
	}



	public Passenger(int passengerId, String salutation, String firstName, String lastName, String passengerType,
			SpecialService specialService) {
		super();
		this.passengerId = passengerId;
		this.salutation = salutation;
		this.firstName = firstName;
		this.lastName = lastName;
		this.passengerType = passengerType;
		this.specialService = specialService;

	}

	public Passenger() {
		super();
	}
	
	
	
}
