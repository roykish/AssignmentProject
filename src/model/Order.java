package model;

public class Order {
    private int orderNumber;
    private int tableNumber;
    private int[] itemNumbers;
    private int[] quantities;
    private double[] prices;
    private int itemCount;

    public Order(int orderNumber, int tableNumber) {
        this.orderNumber = orderNumber;
        this.tableNumber = tableNumber;
        this.itemNumbers = new int[100]; // Initial capacity
        this.quantities = new int[100]; // Initial capacity
        this.prices = new double[100]; // Initial capacity
        this.itemCount = 0;
    }

    public void addItem(int itemNumber, int quantity, double price) {
        itemNumbers[itemCount] = itemNumber;
        quantities[itemCount] = quantity;
        prices[itemCount] = price;
        itemCount++;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getTableNumber() {
        return tableNumber;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getItemNumber(int index) {
        return itemNumbers[index];
    }

    public int getItemQuantity(int index) {
        return quantities[index];
    }

    public double getItemPrice(int index) {
        return prices[index];
    }
}
