package com.ecommerce.model.payment;

public class CreditCardPayment implements Payment {
    @Override
    public boolean pay(double amount) {
        System.out.println("Processing credit card payment of " + amount);
        return true; // simulate success
    }
}
