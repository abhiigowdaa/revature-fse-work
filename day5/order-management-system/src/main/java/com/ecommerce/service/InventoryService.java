package com.ecommerce.service;

import com.ecommerce.exception.InsufficientStockException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InventoryService {

    // productId -> available stock
    private final Map<String, Integer> stockMap = new ConcurrentHashMap<>();

    public void addStock(String productId, int quantity) {
        stockMap.merge(productId, quantity, Integer::sum);
    }

    public synchronized void reserveStock(String productId, int quantity) {
        int available = stockMap.getOrDefault(productId, 0);
        if (available < quantity) {
            throw new InsufficientStockException("Insufficient stock for product: " + productId);
        }
        stockMap.put(productId, available - quantity);
    }

    public int getAvailableStock(String productId) {
        return stockMap.getOrDefault(productId, 0);
    }
}
