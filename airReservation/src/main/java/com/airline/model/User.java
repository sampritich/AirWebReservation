package com.airline.model;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table
public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String emailId;
	@Column(nullable = false)
	private String contact;
	@Column(nullable = false)
	private String password;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public User(String emailId, String contact, String password) {
		super();
		this.emailId = emailId;
		this.contact = contact;
		this.password = password;
	}
	
	public User() {
		super();
	}
	
}
