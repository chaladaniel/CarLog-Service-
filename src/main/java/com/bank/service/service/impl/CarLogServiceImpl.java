package com.bank.service.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.service.model.CarLog;
import com.bank.service.model.CarLogOneDayReport;
import com.bank.service.model.Vehicle;
import com.bank.service.model.VehicleType;
import com.bank.service.repository.CarLogRepository;
import com.bank.service.service.CarLogService;

@Service
@Transactional
public class CarLogServiceImpl implements CarLogService {

	@Autowired
	private CarLogRepository carLogRepository;

	@Override
	public CarLog saveCarLog(CarLog carLog) {
		return carLogRepository.save(carLog);
	}


	@Override
	public CarLogOneDayReport findCarLogByDate(LocalDate date) {
		CarLogOneDayReport response = new CarLogOneDayReport();
		List<CarLog> list = carLogRepository.findByDate(date);
		System.out.println(list);
		response.setAtmLocation(list.get(0).getAtmLocation());// all location are same
		response.setDate(date);
		response.setNumberOfCar(list.size());
		//list.stream().forEach(em -> em.setAtmLocation(em.getAtmLocation()));
		Map<String, List<Vehicle>> map = new HashMap<>();

		list.forEach(log -> {
			String type = log.getVehicle().getType().toString();
			List<Vehicle> vehicles = map.getOrDefault(type, new ArrayList<>());
			vehicles.add(log.getVehicle());
			map.put(type, vehicles);
		});

		/*
		 * Map<String, List<Vehicle>> map1 = list.stream() .map(log -> log.getVehicle())
		 * .collect(Collectors.groupingBy(vehicle -> vehicle.getType().toString()));
		 */

		response.setVehicleMap(map);

		return response;
	}
	
	
	public static void main(String[] args) {
		System.out.println(VehicleType.VAN.toString());
		
	}
	/*
	 * @Override public List<CarLog> findAll() { return carLogRepository.findAll();
	 * }
	 */
}
