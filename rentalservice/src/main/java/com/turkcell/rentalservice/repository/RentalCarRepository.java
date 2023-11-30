package com.turkcell.rentalservice.repository;

import com.turkcell.rentalservice.entities.RentalCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface RentalCarRepository extends JpaRepository <RentalCar, Integer>{
    List<RentalCar> findByCustomerId(int customerId);


}
