package com.example.order_management.kafka;

import com.example.order_management.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final String TOPIC = "orders";

    @Autowired
    private KafkaTemplate<String, Order> kafkaTemplate;

    public void sendMessage(Order order) {
        kafkaTemplate.send(TOPIC, order);
    }
}
