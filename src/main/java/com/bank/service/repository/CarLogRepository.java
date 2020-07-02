package com.bank.service.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.service.model.CarLog;


public interface CarLogRepository extends JpaRepository<CarLog, Long>{

	List<CarLog> findByDate(LocalDate date);
	List<CarLog> findByVehicleManufacturer(String manufacturer);
	
}
