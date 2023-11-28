package com.turkcell.customerservice.service;

import com.turkcell.customerservice.entities.Customer;

import java.util.Optional;

public interface CustomerService {
    Customer getById(int customerId);
    Customer addCustomer(Customer customer);
    Optional<Customer> getByCustomerId(int id);

}
