package com.example.ordertracking.model;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.Instant;
import java.util.UUID;

@Table("orders")
public class OrderEvent {

    @PrimaryKeyColumn(name = "order_id", type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.UUID)
    private UUID orderId;

    @PrimaryKeyColumn(name = "event_time", type = PrimaryKeyType.CLUSTERED)
    @CassandraType(type = CassandraType.Name.TIMEUUID)
    private UUID eventTime;

    @Column("status")
    private String status;

    @Column("customer_name")
    private String customerName;

    // used by Kafka deserialization
    public OrderEvent() {}

    public OrderEvent(UUID orderId, OrderStatus status, String customerName) {
        this.orderId = orderId;
        this.eventTime = Uuids.timeBased();
        this.status = status.name();
        this.customerName = customerName;
    }

    public UUID getOrderId() { return orderId; }
    public void setOrderId(UUID orderId) { this.orderId = orderId; }

    public UUID getEventTime() { return eventTime; }
    public void setEventTime(UUID eventTime) { this.eventTime = eventTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    @Override
    public String toString() {
        return "OrderEvent{orderId=" + orderId + ", status=" + status + ", customer=" + customerName + "}";
    }
}
