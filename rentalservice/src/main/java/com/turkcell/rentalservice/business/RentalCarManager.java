package com.turkcell.rentalservice.business;

import com.turkcell.rentalservice.dtos.CarDto;
import com.turkcell.rentalservice.dtos.CreateRentalCarRequest;
import com.turkcell.rentalservice.dtos.CreatedRentalCarResponse;
import com.turkcell.rentalservice.dtos.CustomerDto;
import com.turkcell.rentalservice.entities.RentalCar;
import com.turkcell.rentalservice.repository.RentalCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RentalCarManager implements  RentalCarService{
    private final RentalCarRepository rentalCarRepository;
    private final RestTemplate restTemplate;


    @Override
    public String submitOrder( CreateRentalCarRequest request) {
        CarDto carDto = getCarDto(request.getCarId());
        if (carDto.getHasStock() <= 0){
            throw new RuntimeException("Aracın stoğu yok!");
        }

        return "";
    }

    private CarDto getCarDto(String id){
        return restTemplate.getForObject("http://localhost:8084/api/cars/getById/" + id,CarDto.class);

    }
    public String submitCustomer(CreateRentalCarRequest request){
        CustomerDto customerDto=getCustomerDto(request.getCustomerId());
        if(customerDto.getRentDay()>7){
            throw new RuntimeException("Araç 7 günden fazla kiralanamaz");
        }
        return "";
    }
    private  CustomerDto getCustomerDto(int customerId){
        return restTemplate.getForObject("http://localhost:8089/api/customers/getById/" + customerId,
                CustomerDto.class);
    }
    public String submitAndCheckSuccess(CreateRentalCarRequest request) {
        try {
            submitOrder(request);
            submitCustomer(request);

            return "Sisteme ekleme işlemi başarıyla gerçekleştirildi.";
        } catch (RuntimeException e) {
            return "Sisteme ekleme işlemi başarısız: " + e.getMessage();
        }
    }




}
