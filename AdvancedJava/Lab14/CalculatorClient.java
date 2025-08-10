package AdvancedJava.Lab14;

import java.rmi.Naming;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            // Lookup remote object from registry
            // Returns stub object that implement Calculator interface
            Calculator calc = (Calculator) Naming.lookup("rmi://localhost/CalculatorService");

            System.out.println("Sum: " + calc.sum(15, 7));
            System.out.println("Difference: " + calc.difference(15, 7));
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
        }
    }
}
