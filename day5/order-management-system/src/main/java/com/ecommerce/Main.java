package com.ecommerce;

import com.ecommerce.model.customer.Customer;
import com.ecommerce.model.customer.CustomerTier;
import com.ecommerce.model.product.*;
import com.ecommerce.service.InventoryService;
import com.ecommerce.model.discount.PercentageDiscount;
import com.ecommerce.model.order.ShoppingCart;
import com.ecommerce.model.order.*;
import com.ecommerce.model.payment.PaymentMethod;
import com.ecommerce.service.OrderService;
import com.ecommerce.service.OrderTask;

import java.util.concurrent.*;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        InventoryService inventoryService = new InventoryService();

        String productId = "P1001";

        Product tshirt = new PhysicalProduct(
                productId,
                "T-Shirt",
                499.0,
                ProductCategory.FASHION,
                new ProductVariant("L", "Black"),
                0.3
        );

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(tshirt, 2);

        double total = cart.calculateTotal();
        System.out.println("Cart total: " + total);

        PercentageDiscount discount = new PercentageDiscount(10);
        double discountedTotal = discount.apply(total);
        System.out.println("After 10% discount: " + discountedTotal);

        inventoryService.addStock(productId, 10);

        OrderService orderService = new OrderService();

        OrderItem orderItem = new OrderItem(tshirt, 1);
        Order order = orderService.placeOrder("ORD-1", List.of(orderItem), PaymentMethod.UPI);

        ExecutorService executor = new ThreadPoolExecutor(
                2,
                4,
                0L,
                TimeUnit.MILLISECONDS,
                new PriorityBlockingQueue<>()
        );

        Customer gold = new Customer("C1", "Rahul", CustomerTier.GOLD);
        Customer platinum = new Customer("C2", "Anita", CustomerTier.PLATINUM);

        OrderTask task1 = new OrderTask(gold, order);
        OrderTask task2 = new OrderTask(platinum, order);

        executor.submit(task1);
        executor.submit(task2);

        executor.shutdown();

        System.out.println("Order status: " + order.getStatus());

        System.out.println("Stock before: " + inventoryService.getAvailableStock(productId));

        inventoryService.reserveStock(productId, 2);

        System.out.println("Stock after: " + inventoryService.getAvailableStock(productId));
    }
}
