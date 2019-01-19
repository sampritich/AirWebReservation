package com.airline.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table
public class Visa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String visaId;

	@Column
	private String country;	

	@Column
	private Date issueDate;

	@Column
	private Date expiryDate;

	

	public String getVisaId() {
		return visaId;
	}



	public void setVisaId(String visaId) {
		this.visaId = visaId;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public Date getIssueDate() {
		return issueDate;
	}



	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}



	public Date getExpiryDate() {
		return expiryDate;
	}



	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	

	public Visa(String visaId, String country, Date issueDate, Date expiryDate) {
		super();
		this.visaId = visaId;
		this.country = country;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
	}



	public Visa() {
		super();
	}

	

}