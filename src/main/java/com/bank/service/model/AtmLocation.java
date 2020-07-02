package com.bank.service.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AtmLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long atmLocationId;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private String zipCode;
	
	public AtmLocation() {}
	
	public AtmLocation(Long atmLocationId, String addressLine1, String addressLine2, String city, String state, String zipCode) {
		super();
		this.atmLocationId = atmLocationId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public AtmLocation(String addressLine1, String addressLine2, String city, String state, String zipCode) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public Long getAtmLocationId() {
		return atmLocationId;
	}

	public void setAtmLocationId(Long atmLocationId) {
		this.atmLocationId = atmLocationId;
	}

	public String getAddressLine1() {
		return addressLine1;
	}
	
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	
	public String getAddressLine2() {
		return addressLine2;
	}
	
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	
}
