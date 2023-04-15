package com.app.pmvapp.repository;

import com.app.pmvapp.model.Car;
import com.app.pmvapp.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Integer> {
}
