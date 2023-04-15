package com.app.pmvapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ServiceReport {
    private Map<String,List<Detail>> serviceDetailsMap;
    //private List<ServiceDetails> serviceDetails= new ArrayList<>();
}
