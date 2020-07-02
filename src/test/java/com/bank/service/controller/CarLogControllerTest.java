package com.bank.service.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsMapWithSize.aMapWithSize;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


import com.bank.service.model.AtmLocation;
import com.bank.service.model.CarLog;
import com.bank.service.model.CarLogOneDayReport;
import com.bank.service.model.Vehicle;
import com.bank.service.model.VehicleType;
import com.bank.service.service.CarLogService;
import com.bank.service.service.impl.CarLogServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;


@RunWith(MockitoJUnitRunner.class)
public class CarLogControllerTest {
	
	@InjectMocks
	private CarLogController carLogController;
	
	@Mock
	private CarLogService carLogService;
	
	
	@Test
	public void testSaveCarLog() throws Exception {
		LocalDate date = LocalDate.now();
		AtmLocation atmLocation = new AtmLocation(1L, "North Jupiter road", "apartement 1115", "Garland", "Texas", "75044");
		Vehicle vehicle = new Vehicle(1L, "BMW", "XY", "2019", "luxury", "V 6", VehicleType.SEDAN);
		CarLog carLog = new CarLog(1L,date ,vehicle, atmLocation);	
		
		when(carLogService.saveCarLog(carLog)).thenReturn(carLog);
		
		CarLog carLogs = carLogController.saveCarLog(carLog);
		
		assertThat(carLogs.getAtmLocation(), is(atmLocation));
		assertThat(carLogs.getCarLogId(), is(1L));
		assertThat(carLogs.getDate(), is(date));
		assertThat(carLogs.getVehicle(), is(vehicle));

		
	}

	@Test
	public void testOneDayReport() throws JsonProcessingException {
		LocalDate date = LocalDate.now();
		AtmLocation atmLocation = new AtmLocation(1L, "North Jupiter road", "apartement 1115", "Garland", "Texas", "75044");
		int numberOfCar = 1;
		Vehicle vehicle = new Vehicle(1L, "BMW", "XY", "2019", "luxury", "V 6", VehicleType.SEDAN);
		String type = VehicleType.SEDAN.toString();
		List<Vehicle> list = new ArrayList<Vehicle>();
		list.add(vehicle);
		Map<String, List<Vehicle>> vehicleMap = new HashMap<String, List<Vehicle>>();
		vehicleMap.put(type, list);
		
		CarLogOneDayReport carLogs = new CarLogOneDayReport(date, atmLocation, numberOfCar, vehicleMap);
		
		when(carLogService.findCarLogByDate(date)).thenReturn(carLogs);
		
		CarLogOneDayReport carLog = carLogController.oneDayReport(date);
		
		assertThat(carLog.getAtmLocation(), is(atmLocation));
		assertThat(carLog.getDate(), is(date));
		assertThat(carLog.getNumberOfCar(), is(numberOfCar));
		assertThat(carLog.getVehicleMap(), aMapWithSize(1));
		assertThat(carLog.getVehicleMap(), hasEntry(type, list));
		
	}

}