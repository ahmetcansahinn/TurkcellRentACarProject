package com.turkcell.rentalservice.repositories;

import com.turkcell.rentalservice.entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car,Integer> {

}
