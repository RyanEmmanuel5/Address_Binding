import java.util.Scanner;

public class Compiled_Time_Binding {

    // Overloaded method for adding two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method for adding three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Compiled_Time_Binding example = new Compiled_Time_Binding();

        // Get user input for adding two integers
        System.out.print("Enter the first integer: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter the second integer: ");
        int num2 = scanner.nextInt();

        // Get user input for the third integer
        System.out.print("Enter the third integer (or press 0 if you only want to add two integers): ");
        int num3 = scanner.nextInt();

        if (num3 == 0) {
            // Call the method for adding two integers
            int result = example.add(num1, num2);
            System.out.println("Sum of two integers: " + result);
        } else {
            // Call the method for adding three integers
            int result = example.add(num1, num2, num3);
            System.out.println("Sum of three integers: " + result);
        }

        scanner.close(); // Close the scanner to avoid resource leaks
    }
}
