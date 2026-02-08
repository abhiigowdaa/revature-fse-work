package com.ecommerce.service;

import com.ecommerce.model.payment.*;

public class PaymentFactory {

    public static Payment getPayment(PaymentMethod method) {
        return switch (method) {
            case CREDIT_CARD -> new CreditCardPayment();
            case UPI -> new UPIPayment();
            case COD -> amount -> {
                System.out.println("Cash on Delivery selected: " + amount);
                return true;
            };
        };
    }
}
