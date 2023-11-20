package com.turkcell.rentalservice.business;

import com.turkcell.rentalservice.dtos.CreateRentalCarRequest;

import java.util.List;

public interface RentalCarService {
boolean availableRent(List<CreateRentalCarRequest> requests);

}
