package service;

import model.Order;

public class OrderService {
    private static final int MAX_ORDERS = 100;
    private static Order[] orders = new Order[MAX_ORDERS];
    private static int orderCount = 0;

    public static void placeOrder(Order order) {
        if (orderCount < MAX_ORDERS) {
            orders[orderCount] = order;
            orderCount++;
        } else {
            System.out.println("Maximum order limit reached.");
        }
    }

    public static double getTotalAmount() {
        double totalAmount = 0;
        for (int i = 0; i < orderCount; i++) {
            totalAmount += orders[i].getPrice() * orders[i].getQuantity();
        }
        return totalAmount;
    }

    public static int getOrderCount() {
        return orderCount;
    }

    public static Order getOrder(int index) {
        if (index >= 0 && index < orderCount) {
            return orders[index];
        } else {
            return null;
        }
    }
}

