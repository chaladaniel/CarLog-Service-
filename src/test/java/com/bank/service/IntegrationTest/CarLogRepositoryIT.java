package com.bank.service.IntegrationTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


import com.bank.service.model.AtmLocation;
import com.bank.service.model.CarLog;
import com.bank.service.model.Vehicle;
import com.bank.service.model.VehicleType;
import com.bank.service.repository.CarLogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CarLogRepositoryIT {

    @Autowired
    private CarLogRepository carLogRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findByDate() {
        LocalDate date = LocalDate.now();
        AtmLocation atmLocation = new AtmLocation("North Jupiter road", "apartement 1115", "Garland", "Texas", "75044");
        Vehicle vehicle = new Vehicle("BMW", "XY", "2019", "luxury", "V 6", VehicleType.SEDAN);
        CarLog carLog = new CarLog(date ,vehicle, atmLocation);

        entityManager.persist(carLog);

        List<CarLog> test = carLogRepository.findByDate(date);

        assertThat(test.get(0).getAtmLocation(), is(atmLocation));
        assertThat(test.get(0).getVehicle(), is(vehicle));
        assertThat(test.get(0).getDate(), is(date));
        assertThat(test.get(0).getCarLogId(), notNullValue());

    }

    @Test
    public void findByVehicleManufacturer() {
    }
}


















