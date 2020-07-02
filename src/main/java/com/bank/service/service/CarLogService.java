package com.bank.service.service;

import java.time.LocalDate;

import org.springframework.validation.annotation.Validated;

import com.bank.service.model.CarLog;
import com.bank.service.model.CarLogOneDayReport;

@Validated
public interface CarLogService {

	CarLog saveCarLog(CarLog carLog);
	CarLogOneDayReport findCarLogByDate(LocalDate date);

}
