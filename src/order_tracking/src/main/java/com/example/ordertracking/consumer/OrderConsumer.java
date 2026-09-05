package com.example.ordertracking.consumer;

import com.example.ordertracking.model.OrderEvent;
import com.example.ordertracking.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger log = LoggerFactory.getLogger(OrderConsumer.class);

    private final OrderRepository orderRepository;
    private final StringRedisTemplate redisTemplate;

    public OrderConsumer(OrderRepository orderRepository, StringRedisTemplate redisTemplate) {
        this.orderRepository = orderRepository;
        this.redisTemplate = redisTemplate;
    }

    @KafkaListener(topics = "order-events", groupId = "order-group")
    public void consume(OrderEvent event) {
        log.info("Received from Kafka → {}", event);

        // 1. Save full event to Cassandra (history)
        orderRepository.save(event);
        log.info("Saved to Cassandra → orderId={}", event.getOrderId());

        // 2. Update latest status in Redis (cache)
        String redisKey = "order:" + event.getOrderId();
        redisTemplate.opsForValue().set(redisKey, event.getStatus());
        log.info("Updated Redis → key={}, status={}", redisKey, event.getStatus());
    }
}
