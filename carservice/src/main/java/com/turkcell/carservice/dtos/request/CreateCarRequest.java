package com.turkcell.carservice.dtos.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreateCarRequest {
    private String brand;
    private String colorOfCar;
    private String model;
    private String yearOfManufacture;
    private double dailyPrice;
    private boolean picture;
    private int hasStock;
    private String inventoryCode;

}