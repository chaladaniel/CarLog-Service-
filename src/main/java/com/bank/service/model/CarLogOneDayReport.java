package com.bank.service.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class CarLogOneDayReport {

	private LocalDate date;
	
	private AtmLocation atmLocation;
	private int numberOfCar;
	private Map<String, List<Vehicle>> vehicleMap;
	
	public CarLogOneDayReport() {}

	public CarLogOneDayReport(LocalDate date, AtmLocation atmLocation, int numberOfCar,
			Map<String, List<Vehicle>> vehicleMap) {
		super();
		this.date = date;
		this.atmLocation = atmLocation;
		this.numberOfCar = numberOfCar;
		this.vehicleMap = vehicleMap;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public AtmLocation getAtmLocation() {
		return atmLocation;
	}

	public void setAtmLocation(AtmLocation atmLocation) {
		this.atmLocation = atmLocation;
	}

	public int getNumberOfCar() {
		return numberOfCar;
	}

	public void setNumberOfCar(int numberOfCar) {
		this.numberOfCar = numberOfCar;
	}

	public Map<String, List<Vehicle>> getVehicleMap() {
		return vehicleMap;
	}

	public void setVehicleMap(Map<String, List<Vehicle>> vehicleMap) {
		this.vehicleMap = vehicleMap;
	}
	
	
}
