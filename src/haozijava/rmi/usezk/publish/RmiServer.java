/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.rmi.usezk.publish.RmiServer
 * @description:TODO
 * @date:2016-6-27 下午4:58:12
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-27     WangHao       v1.0.0        create
 *
 *
 */
package haozijava.rmi.usezk.publish;

import haozijava.rmi.usezk.iserver.HelloServiceImpl;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * @className:haozijava.rmi.usezk.publish.RmiServer
 * @description:通过main方法的JNDI发布RMI服务
 * @version:v1.0.0
 * @date:2016-6-27 下午4:58:19
 * @author:WangHao
 */
public class RmiServer
{
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException
	{
		int port = 1099;
		String url = "rmi://localhost:1099/haozijava.rmi.usezk.iserver.HelloServiceImpl";
		LocateRegistry.createRegistry(port);
		Naming.bind(url, new HelloServiceImpl());
	}
}
