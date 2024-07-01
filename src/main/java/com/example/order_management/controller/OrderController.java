package com.example.order_management.controller;

import com.example.order_management.entity.Order;
import com.example.order_management.kafka.OrderProducer;
import com.example.order_management.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        order.setStatus("PLACED");
        Order savedOrder = orderRepository.save(order);
        orderProducer.sendMessage(savedOrder);
        return savedOrder;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
