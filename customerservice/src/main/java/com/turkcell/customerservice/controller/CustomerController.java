package com.turkcell.customerservice.controller;

import com.turkcell.customerservice.entities.Customer;
import com.turkcell.customerservice.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/customers")
@RestController
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;


    @GetMapping("findById")
    public ResponseEntity<Customer> getCustomerById(@PathVariable int customerId) {
        Customer customer = customerService.getById(customerId);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/balance")
    public Boolean getByBalance(@RequestParam String inventoryCode,
                                      @RequestParam int requiredBalance){
        return customerService.getByIdForBalance(inventoryCode,requiredBalance);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Customer add(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
}
