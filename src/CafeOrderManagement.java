import model.Order;
import service.OrderService;
import util.PriceUtil;
import util.TableBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CafeOrderManagement {
    private static final double VAT_RATE = 0.20;
    private static String[] tableStaff = { "Kiran", "Sam", "Jill", "Jill", "Sam", "Jill", "Sam", "Sam", "Jill" };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int userChoice;

        System.out.println("Welcome to the Family Cafe!");

        do {
            // Display menu options
            System.out.println("\n1. Place order");
            System.out.println("2. Display invoice");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextInt();

            switch (userChoice) {
                case 1:
                    placeOrder(scanner);
                    break;
                case 2:
                    displayInvoice();
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (userChoice != 3);

        scanner.close();
    }

    private static void placeOrder(Scanner scanner) {
        int tableNumber, itemNumber, quantity;

        // Prompt user for order details
        System.out.print("Enter table number: ");
        tableNumber = scanner.nextInt();
        System.out.print("Enter item number: ");
        itemNumber = scanner.nextInt();
        System.out.print("Enter quantity: ");
        quantity = scanner.nextInt();

        // Validate table number and item number
        if (tableNumber < 0 || tableNumber >= tableStaff.length || itemNumber < 11 || itemNumber > 96) {
            System.out.println("Invalid table number or item number.");
            return;
        }

        double individualPrice = PriceUtil.getIndividualItemPrice(itemNumber);
        double itemPrice = PriceUtil.getItemPrice(itemNumber, quantity);
        Order order = new Order(OrderService.getOrderCount() + 101, tableNumber, itemNumber, quantity, itemPrice);
        OrderService.placeOrder(order);
        System.out.println("Order placed successfully!");
    }

    private static void displayInvoice() {
        TableBuilder tableBuilder = new TableBuilder();
        tableBuilder.addRow("Order#", "Table#", "Date", "Staff", "Item#", "Name", "Qty", "Price", "Sub-total");

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
        String formattedDate = currentDate.format(formatter);

        double totalAmount = 0;

        for (int i = 0; i < OrderService.getOrderCount(); i++) {
            Order order = OrderService.getOrder(i);
            int orderNumber = order.getOrderNumber();
            int tableNumber = order.getTableNumber();
            String staff = tableStaff[tableNumber];
            int itemNumber = order.getItemNumber();
            String itemName = PriceUtil.getItemName(itemNumber);
            int quantity = order.getQuantity();

            double individualPrice = PriceUtil.getIndividualItemPrice(itemNumber);
            double price = individualPrice; // individual price for one item
            double subtotal = price * quantity;

            // Add item price to the total amount
            totalAmount += subtotal;

            tableBuilder.addRow(String.valueOf(orderNumber), String.valueOf(tableNumber), formattedDate, staff, String.valueOf(itemNumber), itemName, String.valueOf(quantity), String.format("%.2f", price), String.format("%.2f", subtotal));
        }

        double vatAmount = totalAmount * VAT_RATE / (1 + VAT_RATE);
        double netAmount = totalAmount - vatAmount;

        tableBuilder.addRow("", "", "", "", "", "", "Total:", "", String.format("%.2f", totalAmount));
        tableBuilder.addRow("", "", "", "", "", "", "VAT (" + (VAT_RATE * 100) + "%):", "", String.format("%.2f", vatAmount));
        tableBuilder.addRow("", "", "", "", "", "", "Net amount:", "", String.format("%.2f", netAmount));

        System.out.println(tableBuilder.toString());
    }

}


