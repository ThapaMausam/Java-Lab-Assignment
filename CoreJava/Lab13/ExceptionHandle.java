package CoreJava.Lab13;

import java.util.Scanner;
import java.util.InputMismatchException;

public class ExceptionHandle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter any two numbers: ");
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();

            int quotient = num1 / num2;

            System.out.println(num1 + " / " + num2 + " = " + quotient);
        } /*
           * catch (InputMismatchException | ArithmeticException e) {
           * //
           * System.out.println("\n--- Exception Caught (InputMismatch/Arithmetic) ---");
           * // System.out.println("Error details: " + e.getMessage());
           * }
           */
        catch (InputMismatchException e) {
            System.out.println("\n--- Exception Caught ---");
            System.out.println("Error details: " + e.getClass().getName());
        } catch (ArithmeticException e) {
            System.out.println("\n--- Exception Caught ---");
            System.out.println("Error details: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Finally block executed.");
        }
    }
}
