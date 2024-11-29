import java.util.Scanner;

// Abstract class representing a generic coffee type
abstract class Coffee {
    // Abstract method to be overridden by subclasses to provide the price based on size
    public abstract double getPrice(String size);

    // Method to be overridden by subclasses for preparation instructions
    public void prepare() {
        System.out.println("Preparing your coffee...");
    }
}

// Subclass representing Americano coffee type
class Americano extends Coffee {
    @Override
    public double getPrice(String size) {
        // Return the price based on the selected size
        switch (size.toLowerCase()) {
            case "small": return 125.00;
            case "medium": return 150.00;
            case "large": return 175.00;
            default: throw new IllegalArgumentException("Invalid size");
        }
    }

    @Override
    public void prepare() {
        System.out.println("Preparing an Americano.");
    }
}

// Subclass representing Cappuccino coffee type
class Cappuccino extends Coffee {
    @Override
    public double getPrice(String size) {
        switch (size.toLowerCase()) {
            case "small": return 175.00;
            case "medium": return 200.00;
            case "large": return 225.00;
            default: throw new IllegalArgumentException("Invalid size");
        }
    }

    @Override
    public void prepare() {
        System.out.println("Preparing a Cappuccino.");
    }
}

// Subclass representing Matcha coffee type
class Matcha extends Coffee {
    @Override
    public double getPrice(String size) {
        switch (size.toLowerCase()) {
            case "small": return 200.00;
            case "medium": return 225.00;
            case "large": return 250.00;
            default: throw new IllegalArgumentException("Invalid size");
        }
    }

    @Override
    public void prepare() {
        System.out.println("Preparing a Matcha.");
    }
}

// Subclass representing Caramel coffee type
class Caramel extends Coffee {
    @Override
    public double getPrice(String size) {
        switch (size.toLowerCase()) {
            case "small": return 225.00;
            case "medium": return 250.00;
            case "large": return 275.00;
            default: throw new IllegalArgumentException("Invalid size");
        }
    }

    @Override
    public void prepare() {
        System.out.println("Preparing a Caramel.");
    }
}

// Subclass representing Chocochip coffee type
class Chocochip extends Coffee {
    @Override
    public double getPrice(String size) {
        switch (size.toLowerCase()) {
            case "small": return 250.00;
            case "medium": return 275.00;
            case "large": return 300.00;
            default: throw new IllegalArgumentException("Invalid size");
        }
    }

    @Override
    public void prepare() {
        System.out.println("Preparing a Chocochip.");
    }
}

public class Run_Time_Binding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Display the menu sorted by price from lowest to highest
        System.out.println("Welcome to the Coffee Shop!");
        System.out.println("Menu:");
        System.out.println("1. Americano - Small (PHP 125.00), Medium (PHP 150.00), Large (PHP 175.00)");
        System.out.println("2. Cappuccino - Small (PHP 175.00), Medium (PHP 200.00), Large (PHP 225.00)");
        System.out.println("3. Matcha - Small (PHP 200.00), Medium (PHP 225.00), Large (PHP 250.00)");
        System.out.println("4. Caramel - Small (PHP 225.00), Medium (PHP 250.00), Large (PHP 275.00)");
        System.out.println("5. Chocochip - Small (PHP 250.00), Medium (PHP 275.00), Large (PHP 300.00)");
        
        // Prompt the user to select a drink
        System.out.print("Select a drink (1-5): ");
        int drinkChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left over from nextInt()

        Coffee selectedDrink = null; // Variable to hold the selected drink instance

        // Create an instance of the selected drink based on user input
        switch (drinkChoice) {
            case 1:
                selectedDrink = new Americano();
                break;
            case 2:
                selectedDrink = new Cappuccino();
                break;
            case 3:
                selectedDrink = new Matcha();
                break;
            case 4:
                selectedDrink = new Caramel();
                break;
            case 5:
                selectedDrink = new Chocochip();
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                return; // Exit the program if the input is invalid
        }

        // Ask for the size of the coffee
        System.out.println("Available sizes:");
        System.out.println("1. Small");
        System.out.println("2. Medium");
        System.out.println("3. Large");
        System.out.print("Select the size (1-3): ");
        
        // Get the size choice from the user and map it to a string
        int sizeChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left over from nextInt()

        String size = (sizeChoice == 1) ? "small" : (sizeChoice == 2) ? "medium" : "large";

        // Ask for the quantity of drinks the user wants
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume the newline left over from nextInt()

        // Ask if the order is "to go" or "for here"
        System.out.print("Is this order to go or for here? (Enter 'to go' or 'for here'): ");
        String orderType = scanner.nextLine().trim();

        // Calculate the total price based on the price per item and quantity
        double pricePerItem = selectedDrink.getPrice(size);
        double totalAmount = pricePerItem * quantity;

        // Print the receipt with all order details
        System.out.println("\n--- Receipt ---");
        selectedDrink.prepare(); // Call the overridden prepare method to show how the coffee is prepared
        System.out.println("Drink: " + selectedDrink.getClass().getSimpleName()); // Print the drink type
        System.out.println("Size: " + size);
        System.out.println("Quantity: " + quantity);
        System.out.println("Order Type: " + orderType);
        System.out.println("Price per item: PHP " + String.format("%.2f", pricePerItem));
        System.out.println("Total amount: PHP " + String.format("%.2f", totalAmount));
        System.out.println("---------------");

        System.out.println("Thank you for your order!");

        // Close the scanner to avoid resource leaks
        scanner.close();
    }
}
