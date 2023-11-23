package com.turkcell.rentalservice.business;

import com.turkcell.rentalservice.dtos.CreateRentalCarRequest;
import com.turkcell.rentalservice.repository.RentalCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RentalCarManager implements  RentalCarService{
    private final RentalCarRepository rentalCarRepository;
    private final WebClient.Builder webClient;
    @Override
    public boolean availableRent(List<CreateRentalCarRequest> requests) {
            for (CreateRentalCarRequest request : requests) {

                Boolean hasStock = webClient.build()
                        .get()
                        .uri("http://car-service/api/cars/stock",
                                (uriBuilder) -> uriBuilder
                                        .queryParam("invCode",request.getInventoryCode())
                                        .queryParam("requiredStock", request.getAmount())

                                        .build())
                        .retrieve()
                        .bodyToMono(Boolean.class)
                        .block();
                Boolean hasBalance = webClient.build()
                        .get()
                        .uri("http://customer-service/api/rentals/balance",
                                (uriBuilder) -> uriBuilder
                                        .queryParam("inventoryCode",request.getInventoryCode())
                                        .queryParam("requiredBalance", request.getAmount())

                                        .build())
                        .retrieve()
                        .bodyToMono(Boolean.class)
                        .block();

                if (!hasStock||!hasBalance) {

                    return false;
                }
            }
            return true;
        }


}
