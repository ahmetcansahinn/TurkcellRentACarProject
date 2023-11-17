package com.turkcell.rentalservice.dtos.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreatedCarResponse {
    private String carId;
    private String brand;
}
