package com.ecommerce.service;

import com.ecommerce.model.order.*;
import com.ecommerce.model.payment.*;

import java.util.List;

public class OrderService {

    public Order placeOrder(String orderId, List<OrderItem> items, PaymentMethod method) {
        Order order = new Order(orderId, items);

        Payment payment = PaymentFactory.getPayment(method);
        boolean success = payment.pay(order.getTotalAmount());

        if (success) {
            order.updateStatus(OrderStatus.CONFIRMED);
        }

        return order;
    }
}
