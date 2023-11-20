package com.turkcell.carservice.dtos.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class CreatedCarResponse {
    private String carId;
    private String brand;
    private int hasStock;
    private String inventoryCode;

}
