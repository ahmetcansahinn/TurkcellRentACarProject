package com.turkcell.carservice.business.abstracts;

import com.turkcell.carservice.dtos.request.CreateCarRequest;
import com.turkcell.carservice.dtos.response.CreatedCarResponse;
import com.turkcell.carservice.entities.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    CreatedCarResponse add (CreateCarRequest request);

    CreatedCarResponse update (String id, CreateCarRequest request);

    Car getByCarId(String carId);

    void deleteCar(String carId);
    boolean getByIdForStock(String code,int requiredStock);

}
