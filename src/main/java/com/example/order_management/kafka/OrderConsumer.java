package com.example.order_management.kafka;

import com.example.order_management.entity.Order;
import com.example.order_management.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    @Autowired
    private OrderRepository orderRepository;

    @KafkaListener(topics = "orders", groupId = "order-group")
    public void consume(Order order) {
        // Process the order (e.g., update status)
        order.setStatus("PROCESSING");
        orderRepository.save(order);
    }
}
