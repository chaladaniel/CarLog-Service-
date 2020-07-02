package com.bank.service.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.service.model.CarLog;
import com.bank.service.model.CarLogOneDayReport;
import com.bank.service.service.CarLogService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/carLog")
public class CarLogController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarLogController.class);
	@Autowired
	private CarLogService carLogService;

	@PostMapping
	public CarLog saveCarLog(@RequestBody CarLog carLog) throws JsonProcessingException {
		LOGGER.info("save carlog data from client {}", new ObjectMapper().writeValueAsString(carLog));
		CarLog response = carLogService.saveCarLog(carLog);
		return response;
	}

	

	@GetMapping("/report") 
	public CarLogOneDayReport oneDayReport(@RequestParam(name = "date") @DateTimeFormat(iso = ISO.DATE) LocalDate date) throws JsonProcessingException {
		LOGGER.info("preparing report for date {}", date);
		return carLogService.findCarLogByDate(date);
	  }

}