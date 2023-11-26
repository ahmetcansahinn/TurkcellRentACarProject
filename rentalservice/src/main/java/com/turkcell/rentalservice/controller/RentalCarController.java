package com.turkcell.rentalservice.controller;

import com.turkcell.rentalservice.business.RentalCarService;
import com.turkcell.rentalservice.dtos.CarDto;
import com.turkcell.rentalservice.dtos.CreateRentalCarRequest;
import com.turkcell.rentalservice.entities.RentalCar;
import com.turkcell.rentalservice.repository.RentalCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@RequiredArgsConstructor
public class RentalCarController {
    private final RentalCarService rentalCarService;
    private final WebClient.Builder webClientBuilder;
    private RentalCarRepository rentalCarRepository;


    @PostMapping("/submitCheck")
    public String submitAndCheckSuccess(@RequestBody CreateRentalCarRequest request){
        return rentalCarService.submitAndCheckSuccess(request);
    }

    @GetMapping("/getAll")
    public CarDto getAll(){
        return (CarDto) rentalCarRepository.findAll();
    }
    @GetMapping("/getByCustomerId/{customerId}")
    public ResponseEntity<List<RentalCar>> getByCustomerId(@PathVariable int customerId) {
        List<RentalCar> rentalCars = rentalCarRepository.findByCustomerId(customerId);
        return ResponseEntity.ok(rentalCars);
    }

}



