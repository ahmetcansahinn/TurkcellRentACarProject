package com.turkcell.carservice.repositories;

import com.turkcell.carservice.entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CarRepository extends MongoRepository<Car,String> {
//    Car findByInventoryCode(String inventoryCode);

    @Query("{'carId': ?0 }")
    Car findByInventoryCodeQuery(String invCode);
}
