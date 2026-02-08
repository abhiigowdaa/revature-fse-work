package com.ecommerce.service;

import com.ecommerce.model.customer.Customer;
import com.ecommerce.model.order.Order;

public class OrderTask implements Comparable<OrderTask>, Runnable {

    private final Customer customer;
    private final Order order;

    public OrderTask(Customer customer, Order order) {
        this.customer = customer;
        this.order = order;
    }

    @Override
    public int compareTo(OrderTask o) {
        return o.customer.getTier().ordinal() - this.customer.getTier().ordinal();
    }

    @Override
    public void run() {
        System.out.println("Processing order " + order.getOrderId()
                + " for " + customer.getName()
                + " [" + customer.getTier() + "]");
    }
}
