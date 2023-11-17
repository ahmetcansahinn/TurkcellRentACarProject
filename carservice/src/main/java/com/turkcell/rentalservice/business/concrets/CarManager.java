package com.turkcell.rentalservice.business.concrets;

import com.turkcell.rentalservice.business.abstracts.CarService;
import com.turkcell.rentalservice.dtos.request.CreateCarRequest;
import com.turkcell.rentalservice.dtos.response.CreatedCarResponse;
import com.turkcell.rentalservice.entities.Car;
import com.turkcell.rentalservice.repositories.CarRepository;
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

                .build();
        car = carRepository.save(car);
        CreatedCarResponse response = CreatedCarResponse
                .builder()
                .carId(car.getCarId())
                .brand(car.getBrand())
                .build();
        return response;
    }

}
