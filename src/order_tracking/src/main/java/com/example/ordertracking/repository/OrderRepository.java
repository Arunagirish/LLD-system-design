package com.example.ordertracking.repository;

import com.example.ordertracking.model.OrderEvent;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends CassandraRepository<OrderEvent, UUID> {

    // get full history of an order sorted by time (Cassandra clustering key)
    @Query("SELECT * FROM orders WHERE order_id = ?0")
    List<OrderEvent> findByOrderId(UUID orderId);
}
