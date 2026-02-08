package com.ecommerce.model.product;

public abstract class Product {

    private final String id;
    private String name;
    private double price;
    private ProductCategory category;
    private ProductVariant variant;

    protected Product(String id, String name, double price, ProductCategory category, ProductVariant variant) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.variant = variant;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public ProductVariant getVariant() {
        return variant;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract boolean isShippable();
}
