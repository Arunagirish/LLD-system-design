package com.example.ordertracking.producer;

import com.example.ordertracking.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private static final Logger log = LoggerFactory.getLogger(OrderProducer.class);
    private static final String TOPIC = "order-events";

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publish(OrderEvent event) {
        log.info("Publishing to Kafka → topic={}, orderId={}, status={}", TOPIC, event.getOrderId(), event.getStatus());
        kafkaTemplate.send(TOPIC, event.getOrderId().toString(), event);
    }
}
