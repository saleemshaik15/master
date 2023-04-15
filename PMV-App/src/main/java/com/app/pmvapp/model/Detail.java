package com.app.pmvapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Detail {
    private String plateNo;
    private Double serviceCost;
    private Double mileage;
    private LocalDate lastService;
}
