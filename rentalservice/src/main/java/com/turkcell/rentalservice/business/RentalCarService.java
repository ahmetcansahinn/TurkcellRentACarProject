package com.turkcell.rentalservice.business;

import com.turkcell.rentalservice.dtos.CarDto;
import com.turkcell.rentalservice.dtos.CreateRentalCarRequest;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface RentalCarService {
    String submitOrder( CreateRentalCarRequest request);
    public String submitAndCheckSuccess(CreateRentalCarRequest request);
    public String submitCustomer(CreateRentalCarRequest request);


}
