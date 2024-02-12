import model.Order;
import service.OrderService;
import util.PriceUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class CafeOrderManagement {
    // Defined the necessary constant
    private static final double VAT_RATE = 0.20;
    private static final String[] TABLE_STAFF = { "Kiran", "Sam", "Jill", "Jill", "Sam", "Jill", "Sam", "Sam", "Jill" };

    public static void main(String[] args) {

        //Declared a scanner object for user input
        Scanner scanner = new Scanner(System.in);
        int userChoice;

        System.out.println("Welcome to the Family Cafe!");

        // Main program loop
        do {
            // Display menu options
            System.out.println("\n1. Place order");
            System.out.println("2. Display invoice");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            userChoice = nextIntSafe(scanner);

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
        } while (userChoice != 3);  // Continue until user chooses to exit

        scanner.close(); // Close scanner to prevent resource leak
    }

    // Method to handle placing an order
    private static void placeOrder(Scanner scanner) {
        int tableNumber;

        // Prompt user for table number and validate
        do {
            System.out.print("Enter table number: ");
            tableNumber = nextIntSafe(scanner);
            int topTable = TABLE_STAFF.length - 1;
            if (tableNumber < 0 || tableNumber > topTable) {
                System.out.println("Invalid table number. Please enter a number between 0 and " + topTable + ".");
            }
        } while (tableNumber < 0 || tableNumber > TABLE_STAFF.length - 1);

        Order currentOrder;
        Order lastOrderForTable = OrderService.getLastOrderForTable(tableNumber);

        // Create a new order or use the last order for this table
        if (OrderService.getOrderCount() == 0 || lastOrderForTable == null) {
            currentOrder = new Order(OrderService.getOrderCount() + 101, tableNumber); //If this is a new order
        } else {
            currentOrder = lastOrderForTable; //If user want to add more items within the same order.
        }

        // Loop to allow the user to add multiple items to the order
        do {
            int itemNumber, quantity;

            // Prompt user for item number and validate
            do {
                System.out.print("Enter item number: ");
                itemNumber = nextIntSafe(scanner);
                if (itemNumber < 11 || itemNumber > 96) {
                    System.out.println("Invalid item number. Please enter a number between 11 and 96.");
                } else if (PriceUtil.getItemName(itemNumber) == null) {
                    System.out.println("Item number " + itemNumber + " is not available.");
                }
            } while (itemNumber < 11 || itemNumber > 96 || PriceUtil.getItemName(itemNumber) == null);

            // Prompt user for quantity
            System.out.print("Enter quantity: ");
            quantity = nextIntSafe(scanner);

            // Calculate item price
            double individualPrice = PriceUtil.getIndividualItemPrice(itemNumber); // calculating value for price column.
            double itemPrice = individualPrice * quantity; //calculating value for subprice column.

            // Add item to the order
            currentOrder.addItem(itemNumber, quantity, itemPrice);

            // Ask user if they want to order more items
            System.out.print("Do you want to order more items? (1 for yes, 0 for no): ");
            int moreItems = nextIntSafe(scanner);

            if (moreItems == 0) {
                // If the user doesn't want to order more items, break out of the loop
                break;
            }
        } while (true);

        // Place the order
        OrderService.placeOrder(currentOrder);
        System.out.println("Order placed successfully!");
    }


    //function to display invoice.
    private static void displayInvoice() {
        // Iterate through orders
        for (int i = 0; i < OrderService.getOrderCount(); i++) {
            Order order = OrderService.getOrder(i);
            int orderNumber = order.getOrderNumber();
            int tableNumber = order.getTableNumber();
            String staff = TABLE_STAFF[tableNumber];

            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");
            String formattedDate = currentDate.format(formatter);

            // Print order information
            System.out.printf("Order# %d%56sTable# %d%n", orderNumber, "", tableNumber);
            System.out.printf("Date: %-15s%45sStaff: %s%n", formattedDate, "", staff);
            System.out.println("Item#      Name                              Qty      Price       Sub-total");

            double totalAmount = 0;

            // Add item details
            int itemCount = order.getItemCount();
            for (int j = 0; j < itemCount; j++) {
                int itemNumber = order.getItemNumber(j);
                String itemName = PriceUtil.getItemName(itemNumber);
                int quantity = order.getItemQuantity(j);
                double price = PriceUtil.getIndividualItemPrice(itemNumber);
                double subtotal = price * quantity;
                totalAmount += subtotal;

                // Print item details with aligned formatting
                System.out.printf("%-10d%-35s%-9d%-12.2f%-9.2f%n", itemNumber, itemName, quantity, price, subtotal);
            }

            // Calculate VAT and net amount for the current order
            double vatAmount = totalAmount * VAT_RATE / (1 + VAT_RATE);
            double netAmount = totalAmount - vatAmount;

            // Print total, VAT, and net amount for the current order
            System.out.printf("%54sTotal%11.2f%n", "", totalAmount);
            System.out.printf("%54sVAT (%.0f%%)%7.2f%n", "", VAT_RATE * 100, vatAmount);
            System.out.printf("%54sNet Amount %8.2f%n", "", netAmount);

            // Add a separator between orders
            if (i != OrderService.getOrderCount() - 1) {
                System.out.println("---------------------------------------------------------------------");
            }
        }
    }



    //Function for numeric input validation
    private static int nextIntSafe(Scanner scanner) {
        int number;
        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                break;
            } else {
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.next(); // consume invalid input
            }
        }
        return number;
    }
}
