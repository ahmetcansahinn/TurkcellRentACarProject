package com.turkcell.rentalservice.repository;

import com.turkcell.rentalservice.entities.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RentalCarRepository extends JpaRepository <RentalCar, Integer>{
    List<RentalCar> findByCustomerId(int customerId);


}
