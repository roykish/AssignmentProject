package util;

public class PriceUtil {



    //This function will take the item number and see the price of that item
    public static double getIndividualItemPrice(int itemNumber) {
        switch (itemNumber) {
            case 11:
                return 1.99;
            case 12:
                return 2.35 ;
            case 13:
                return 2.10 ;
            case 14:
                return 2.25;
            case 21:
                return 3.20 ;
            case 22:
                return 2.50;
            case 23:
                return 3.75;
            case 24:
                return 2.75;
            case 31:
                return 2.25;
            case 32:
                return 3.20;
            case 33:
                return 3.75;
            case 34:
                return 3.55;
            case 41:
                return 3.75 ;
            case 42:
                return 3.25;
            case 43:
                return 3.95 ;
            case 45:
                return 2.95 ;
            case 46:
                return 3.29 ;
            case 47:
                return 5.65 ;
            case 48:
                return 5.75 ;
            case 49:
                return 4.95 ;
            case 51:
                return 6.95 ;
            case 52:
                return 7.95 ;
            case 53:
                return 6.95 ;
            case 54:
                return 6.79 ;
            case 55:
                return 6.95 ;
            case 56:
                return 5.99 ;
            case 57:
                return 3.50 ;
            case 60:
                return 2.55 ;
            case 61:
                return 2.20 ;
            case 62:
                return 2.95 ;
            case 71:
                return 2.50 ;
            case 72:
                return 2.99 ;
            case 73:
                return 2.99 ;
            case 74:
                return 2.25 ;
            case 81:
                return 2.10 ;
            case 82:
                return 3.99 ;
            case 83:
                return 2.25 ;
            case 84:
                return 2.99 ;
            case 91:
                return 2.10 ;
            case 92:
                return 2.50 ;
            case 93:
                return 2.75 ;
            case 94:
                return 2.95 ;
            case 95:
                return 2.35 ;
            case 96:
                return 1.75 ;
            default:
                return 0;
        }
    }


    //This function is for calculating item price.
    public static double getItemPrice(int itemNumber, int quantity) {
        switch (itemNumber) {
            case 11:
                return 1.99 * quantity;
            case 12:
                return 2.35 * quantity;
            case 13:
                return 2.10 * quantity;
            case 14:
                return 2.25 * quantity;
            case 21:
                return 3.20 * quantity;
            case 22:
                return 2.50 * quantity;
            case 23:
                return 3.75 * quantity;
            case 24:
                return 2.75 * quantity;
            case 31:
                return 2.25 * quantity;
            case 32:
                return 3.20 * quantity;
            case 33:
                return 3.75 * quantity;
            case 34:
                return 3.55 * quantity;
            case 41:
                return 3.75 * quantity;
            case 42:
                return 3.25 * quantity;
            case 43:
                return 3.95 * quantity;
            case 45:
                return 2.95 * quantity;
            case 46:
                return 3.29 * quantity;
            case 47:
                return 5.65 * quantity;
            case 48:
                return 5.75 * quantity;
            case 49:
                return 4.95 * quantity;
            case 51:
                return 6.95 * quantity;
            case 52:
                return 7.95 * quantity;
            case 53:
                return 6.95 * quantity;
            case 54:
                return 6.79 * quantity;
            case 55:
                return 6.95 * quantity;
            case 56:
                return 5.99 * quantity;
            case 57:
                return 3.50 * quantity;
            case 60:
                return 2.55 * quantity;
            case 61:
                return 2.20 * quantity;
            case 62:
                return 2.95 * quantity;
            case 71:
                return 2.50 * quantity;
            case 72:
                return 2.99 * quantity;
            case 73:
                return 2.99 * quantity;
            case 74:
                return 2.25 * quantity;
            case 81:
                return 2.10 * quantity;
            case 82:
                return 3.99 * quantity;
            case 83:
                return 2.25 * quantity;
            case 84:
                return 2.99 * quantity;
            case 91:
                return 2.10 * quantity;
            case 92:
                return 2.50 * quantity;
            case 93:
                return 2.75 * quantity;
            case 94:
                return 2.95 * quantity;
            case 95:
                return 2.35 * quantity;
            case 96:
                return 1.75 * quantity;
            default:
                return 0;
        }
    }

    //This function is for getting the item name.
    public static String getItemName(int itemNumber) {
        switch (itemNumber) {
            case 11:
                return "Sweet corn";
            case 12:
                return "Sweet corn w/ chicken";
            case 13:
                return "Cream of Tomato/Mushroom";
            case 14:
                return "Veg soup";
            case 21:
                return "Baked Beans";
            case 22:
                return "Cheese";
            case 23:
                return "Tuna";
            case 24:
                return "Coleslaw";
            case 31:
                return "Cheese";
            case 32:
                return "Ham & Cheese";
            case 33:
                return "Bacon Egg Cheese";
            case 34:
                return "Sausage Egg cheese";
            case 41:
                return "Ham&Brie";
            case 42:
                return "Grilled Chicken Mayo";
            case 43:
                return "Prawn salad";
            case 45:
                return "Egg May";
            case 46:
                return "Tuna sweetcorn";
            case 47:
                return "Chicken";
            case 48:
                return "Hamburger";
            case 49:
                return "Veggie";
            case 51:
                return "Steak & Ale Pie";
            case 52:
                return "Fish & chips";
            case 53:
                return "Breaded Scampi w/ fries";
            case 54:
                return "Chicken pasta";
            case 55:
                return "Lasagne";
            case 56:
                return "Spaghetti Bolognese";
            case 57:
                return "Hotdog w/ fries";
            case 60:
                return "Chicken nuggets";
            case 61:
                return "Macaroni Cheese";
            case 62:
                return "Pigs in a blanket";
            case 71:
                return "French fries";
            case 72:
                return "Onion rings";
            case 73:
                return "Garlic bread";
            case 74:
                return "Nachos cheese/guac/salsa";
            case 81:
                return "Chocolate cookie brownie";
            case 82:
                return "Cheesecake (Vanila/Lemon)";
            case 83:
                return "Pie (Apple/Cherry)";
            case 84:
                return "Pancakes (2)";
            case 91:
                return "Tea cup pot";
            case 92:
                return "Coffee";
            case 93:
                return "Cappuccino";
            case 94:
                return "Hot Chocolate";
            case 95:
                return "Pop Fanta/Pepsi/Cola/Lemonade";
            case 96:
                return "Sparkling Water";
            default:
                return "Unknown";
        }
    }

}
