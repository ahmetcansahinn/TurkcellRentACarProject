package com.turkcell.carservice.repositories;

import com.turkcell.carservice.entities.CarImages;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ImagesRepository extends MongoRepository<CarImages, Integer> {
}
