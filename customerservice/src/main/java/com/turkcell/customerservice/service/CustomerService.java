package com.turkcell.customerservice.service;

import com.turkcell.customerservice.entities.Customer;

public interface CustomerService {
    Customer getById(int customerId);
}
