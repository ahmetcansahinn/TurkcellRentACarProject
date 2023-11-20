package com.turkcell.carservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(value = "cars")

public class Car {
    @Id
    private String carId;
    private String brand;
    private String colorOfCar;
    private String model;
    private String yearOfManufacture;
    private double dailyPrice;
    private boolean picture;
    private int hasStock;
    private String inventoryCode;


}
