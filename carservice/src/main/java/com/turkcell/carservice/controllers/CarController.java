package com.turkcell.carservice.controllers;

import com.turkcell.carservice.business.abstracts.CarService;
import com.turkcell.carservice.dtos.CarImagesDto;
import com.turkcell.carservice.dtos.request.CreateCarRequest;
import com.turkcell.carservice.dtos.response.CreatedCarResponse;
import com.turkcell.carservice.entities.Car;
import com.turkcell.carservice.entities.CarImages;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/api/cars")
@RestController
@RequiredArgsConstructor


public class CarController {
    private final CarService carService;
    private final ImageController imageController;

    @GetMapping
    public ResponseEntity<List<Car>> getAll(){
        List<Car> allCar = carService.getAll();
        return new ResponseEntity<List<Car>>(allCar, HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreatedCarResponse add(@RequestBody CreateCarRequest request){
        return carService.add(request);
    }

    @PutMapping("/updateStock/{id}")
    public ResponseEntity update(@PathVariable String id, @RequestBody CreateCarRequest request){
        carService.update(id, request);
        return new ResponseEntity("Ürün Güncellendi!",HttpStatus.CREATED);
    }
    @GetMapping("/getById/{carId}")
    public Car getByCarId(@PathVariable String carId){
        Car getByCarId = carService.getByCarId(carId);
        return getByCarId;
    }
    @DeleteMapping("/{carId}")
    public void deleteCar(@PathVariable String carId) {
        carService.deleteCar(carId);
    }

    @GetMapping("car-status")
    public String getCarStatus(@RequestParam String carId,
                               @RequestParam String name) {
        return carService.getCarStatus(carId);
    }
    @PostMapping("/AddCarImages")
    public String AddCarImages(@RequestBody List<CarImagesDto> carImagesDtos)  throws IOException {

        List<CarImages> carImagesList = new ArrayList<>();
        for(CarImagesDto item:carImagesDtos) {
            CarImages carImages = new CarImages();
            carImages.setId(item.getId());
            carImages.setCarId(item.getCarId());
            carImages.setCarImage(imageController.uploadImage(item.getBase64Data().replace(" ","")));
            carImagesList.add(carImages);
        }
        carService.addCarImages(carImagesList);
        return ("Araç resim ekleme işlemi başarı ile gerçekleşti.");
    }
    @GetMapping("getByCarId")
    public Optional<Car> getById(@RequestParam String id) {
        return carService.getById(id);
    }


}
