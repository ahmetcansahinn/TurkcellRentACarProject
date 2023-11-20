package com.turkcell.rentalservice.repository;

import com.turkcell.rentalservice.entities.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalCarRepository extends JpaRepository <RentalCar, Integer>{

}
