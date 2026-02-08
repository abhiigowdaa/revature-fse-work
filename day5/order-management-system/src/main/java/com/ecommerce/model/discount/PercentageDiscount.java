package com.ecommerce.model.discount;

public class PercentageDiscount implements Discount {

    private final double percentage;

    public PercentageDiscount(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double apply(double totalAmount) {
        return totalAmount - (totalAmount * (percentage / 100));
    }
}
