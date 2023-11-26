package com.turkcell.carservice.business.concrets;

import com.turkcell.carservice.dtos.response.CreatedCarResponse;
import com.turkcell.carservice.entities.CarImages;
import com.turkcell.carservice.repositories.CarRepository;
import com.turkcell.carservice.business.abstracts.CarService;
import com.turkcell.carservice.dtos.request.CreateCarRequest;
import com.turkcell.carservice.entities.Car;
import com.turkcell.carservice.repositories.ImagesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class CarManager implements CarService {
    private final CarRepository carRepository;
    private final ImagesRepository imagesRepository;

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
                .hasStock(request.getHasStock())
                .inventoryCode(request.getInventoryCode())
                .carStatus(request.getCarStatus())
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


    public String getCarStatus(String carId) {
        Car car = carRepository.findById(carId).get();
        System.out.println("araç:" + car.getCarStatus());
        return car.getCarStatus();
    }
    public CarImages addCarImages(List<CarImages> carImages) {
        for (CarImages item : carImages) {
            CarImages newCarImages = new CarImages();
            newCarImages.setId(item.getId());
            newCarImages.setCarId(item.getCarId());
            newCarImages.setCarImage(item.getCarImage());
            imagesRepository.save(newCarImages);
        }
        return null;
    }


}

