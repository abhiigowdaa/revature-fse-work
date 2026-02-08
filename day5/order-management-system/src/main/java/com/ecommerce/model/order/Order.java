package com.ecommerce.model.order;

import java.time.Instant;
import java.util.List;

public class Order {

    private final String orderId;
    private final List<OrderItem> items;
    private OrderStatus status;
    private final Instant createdAt;

    public Order(String orderId, List<OrderItem> items) {
        this.orderId = orderId;
        this.items = items;
        this.status = OrderStatus.PENDING;
        this.createdAt = Instant.now();
    }

    public double getTotalAmount() {
        return items.stream().mapToDouble(OrderItem::getTotalPrice).sum();
    }

    public void updateStatus(OrderStatus status) {
        this.status = status;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public String getOrderId() {
        return orderId;
    }
}
