package com.app.pmvapp.controller;

import com.app.pmvapp.model.Car;
import com.app.pmvapp.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/create")
    public Car create(@RequestBody Car car, Authentication auth){
        System.out.println(car.getPlateNo()+"  "+auth.getName());
        return carService.create(car);
    }

    @GetMapping("/{id}")
    public Car getCar(@PathVariable String id) throws Exception {
        return carService.getCar(id);
    }
    @GetMapping("/all")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable String id) throws Exception {
        carService.deleteCar(id);
    }

    @PutMapping("/update")
    public Car update(@RequestBody Car car) throws Exception {
        return carService.update(car);
    }


}
