package com.turkcell.rentalservice.dtos;

import lombok.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateRentalCarRequest {
    private String carId;
    private int customerId;

}
