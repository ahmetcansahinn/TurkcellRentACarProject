package com.turkcell.rentalservice.entities;

import com.turkcell.rentalservice.dtos.CarDto;
import com.turkcell.rentalservice.dtos.CustomerDto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    @Column(name ="car_id")
    private int carId;
    @Column(name = "daily_price")
    private double dailyPrice;
    @Column(name = "brand")
    private String brand;
    @Column(name = "customer_id")
    private int customerId;
    @Column(name = "customer_name")
    private String customerName;
    public void setCarDto(CarDto carDto) {
        this.carId= Integer.parseInt(carDto.getCarId());
        this.brand=carDto.getBrand();
    }

    public void setCustomerDto(CustomerDto customerDto) {
        this.customerName=customerDto.getCustomerName();
        this.customerId=customerDto.getCustomerId();

    }



}
