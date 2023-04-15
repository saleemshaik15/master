package com.app.pmvapp.service;

import com.app.pmvapp.exception.ResourceNotFound;
import com.app.pmvapp.model.*;
import com.app.pmvapp.repository.CarRepository;
import com.app.pmvapp.repository.DriverRepository;
import com.app.pmvapp.repository.ServiceTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServiceTicketService {

    private ServiceTicketRepository serviceTicketRepository;
    private DriverRepository driverRepository;
    private CarRepository carRepository;
    private CarService carService;

    private final List<String> months = List.of("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

    @Autowired
    public ServiceTicketService(ServiceTicketRepository serviceTicketRepository,
                                DriverRepository driverRepository,
                                CarRepository carRepository,
                                CarService carService) {
        this.serviceTicketRepository = serviceTicketRepository;
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.carService = carService;
    }

    public ServiceTicket create(ServiceTicket serviceTicket) throws Exception {
        Driver driver = serviceTicket.getCar().getDriver();
        String plateNo = serviceTicket.getCar().getPlateNo();
        Optional<Car> carOptional = carRepository.findById(plateNo);
        if (carOptional.isPresent()) {
            ArrayList<ServiceTicket> serviceTickets = new ArrayList<>();
            serviceTickets.add(serviceTicket);
            Car car = carOptional.get();
            car.setServiceTickets(serviceTickets);
            car.setDriver(driver);
            car.setIsServiceDone(Boolean.TRUE);
            carService.update(car);
        }
        return serviceTicketRepository.save(serviceTicket);
    }

    public ServiceTicket getServiceTicket(Integer ticketId) {
        return serviceTicketRepository.findById(ticketId).orElseThrow(() -> new ResourceNotFound("Ticket not found with id: " + ticketId));
    }

    public void deleteServiceTicket(Integer id) throws Exception {
        Optional<ServiceTicket> optionalServiceTicket = serviceTicketRepository.findById(id);
        if (optionalServiceTicket.isPresent()) {
            serviceTicketRepository.deleteById(id);
        } else {
            throw new Exception("Ticket not found to delete");
        }
    }

    public ServiceTicket update(ServiceTicket serviceTicket) {
        Optional<ServiceTicket> optionalServiceTicket = serviceTicketRepository.findById(serviceTicket.getServiceTicketId());
        if (optionalServiceTicket.isPresent()) {
            serviceTicketRepository.save(serviceTicket);
        } else {
            throw new ResourceNotFound("Ticket not found with id: " + serviceTicket.getServiceTicketId());
        }
        return serviceTicket;
    }

    public List<ServiceTicket> getAllServiceTickets() {
        return serviceTicketRepository.findAll();
    }

    public List<ServiceTicket> getAllServiceTicketForDriver(Integer driverId) {
        Optional<Driver> driverOptional = driverRepository.findById(driverId);
        List<ServiceTicket> serviceTickets = null;
        if (driverOptional.isPresent()) {
            List<Car> cars = carRepository.findAll();
            for (Car car : cars) {
                if (car.getDriver().getDriverId().equals(driverId)) {
                    for (ServiceTicket serviceTicket : car.getServiceTickets()) {
                        Driver driver = serviceTicket.getCar().getDriver();
                        car.setDriver(driver);
                    }
                    serviceTickets = car.getServiceTickets();
                }
            }
            serviceTickets.forEach(serviceTicket -> {

                serviceTicket.setServiceCost(null);
            });
            return serviceTickets;
        }
        return null;
    }

    public Map<String, List<Detail>> monthlyReportByCar(Integer year) {
        Map<String, List<Detail>> serviceReport =  new LinkedHashMap<>();
        List<Car> carList = carRepository.findAll();
        for (String month : months) {
            ArrayList<Detail> details = new ArrayList<>();
            for (Car car : carList) {
                Double totalServiceCost = 0.00;
                Double totalMileage = 0.00;
                LocalDate lastServiceValue = null;
                Detail detail = null;
                for (ServiceTicket serviceTicket : car.getServiceTickets()) {
                    if (serviceTicket.getLastServiceDate().getYear() == year
                            && serviceTicket.getLastServiceDate().getMonthValue() == Month.valueOf(month.toUpperCase()).getValue()){
                        detail = new Detail();
                        totalServiceCost += serviceTicket.getServiceCost();
                        totalMileage += serviceTicket.getLastServiceMileage();
                        detail.setPlateNo(car.getPlateNo());
                        detail.setServiceCost(totalServiceCost);
                        detail.setMileage(totalMileage);
                        lastServiceValue = serviceTicket.getLastServiceDate();
                        detail.setLastService(lastServiceValue);

                    }
                }
                details.add(detail);
            }
            serviceReport.put(month, details);
        }

        serviceReport.replaceAll((month, values) -> values.stream().filter(Objects::nonNull).collect(Collectors.toList()));
        return serviceReport;
    }

}
