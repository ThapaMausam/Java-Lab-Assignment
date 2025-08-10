package AdvancedJava.Lab14;

import java.rmi.Naming; // binding remote object in RMI registry with a name
import java.rmi.registry.LocateRegistry;

public class CalculatorServer {
    public static void main(String args[]) {
        try {
            // Start RMI registry on port 1099
            LocateRegistry.createRegistry(1099);

            // Create remote object
            CalculatorImpl calc = new CalculatorImpl();

            // Bind remote object with a name in the registry
            Naming.rebind("rmi://localhost/CalculatorService", calc);

            System.out.println("Calculator Server is ready.");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.toString());
        }
    }
}
