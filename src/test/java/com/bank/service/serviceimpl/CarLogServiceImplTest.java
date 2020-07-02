package com.bank.service.serviceimpl;

import static org.hamcrest.CoreMatchers.is;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsMapWithSize.aMapWithSize;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;


import com.bank.service.service.impl.CarLogServiceImpl;
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
import com.bank.service.repository.CarLogRepository;

@RunWith(MockitoJUnitRunner.class)
public class CarLogServiceImplTest {

    @InjectMocks
    private CarLogServiceImpl carLogServiceImpl;

    @Mock
    private CarLogRepository carLogRepository;

    @Test
    public void testSaveCarLog() throws Exception{

        LocalDate date = LocalDate.now();
        AtmLocation atmLocation = new AtmLocation(1L, "North Jupiter road", "apartement 1115", "Garland", "Texas", "75044");
        Vehicle vehicle = new Vehicle(1L, "BMW", "XY", "2019", "luxury", "V 6", VehicleType.SEDAN);
        CarLog carLog = new CarLog(1L,date ,vehicle, atmLocation);

        when(carLogRepository.save(carLog)).thenReturn(carLog);

        CarLog carLogs = carLogServiceImpl.saveCarLog(carLog);

        assertThat(carLogs.getAtmLocation(), is(atmLocation));
        assertThat(carLogs.getCarLogId(), is(1L));
        assertThat(carLogs.getDate(), is(date));
        assertThat(carLogs.getVehicle(), is(vehicle));
    }


    @Test
    public void testFindCarLogByDate() throws Exception {

        LocalDate date = LocalDate.now();
        AtmLocation atmLocation = new AtmLocation(1L, "North Jupiter road", "apartement 1115", "Garland", "Texas", "75044");
        Vehicle vehicle = new Vehicle(1L, "BMW", "XY", "2019", "luxury", "V 6", VehicleType.SEDAN);
        CarLog carLog = new CarLog(1L,date ,vehicle, atmLocation);
        List<CarLog> carLogs = new ArrayList<>();
        carLogs.add(carLog);

        when(carLogRepository.findByDate(date)).thenReturn(carLogs);

        CarLogOneDayReport logOne = carLogServiceImpl.findCarLogByDate(date);

        assertThat(logOne.getNumberOfCar(), is(1));
        assertThat(logOne.getAtmLocation(), is(atmLocation));
        assertThat(logOne.getDate(), is(date));
        assertThat(logOne.getVehicleMap(), aMapWithSize(1));
        assertThat(logOne.getVehicleMap(), hasEntry(VehicleType.SEDAN.toString(), Arrays.asList(vehicle)));
    }

}

//CarLogOneDayReport carObj = new CarLogOneDayReport();

/*
 * List<Vehicle> list = Arrays.asList(vehicle);
 * Map<String, List<Vehicle>> myMap
 * = new HashMap<>(); myMap.put(type, list); carObj.setAtmLocation(atmLocation);
 * carObj.setDate(date); carObj.setNumberOfCar(4); carObj.setVehicleMap(myMap);
 */


