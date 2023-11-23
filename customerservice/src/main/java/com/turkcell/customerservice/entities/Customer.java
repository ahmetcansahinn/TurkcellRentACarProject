package com.turkcell.customerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="customer_id")
    private int customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_last_name")
    private String customerLastName;
    @Column(name = "balance")
    private double balance;
    @Column(name = "inventory_code")
    private int inventoryCode;




}
