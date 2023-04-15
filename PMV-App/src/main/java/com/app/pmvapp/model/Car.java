package com.app.pmvapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class Car {

    @Id
    @Column(name = "plate_no")
    private String plateNo;

    @Column(name = "car_model")
    private String carModel;

    @Column(name = "manufacturing_year")
    private int manufacturingYear;

    @Column(name = "upcoming_service_date")
    private LocalDate upcomingServiceDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<ServiceTicket> serviceTickets = new ArrayList<>();

    private Boolean isServiceDone = Boolean.FALSE;
}

