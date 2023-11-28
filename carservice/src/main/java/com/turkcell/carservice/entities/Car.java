package com.turkcell.carservice.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

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
    private int hasStock;
    private String inventoryCode;
    private LocalDate date;
    private String carStatus;

    public void decrementStock(int decrementBy) {
        if (this.hasStock - decrementBy >= 0) {
            this.hasStock -= decrementBy;
        } else {
            throw new IllegalArgumentException("Stok miktarı yetersiz.");
        }
    }
}



