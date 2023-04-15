package com.app.pmvapp.service;

import com.app.pmvapp.exception.ResourceNotFound;
import com.app.pmvapp.model.Car;
import com.app.pmvapp.repository.CarRepository;
import com.app.pmvapp.repository.ServiceTicketRepository;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Car create(Car car) {
        return carRepository.save(car);
    }

    public Car getCar(String carId) throws Exception {
        Car car = carRepository.findById(carId).orElseThrow(() -> new ResourceNotFound("Car not found with id: " + carId));
        System.out.println(car.getDriver().getDriverId());
        return car;
    }

    public void deleteCar(String id) throws Exception {
        Optional<Car> optionalCar = carRepository.findById(id);
        if (optionalCar.isPresent()) {
            carRepository.deleteById(id);
        } else {
            throw new Exception("Car not found to delete");
        }
    }

    public Car update(Car car) throws Exception {
        Optional<Car> optionalCar = carRepository.findById(car.getPlateNo());
        if (optionalCar.isPresent()) {
            carRepository.save(car);
        } else {
            throw new ResourceNotFound("Car not found with id: "+ car.getPlateNo());
        }
        return car;
    }

    public List<Car> getAllCars() {
        return carRepository.findAll().parallelStream().filter(car -> BooleanUtils.isFalse(car.getIsServiceDone())).collect(Collectors.toList());
    }
}
