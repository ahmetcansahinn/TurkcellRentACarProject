package com.turkcell.carservice.business.abstracts;

import com.turkcell.carservice.dtos.request.CreateCarRequest;
import com.turkcell.carservice.dtos.response.CreatedCarResponse;
import com.turkcell.carservice.entities.Car;
import com.turkcell.carservice.entities.CarImages;

import java.util.List;
import java.util.Optional;

public interface CarService {
    List<Car> getAll();

    CreatedCarResponse add (CreateCarRequest request);

    CreatedCarResponse update (String id, CreateCarRequest request);

    Car getByCarId(String carId);

    void deleteCar(String carId);

    public String getCarStatus(String carId);
    public CarImages addCarImages(List<CarImages> carImages);
    Optional<Car> getById(String Id);



}
