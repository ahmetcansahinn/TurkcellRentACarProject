package com.turkcell.rentalservice.business.abstracts;

import com.turkcell.rentalservice.dtos.request.CreateCarRequest;
import com.turkcell.rentalservice.dtos.response.CreatedCarResponse;
import com.turkcell.rentalservice.entities.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    CreatedCarResponse add (CreateCarRequest request);

}
