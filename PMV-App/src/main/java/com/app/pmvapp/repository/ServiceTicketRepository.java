package com.app.pmvapp.repository;

import com.app.pmvapp.model.ServiceTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceTicketRepository extends JpaRepository<ServiceTicket,Integer> {

//    public ServiceTicket findServiceTicketByPlateNo(String plateNo);
}
