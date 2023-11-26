package com.turkcell.rentalservice.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreatedRentalCarResponse {
    private String carId;
    private int customerId;
}
