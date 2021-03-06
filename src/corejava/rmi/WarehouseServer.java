package corejava.rmi;

import java.rmi.RemoteException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * This program instantiates a remote warehouse object,
 * registers it with the naming service, and waits for clients to invoke methods.
 */
public class WarehouseServer
{
	public static void main(String[] args)throws RemoteException, NamingException
	{
		System.out.println("Constructing server implementation...");
		WarehouseImpl centralWarehouse=new WarehouseImpl();
		
		System.out.println("Binding server implementation to registry...");
		Context namingContext=new InitialContext();
		namingContext.bind("rmi:central_warehouse", centralWarehouse);
		
		System.out.println("Waiting for invocations from clients...");
	}
}
