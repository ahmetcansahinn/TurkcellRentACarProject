package com.turkcell.customerservice.repository;

import com.turkcell.customerservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("SELECT c FROM Customer c WHERE c.inventoryCode = :inventoryCode")
    Customer findByInventoryCodeQuery(@Param("inventoryCode") String inventoryCode);
}
