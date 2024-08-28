import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Enhanced Console-Based Calculator");
            System.out.println("1. Basic Arithmetic");
            System.out.println("2. Scientific Calculations");
            System.out.println("3. Unit Conversions");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        performBasicArithmetic(scanner);
                        break;
                    case 2:
                        performScientificCalculations(scanner);
                        break;
                    case 3:
                        performUnitConversions(scanner);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
                choice = -1; // Set choice to an invalid number to repeat the loop
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void performBasicArithmetic(Scanner scanner) {
        System.out.println("Basic Arithmetic Operations");
        System.out.println("1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.print("Choose operation: ");

        int operation = scanner.nextInt();
        double num1, num2;

        System.out.print("Enter first number: ");
        num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        num2 = scanner.nextDouble();

        switch (operation) {
            case 1:
                System.out.println("Result: " + (num1 + num2));
                break;
            case 2:
                System.out.println("Result: " + (num1 - num2));
                break;
            case 3:
                System.out.println("Result: " + (num1 * num2));
                break;
            case 4:
                if (num2 != 0) {
                    System.out.println("Result: " + (num1 / num2));
                } else {
                    System.out.println("Error: Division by zero.");
                }
                break;
            default:
                System.out.println("Invalid operation.");
        }
    }

    private static void performScientificCalculations(Scanner scanner) {
        System.out.println("Scientific Calculations");
        System.out.println("1. Square Root");
        System.out.println("2. Exponentiation");
        System.out.print("Choose operation: ");

        int operation = scanner.nextInt();
        double num, exponent;

        switch (operation) {
            case 1:
                System.out.print("Enter number: ");
                num = scanner.nextDouble();
                if (num >= 0) {
                    System.out.println("Result: " + Math.sqrt(num));
                } else {
                    System.out.println("Error: Negative number.");
                }
                break;
            case 2:
                System.out.print("Enter base number: ");
                num = scanner.nextDouble();
                System.out.print("Enter exponent: ");
                exponent = scanner.nextDouble();
                System.out.println("Result: " + Math.pow(num, exponent));
                break;
            default:
                System.out.println("Invalid operation.");
        }
    }

    private static void performUnitConversions(Scanner scanner) {
        System.out.println("Unit Conversions");
        System.out.println("1. Temperature (Celsius to Fahrenheit)");
        System.out.println("2. Temperature (Fahrenheit to Celsius)");
        System.out.println("3. Currency (USD to EUR)");
        System.out.println("4. Currency (EUR to USD)");
        System.out.print("Choose conversion: ");

        int conversionType = scanner.nextInt();
        double value;

        switch (conversionType) {
            case 1:
                System.out.print("Enter temperature in Celsius: ");
                value = scanner.nextDouble();
                System.out.println("Result: " + (value * 9/5 + 32) + " °F");
                break;
            case 2:
                System.out.print("Enter temperature in Fahrenheit: ");
                value = scanner.nextDouble();
                System.out.println("Result: " + ((value - 32) * 5/9) + " °C");
                break;
            case 3:
                System.out.print("Enter amount in USD: ");
                value = scanner.nextDouble();
                // Assuming 1 USD = 0.85 EUR (exchange rate can be updated)
                System.out.println("Result: " + (value * 0.85) + " EUR");
                break;
            case 4:
                System.out.print("Enter amount in EUR: ");
                value = scanner.nextDouble();
                // Assuming 1 EUR = 1.18 USD (exchange rate can be updated)
                System.out.println("Result: " + (value * 1.18) + " USD");
                break;
            default:
                System.out.println("Invalid conversion type.");
        }
    }
}
