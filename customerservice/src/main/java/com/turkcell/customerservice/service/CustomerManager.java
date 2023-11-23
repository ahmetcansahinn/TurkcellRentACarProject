package com.turkcell.customerservice.service;

import com.turkcell.customerservice.entities.Customer;
import com.turkcell.customerservice.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerManager implements CustomerService{
    private final CustomerRepository customerRepository;

    @Override
    public Customer getById(int customerId) {
        return customerRepository.findById(customerId).orElseThrow() ;
    }

    @Override
    public boolean getByIdForBalance(String inventoryCode, double requiredBalance) {
        Customer customer = customerRepository.findByInventoryCodeQuery(inventoryCode);
        if(customer == null || customer.getBalance() <requiredBalance)

            return false;
        return true;
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
