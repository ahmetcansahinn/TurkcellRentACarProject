package com.turkcell.carservice.controllers;

import com.turkcell.carservice.business.abstracts.CarService;
import com.turkcell.carservice.dtos.request.CreateCarRequest;
import com.turkcell.carservice.dtos.response.CreatedCarResponse;
import com.turkcell.carservice.entities.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/cars")
@RestController
@RequiredArgsConstructor


public class CarController {
    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> getAll(){
        List<Car> allCar = carService.getAll();
        return new ResponseEntity<List<Car>>(allCar, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCarResponse add(@RequestBody CreateCarRequest request){
        return carService.add(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody CreateCarRequest request){
        carService.update(id, request);
        return new ResponseEntity("Ürün Güncellendi!",HttpStatus.CREATED);
    }
    @GetMapping("/getById/{carId}")
    public Car getByCarId(@PathVariable String carId){
        Car getByCarId = carService.getByCarId(carId);
        return getByCarId;
    }
    @DeleteMapping("/{carId}")
    public void deleteCar(@PathVariable String carId) {
        carService.deleteCar(carId);
    }

    @GetMapping("/stock")
    public Boolean getByInventoryCode(@RequestParam String invCode,
                                      @RequestParam int requiredStock){
        return carService.getByIdForStock(invCode,requiredStock);
    }
}
