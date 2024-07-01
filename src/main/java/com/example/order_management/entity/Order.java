package com.example.order_management.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;
    private int quantity;
    private double price;
    private String status;
}
