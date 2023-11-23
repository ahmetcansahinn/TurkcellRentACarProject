package com.turkcell.customerservice.service;

import com.turkcell.customerservice.entities.Customer;

public interface CustomerService {
    Customer getById(int customerId);

    boolean getByIdForBalance(String inventoryCode,double requiredBalance);

    Customer addCustomer(Customer customer);



}
