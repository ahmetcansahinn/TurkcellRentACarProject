package com.turkcell.rentalservice.business;

import com.turkcell.rentalservice.dtos.CarDto;
import com.turkcell.rentalservice.dtos.CreateRentalCarRequest;
import com.turkcell.rentalservice.dtos.CustomerDto;
import com.turkcell.rentalservice.entities.RentalCar;
import com.turkcell.rentalservice.repository.RentalCarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RentalCarManager implements RentalCarService {
    private final RentalCarRepository rentalCarRepository;
    private final RestTemplate restTemplate;
    private final KafkaTemplate<String, String> kafkaTemplate;

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
        if (customerDto.getBalance()<500) {
            throw new RuntimeException("Sistem için yeterli bakiye yok!");
        }
        return "Müşteri bilgileri doğrulandı.";
    }

    public String submitAndCheckSuccess(CreateRentalCarRequest request) {

        try {
            submitOrder(request);
            submitCustomer(request);
            submitUpdate(request);


            kafkaTemplate.send("notificationTopic","Araç kiralandı");
            RentalCar rentalCar=new RentalCar();
            CustomerDto customerDto = getCustomerDto(request.getCustomerId());
            CarDto carDto = getCarDto(request.getCarId());
            rentalCar.setCarId(carDto.getCarId());
            rentalCar.setBrand(carDto.getBrand());
            rentalCar.setCustomerId(customerDto.getCustomerId());
            rentalCar.setCustomerName(customerDto.getCustomerName());
            rentalCar.setDailyPrice(carDto.getDailyPrice());


            rentalCarRepository.save(rentalCar);



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
        Mono<CarDto> carDtoMono = WebClient.create()
                .get()
                .uri("http://localhost:8084/api/cars/getById/{id}", id)
                .retrieve()
                .bodyToMono(CarDto.class);

        return carDtoMono.block();
    }

    private CustomerDto getCustomerDto(int customerId) {
        Mono<CustomerDto> customerDtoMono = WebClient.create()
                .get()
                .uri("http://localhost:8089/api/customers/getById/{customerId}", customerId)
                .retrieve()
                .bodyToMono(CustomerDto.class);

        return customerDtoMono.block();
    }
}