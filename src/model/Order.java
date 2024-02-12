package model;

public class Order {
    private int orderNumber;
    private int tableNumber;
    private int itemNumber;
    private int quantity;
    private double price;

    public Order(int orderNumber, int tableNumber, int itemNumber, int quantity, double price) {
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.itemNumber = itemNumber;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and setters
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

