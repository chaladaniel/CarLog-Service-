package com.bank.service.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class CarLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long carLogId;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	//@JsonFormat(pattern = "YYYY-MM-dd HH:mm")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-dd-MM")
	private LocalDate date;
	
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "vehicleId")
	private Vehicle vehicle;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "atmLocationId")
	private AtmLocation atmLocation;
	
	public CarLog() {}
	
	public CarLog(Long carLogId, LocalDate date, Vehicle vehicle, AtmLocation atmLocation) {
		super();
		this.carLogId=carLogId;
		this.date = date;
		this.vehicle = vehicle;
		this.atmLocation = atmLocation;
	}

	public CarLog(LocalDate date, Vehicle vehicle, AtmLocation atmLocation) {
		super();
		this.date = date;
		this.vehicle = vehicle;
		this.atmLocation = atmLocation;
	}
	
	public Long getCarLogId() {
		return carLogId;
	}

	public void setCarLogId(Long carLogId) {
		this.carLogId = carLogId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public AtmLocation getAtmLocation() {
		return atmLocation;
	}

	public void setAtmLocation(AtmLocation atmLocation) {
		this.atmLocation = atmLocation;
	}	
	
}
