package com.app.pmvapp.controller;

import com.app.pmvapp.model.Detail;
import com.app.pmvapp.model.ServiceReport;
import com.app.pmvapp.model.ServiceTicket;
import com.app.pmvapp.service.ServiceTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ticket")
public class ServiceTicketController {
    @Autowired
    private ServiceTicketService serviceTicketService;

    @PostMapping("/create")
    public ServiceTicket create(@RequestBody ServiceTicket serviceTicket) throws Exception {
        return serviceTicketService.create(serviceTicket);
    }

    @GetMapping("/{id}")
    public ServiceTicket getTicket(@PathVariable Integer id) {
        return serviceTicketService.getServiceTicket(id);
    }
    @GetMapping("/all")
    public List<ServiceTicket> getAllTickets() {
        return serviceTicketService.getAllServiceTickets();
    }

    @DeleteMapping("/{id}")
    public void deleteTicket(@PathVariable Integer id) throws Exception {
        serviceTicketService.deleteServiceTicket(id);
    }

    @PutMapping("/update")
    public ServiceTicket update(@RequestBody ServiceTicket serviceTicket) {
        return serviceTicketService.update(serviceTicket);
    }

    @GetMapping("/driver/{id}")
    public List<ServiceTicket> getAllServiceTicketForDriver(@PathVariable Integer id) {
        return serviceTicketService.getAllServiceTicketForDriver(id);
    }

    @GetMapping("/report/{year}")
    public Map<String, List<Detail>> monthlyReportByCar(@PathVariable Integer year) {
        return serviceTicketService.monthlyReportByCar(year);
    }


}
