package com.turkcell.rentalservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private String carId;
    private String brand;
    private String colorOfCar;
    private String model;
    private String yearOfManufacture;
    private double dailyPrice;
    private boolean picture;
    private int hasStock;
    private String inventoryCode;
    private LocalDate date;
    private String carStatus;
}
