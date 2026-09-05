package com.example.ordertracking.service;

import com.example.ordertracking.model.OrderEvent;
import com.example.ordertracking.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderQueryService {

    private static final Logger log = LoggerFactory.getLogger(OrderQueryService.class);

    private final StringRedisTemplate redisTemplate;
    private final OrderRepository orderRepository;

    public OrderQueryService(StringRedisTemplate redisTemplate, OrderRepository orderRepository) {
        this.redisTemplate = redisTemplate;
        this.orderRepository = orderRepository;
    }

    // Returns current status — Redis first, Cassandra fallback
    public String getCurrentStatus(UUID orderId) {
        String redisKey = "order:" + orderId;
        String status = redisTemplate.opsForValue().get(redisKey);

        if (status != null) {
            log.info("Cache HIT → Redis key={}, status={}", redisKey, status);
            return status;
        }

        log.info("Cache MISS → querying Cassandra for orderId={}", orderId);
        List<OrderEvent> history = orderRepository.findByOrderId(orderId);

        if (history.isEmpty()) {
            return null;
        }

        // Last event in Cassandra = latest status (clustered by time)
        String latestStatus = history.get(history.size() - 1).getStatus();

        // Repopulate Redis
        redisTemplate.opsForValue().set(redisKey, latestStatus);
        log.info("Repopulated Redis → key={}, status={}", redisKey, latestStatus);

        return latestStatus;
    }

    // Returns full order history from Cassandra
    public List<OrderEvent> getHistory(UUID orderId) {
        return orderRepository.findByOrderId(orderId);
    }
}
