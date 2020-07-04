package com.bank.service.controller;

import static org.hamcrest.CoreMatchers.is;

import com.bank.service.model.*;
import com.bank.service.service.CarLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(CarLogController.class)
public class ControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CarLogService service;


    @Test
    public void testSaveCarLog() throws Exception {
        LocalDate date = LocalDate.now();
        AtmLocation atmLocation = new AtmLocation(1L, "North Jupiter road", "apartement 1115", "Garland", "Texas", "75044");
        Vehicle vehicle = new Vehicle(1L, "BMW", "XY", "2019", "luxury", "V 6", VehicleType.SEDAN);
        CarLog carLog = new CarLog(1L, date, vehicle, atmLocation);


        ObjectMapper objectMapper = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true)
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        String carLogAsString = objectMapper.writeValueAsString(carLog);

        given(service.saveCarLog(any())).willReturn(carLog);

        mvc.perform(post("/carLog")
                .contentType(MediaType.APPLICATION_JSON).content(carLogAsString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.atmLocation.state", is("Texas")));
    }


        @Test
    public void testOneDayReport() throws Exception {
        Clock clock = Clock.fixed(Instant.parse("2014-12-22T10:15:30.00Z"), ZoneId.of("UTC"));
        LocalDate date = LocalDate.now(clock);
            System.out.println(date);
        AtmLocation atmLocation = new AtmLocation(1L, "North Jupiter road", "apartement 1115", "Garland", "Texas", "75044");
        int numberOfCar = 1;
        Vehicle vehicle = new Vehicle(1L, "BMW", "XY", "2019", "luxury", "V 6", VehicleType.SEDAN);
        String type = VehicleType.SEDAN.toString();
        List<Vehicle> list = new ArrayList<Vehicle>();
        list.add(vehicle);
        Map<String, List<Vehicle>> vehicleMap = new HashMap<String, List<Vehicle>>();
        vehicleMap.put(type, list);

        CarLogOneDayReport carLogs = new CarLogOneDayReport(date, atmLocation, numberOfCar, vehicleMap);

        given(service.findCarLogByDate(date)).willReturn(carLogs);

        mvc.perform(get("/carLog/report")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.atmLocation", is(atmLocation)));
    }
}
