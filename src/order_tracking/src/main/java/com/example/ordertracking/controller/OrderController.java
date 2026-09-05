package com.example.ordertracking.controller;

import com.example.ordertracking.model.OrderEvent;
import com.example.ordertracking.model.OrderStatus;
import com.example.ordertracking.producer.OrderProducer;
import com.example.ordertracking.service.OrderQueryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer orderProducer;
    private final OrderQueryService queryService;

    public OrderController(OrderProducer orderProducer, OrderQueryService queryService) {
        this.orderProducer = orderProducer;
        this.queryService = queryService;
    }

    // POST /orders  body: { "customerName": "Alice" }
    @PostMapping
    public ResponseEntity<Map<String, String>> placeOrder(@RequestBody Map<String, String> body) {
        UUID orderId = UUID.randomUUID();
        String customerName = body.getOrDefault("customerName", "Unknown");

        OrderEvent event = new OrderEvent(orderId, OrderStatus.PLACED, customerName);
        orderProducer.publish(event);

        return ResponseEntity.ok(Map.of(
            "orderId", orderId.toString(),
            "status", OrderStatus.PLACED.name(),
            "message", "Order placed! Event published to Kafka."
        ));
    }

    // PUT /orders/{id}/status?status=PAID
    @PutMapping("/{id}/status")
    public ResponseEntity<Map<String, String>> updateStatus(
            @PathVariable UUID id,
            @RequestParam OrderStatus status) {

        // Fetch customer name from history for the event
        List<OrderEvent> history = queryService.getHistory(id);
        if (history.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        String customerName = history.get(0).getCustomerName();

        OrderEvent event = new OrderEvent(id, status, customerName);
        orderProducer.publish(event);

        return ResponseEntity.ok(Map.of(
            "orderId", id.toString(),
            "newStatus", status.name(),
            "message", "Status update published to Kafka."
        ));
    }

    // GET /orders/{id}  — current status (Redis first, Cassandra fallback)
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, String>> getStatus(@PathVariable UUID id) {
        String status = queryService.getCurrentStatus(id);
        if (status == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(Map.of("orderId", id.toString(), "status", status));
    }

    // GET /orders/{id}/history  — full event history from Cassandra
    @GetMapping("/{id}/history")
    public ResponseEntity<List<OrderEvent>> getHistory(@PathVariable UUID id) {
        List<OrderEvent> history = queryService.getHistory(id);
        if (history.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(history);
    }
}
