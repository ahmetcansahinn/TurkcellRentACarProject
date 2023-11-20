package com.turkcell.rentalservice.controller;

import com.turkcell.rentalservice.business.RentalCarService;
import com.turkcell.rentalservice.dtos.CreateRentalCarRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@RequestMapping("api/rentals")
@RestController
@RequiredArgsConstructor
public class RentalCarController {
    private final RentalCarService rentalCarService;
    private final WebClient.Builder webClient;

    @PostMapping
    public ResponseEntity<Boolean> avaliableCars(@RequestBody List<CreateRentalCarRequest> requests) {
        Boolean allStockAvailable = rentalCarService.availableRent(requests);

        if (allStockAvailable) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }
}
