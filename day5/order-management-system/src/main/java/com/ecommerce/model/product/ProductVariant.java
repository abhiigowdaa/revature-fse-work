package com.ecommerce.model.product;

public class ProductVariant {
    private final String size;
    private final String color;

    public ProductVariant(String size, String color) {
        this.size = size;
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }
}
