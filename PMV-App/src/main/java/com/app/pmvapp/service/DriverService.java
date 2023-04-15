package com.app.pmvapp.service;

import com.app.pmvapp.exception.ResourceNotFound;
import com.app.pmvapp.model.Car;
import com.app.pmvapp.model.Driver;
import com.app.pmvapp.model.ServiceTicket;
import com.app.pmvapp.repository.CarRepository;
import com.app.pmvapp.repository.DriverRepository;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DriverService {

    private DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver create(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver getDriver(Integer driverId) throws Exception {
        return driverRepository.findById(driverId).orElseThrow(() -> new ResourceNotFound("Driver not found with id: "+driverId));
    }

    public void deleteDriver(Integer id) throws Exception {
        Optional<Driver> optionalCar = driverRepository.findById(id);
        if (optionalCar.isPresent()) {
            driverRepository.deleteById(id);
        } else {
            throw new Exception("Driver not found to delete");
        }
    }

    public Driver update(Driver driver) throws Exception {
        Optional<Driver> optionalDriver = driverRepository.findById(driver.getDriverId());
        if (optionalDriver.isPresent()) {
            driverRepository.save(driver);
        } else {
            throw new ResourceNotFound("Driver not found with id: "+ driver.getDriverId());
        }
        return driver;
    }

    public List<Driver> getAllDrivers() {
        return driverRepository.findAll();
    }

}
