package com.ecommerce.model.product;

public class PhysicalProduct extends Product {

    private double weightKg;

    public PhysicalProduct(String id, String name, double price, ProductCategory category,
                           ProductVariant variant, double weightKg) {
        super(id, name, price, category, variant);
        this.weightKg = weightKg;
    }

    @Override
    public boolean isShippable() {
        return true;
    }
}
