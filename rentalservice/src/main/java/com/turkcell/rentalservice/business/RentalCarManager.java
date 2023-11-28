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

import java.util.Arrays;
import java.util.List;
@Service
@RequiredArgsConstructor
public class RentalCarManager implements RentalCarService {
    private final RentalCarRepository rentalCarRepository;
    private final RestTemplate restTemplate;

    @Override
    public String submitOrder(CreateRentalCarRequest request) {
        CarDto carDto = getCarDto(request.getCarId());
        if (carDto.getHasStock() <= 0) {
            throw new RuntimeException("Aracın stoğu yok!");
        }

        return "Araç başarıyla kiralandı.";
    }

    public String submitCustomer(CreateRentalCarRequest request) {
        CustomerDto customerDto = getCustomerDto(request.getCustomerId());
        if (customerDto.getRentDay() > 7) {
            throw new RuntimeException("Araç 7 günden fazla kiralanamaz");
        }
        return "Müşteri bilgileri doğrulandı.";
    }

    public String submitAndCheckSuccess(CreateRentalCarRequest request) {

        try {
            submitOrder(request);
            submitCustomer(request);
            submitUpdate(request);

            return "Sisteme ekleme işlemi başarıyla gerçekleştirildi.";
        } catch (RuntimeException e) {
            return "Sisteme ekleme işlemi başarısız: " + e.getMessage();
        }
    }

    public String submitUpdate(CreateRentalCarRequest request) {
        try {
            updateCarStock(request.getCarId());
            return "Araç stoktan 1 adet azaltılarak güncellendi.";
        } catch (RuntimeException e) {
            return "Araç stok güncelleme işlemi başarısız: " + e.getMessage();
        }
    }

    private void updateCarStock(String carId) {
        CarDto existingCarDto = getCarDto(carId);

        CarDto updatedCarDto = new CarDto();
        updatedCarDto.setBrand(existingCarDto.getBrand());
        updatedCarDto.setColorOfCar(existingCarDto.getColorOfCar());
        updatedCarDto.setModel(existingCarDto.getModel());
        updatedCarDto.setYearOfManufacture(existingCarDto.getYearOfManufacture());
        updatedCarDto.setDailyPrice(existingCarDto.getDailyPrice());
        updatedCarDto.setHasStock(existingCarDto.getHasStock() - 1);
        updatedCarDto.setInventoryCode(existingCarDto.getInventoryCode());

        restTemplate.put("http://localhost:8084/api/cars/updateStock/" + carId, updatedCarDto);
    }

    private CarDto getCarDto(String id) {
        return restTemplate.getForObject("http://localhost:8084/api/cars/getById/" + id, CarDto.class);
    }

    private CustomerDto getCustomerDto(int customerId) {
        return restTemplate.getForObject("http://localhost:8089/api/customers/getById/" + customerId, CustomerDto.class);
    }
}
