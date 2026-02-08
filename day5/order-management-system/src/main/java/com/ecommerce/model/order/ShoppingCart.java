package com.ecommerce.model.order;

import com.ecommerce.model.product.Product;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;

public class ShoppingCart {

    private final Map<String, CartItem> items = new LinkedHashMap<>();
    private Instant lastUpdated = Instant.now();

    public void addItem(Product product, int quantity) {
        items.compute(product.getId(), (k, v) -> {
            if (v == null) return new CartItem(product, quantity);
            v.increment(quantity);
            return v;
        });
        touch();
    }

    public void removeItem(String productId) {
        items.remove(productId);
        touch();
    }

    public double calculateTotal() {
        return items.values().stream()
                .mapToDouble(CartItem::getTotalPrice)
                .sum();
    }

    public boolean isExpired(long expirySeconds) {
        return Instant.now().minusSeconds(expirySeconds).isAfter(lastUpdated);
    }

    private void touch() {
        lastUpdated = Instant.now();
    }
}
