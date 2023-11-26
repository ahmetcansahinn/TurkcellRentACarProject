package com.turkcell.customerservice.controller;

import com.turkcell.customerservice.entities.Customer;
import com.turkcell.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;


    @GetMapping("/getById/{customerId}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) {
        Customer customer = customerService.getById(customerId);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


    @PostMapping
    public Customer addCustomer(Customer customer) {

        return customerService.addCustomer(customer);
    }
}
