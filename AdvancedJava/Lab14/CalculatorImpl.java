package AdvancedJava.Lab14;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class CalculatorImpl extends UnicastRemoteObject implements Calculator { // enable remote access
    protected CalculatorImpl() throws RemoteException {
        super();
    }

    @Override
    public double sum(double a, double b) throws RemoteException {
        return a + b;
    }

    @Override
    public double difference(double a, double b) throws RemoteException {
        return a - b;
    }
}
