package com.ecommerce.model.payment;

public class UPIPayment implements Payment {
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing UPI payment of " + amount);
        return true;
    }
}
