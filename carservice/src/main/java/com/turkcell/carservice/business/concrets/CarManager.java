package com.turkcell.carservice.business.concrets;

import com.turkcell.carservice.dtos.response.CreatedCarResponse;
import com.turkcell.carservice.repositories.CarRepository;
import com.turkcell.carservice.business.abstracts.CarService;
import com.turkcell.carservice.dtos.request.CreateCarRequest;
import com.turkcell.carservice.entities.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CarManager implements CarService {
    private final CarRepository carRepository;

    @Override
    public List<Car> getAll() {     // Requestlere build edilecek yapamadık ???
        return carRepository.findAll();
    }

    @Override
    public CreatedCarResponse add(CreateCarRequest request) {
        Car car = Car
                .builder()
                .brand(request.getBrand())
                .colorOfCar(request.getColorOfCar())
                .model(request.getModel())
                .yearOfManufacture(request.getYearOfManufacture())
                .dailyPrice(request.getDailyPrice())
                .picture(request.isPicture())
                .hasStock(request.getHasStock())
                .inventoryCode(request.getInventoryCode())
                .build();
        car = carRepository.save(car);
        CreatedCarResponse response = CreatedCarResponse
                .builder()
                .carId(car.getCarId())
                .brand(car.getBrand())
                .hasStock(car.getHasStock())
                .inventoryCode(car.getInventoryCode())
                .build();

        return response;
    }

    @Override
    public CreatedCarResponse update(String id, CreateCarRequest request) {
        Car car = carRepository.findById(id).orElseThrow();

        car.setBrand(request.getBrand());
        car.setColorOfCar(request.getColorOfCar());
        car.setModel(request.getModel());
        car.setYearOfManufacture(request.getYearOfManufacture());
        car.setDailyPrice(request.getDailyPrice());
        car.setPicture(request.isPicture());
        car.setHasStock(request.getHasStock());
        car.setInventoryCode(request.getInventoryCode());

        carRepository.save(car);

        CreatedCarResponse response = CreatedCarResponse
                .builder()
                .carId(car.getCarId())
                .brand(car.getBrand())
                .hasStock(car.getHasStock())
                .inventoryCode(car.getInventoryCode())
                .build();

        return response;
    }

    @Override
    public Car getByCarId(String carId) {

        return carRepository.findById(carId).get();

    }

    @Override
    public void deleteCar(String carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public boolean getByIdForStock(String code,int requiredStock) {
        Car car = carRepository.findByInventoryCodeQuery(code);
        if(car == null || car.getHasStock() <requiredStock)

            return false;
        return true;
    }
}
