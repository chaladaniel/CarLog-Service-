package com.bank.service.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vehicleId;
	private String manufacturer;
	private String model;
	private String yearOfManufacturing;
	private String trim;
	private String engine;
	
	@Enumerated(EnumType.STRING)
	private VehicleType type;
	
	public Vehicle() {}
	
	public Vehicle(Long vehicleId, String manufucturer, String model, String yearOfManufacturing, String trim, String engine, VehicleType type) {
		super();
		this.vehicleId = vehicleId;
		this.manufacturer = manufucturer;
		this.model = model;
		this.yearOfManufacturing = yearOfManufacturing;
		this.trim = trim;
		this.engine = engine;
		this.type = type;
	}

	public Vehicle(String manufucturer, String model, String yearOfManufacturing, String trim, String engine, VehicleType type) {
		super();
		this.manufacturer = manufucturer;
		this.model = model;
		this.yearOfManufacturing = yearOfManufacturing;
		this.trim = trim;
		this.engine = engine;
		this.type = type;
	}

	public Long getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Long vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getYearOfManufacturing() {
		return yearOfManufacturing;
	}

	public void setYearOfManufacturing(String yearOfManufacturing) {
		this.yearOfManufacturing = yearOfManufacturing;
	}

	public String getTrim() {
		return trim;
	}

	public void setTrim(String trim) {
		this.trim = trim;
	}

	public String getEngine() {
		return engine;
	}

	public void setEngine(String engine) {
		this.engine = engine;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((engine == null) ? 0 : engine.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((trim == null) ? 0 : trim.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((vehicleId == null) ? 0 : vehicleId.hashCode());
		result = prime * result + ((yearOfManufacturing == null) ? 0 : yearOfManufacturing.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehicle other = (Vehicle) obj;
		if (engine == null) {
			if (other.engine != null)
				return false;
		} else if (!engine.equals(other.engine))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (trim == null) {
			if (other.trim != null)
				return false;
		} else if (!trim.equals(other.trim))
			return false;
		if (type != other.type)
			return false;
		if (vehicleId == null) {
			if (other.vehicleId != null)
				return false;
		} else if (!vehicleId.equals(other.vehicleId))
			return false;
		if (yearOfManufacturing == null) {
			if (other.yearOfManufacturing != null)
				return false;
		} else if (!yearOfManufacturing.equals(other.yearOfManufacturing))
			return false;
		return true;
	}
	
}
