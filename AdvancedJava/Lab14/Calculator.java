package AdvancedJava.Lab14;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    public double sum(double a, double b) throws RemoteException;

    public double difference(double a, double b) throws RemoteException;
}
