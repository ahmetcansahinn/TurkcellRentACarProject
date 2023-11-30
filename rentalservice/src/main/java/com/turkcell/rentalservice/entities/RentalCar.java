package com.turkcell.rentalservice.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rental_car")
@Builder

public class RentalCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="rental_id")
    private int rentalId;
    @Column(name = "car_id")
    private String carId;
    @Column(name = "daily_price")
    private double dailyPrice;
    @Column(name = "brand")
    private String brand;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "customer_name")
    private String customerName;



}
