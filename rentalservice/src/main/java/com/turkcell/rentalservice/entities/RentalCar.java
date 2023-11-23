package com.turkcell.rentalservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rental_car")

public class RentalCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="car_id")
    private int carId;
    @Column(name = "daily_price")
    private double dailyPrice;
    @Column(name = "rent_date")
    private LocalDate rentDate;
    @Column(name = "customer_id")
    private int customerId;


}
