package com.ecommerce.model.product;

public class DigitalProduct extends Product {

    private String downloadUrl;

    public DigitalProduct(String id, String name, double price, ProductCategory category,
                          ProductVariant variant, String downloadUrl) {
        super(id, name, price, category, variant);
        this.downloadUrl = downloadUrl;
    }

    @Override
    public boolean isShippable() {
        return false;
    }
}
