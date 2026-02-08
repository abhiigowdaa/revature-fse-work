package com.ecommerce.model.order;

import com.ecommerce.model.product.Product;

public class CartItem {
    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void increment(int qty) {
        this.quantity += qty;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }
}
