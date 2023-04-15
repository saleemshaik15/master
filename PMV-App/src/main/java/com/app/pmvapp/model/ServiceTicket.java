package com.app.pmvapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "service_ticket")
public class ServiceTicket {

    @Id
    @Column(name = "service_ticket_id")
    private Integer serviceTicketId;

    @ManyToOne
    @JoinColumn(name = "plate_no")
    private Car car;

    @Column(name = "last_service_mileage")
    private int lastServiceMileage;

    @Column(name = "last_service_date")
    private LocalDate lastServiceDate;

    @Column(name = "service_description")
    private String serviceDescription;

    @Column(name = "service_cost")
    private Double serviceCost;

    @Column(name = "upcoming_service_date")
    private LocalDate upcomingServiceDate;

    @Column(name = "engineer_name")
    private String engineerName;
}
