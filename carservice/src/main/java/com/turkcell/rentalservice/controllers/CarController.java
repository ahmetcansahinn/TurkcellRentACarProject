package com.turkcell.rentalservice.controllers;

import com.turkcell.rentalservice.business.abstracts.CarService;
import com.turkcell.rentalservice.dtos.request.CreateCarRequest;
import com.turkcell.rentalservice.dtos.response.CreatedCarResponse;
import com.turkcell.rentalservice.entities.Car;
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
}
