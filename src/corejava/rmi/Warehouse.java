package corejava.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * The remote interface for a simple warehouse.
 */
public interface Warehouse extends Remote
{
	double getPrice(String description) throws RemoteException;
}
