package CoreJava.Lab1;

import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        double number1, number2;

        System.out.print("Enter the first number : ");
        number1 = sc.nextDouble();

        System.out.print("Enter the second number : ");
        number2 = sc.nextDouble();

        double sum = number1 + number2;

        double product = number1 * number2;

        double quotient, remainder;
        if (number2 != 0) {
            quotient = number1 / number2;
            remainder = number1 % number2;
        } else {
            quotient = Double.NaN;
            remainder = Double.NaN;
            System.out.println("Cannot be divisible by zero.");
        }

        double average = sum / 2;

        System.out.println("\nResults:");
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
        System.out.println("Average: " + average);

        sc.close();
    }
}