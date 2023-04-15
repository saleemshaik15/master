package com.app.pmvapp.controller;

import com.app.pmvapp.model.Driver;
import com.app.pmvapp.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;

    @PostMapping("/create")
    public Driver create(@RequestBody Driver driver){
        return driverService.create(driver);
    }

    @GetMapping("/{id}")
    public Driver getDriver(@PathVariable Integer id) throws Exception {
        return driverService.getDriver(id);
    }
    @GetMapping("/all")
    public List<Driver> getAllCars() {
        return driverService.getAllDrivers();
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Integer id) throws Exception {
        driverService.deleteDriver(id);
    }

    @PutMapping("/update")
    public Driver update(@RequestBody Driver driver) throws Exception {
        return driverService.update(driver);
    }


}
