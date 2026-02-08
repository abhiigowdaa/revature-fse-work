package com.ecommerce.model.customer;

public class Customer {
    private final String id;
    private final String name;
    private final CustomerTier tier;

    public Customer(String id, String name, CustomerTier tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }

    public CustomerTier getTier() {
        return tier;
    }

    public String getName() {
        return name;
    }
}
