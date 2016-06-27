/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.rmi.usezk.call.RmiClient
 * @description:TODO
 * @date:2016-6-27 下午5:03:38
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
package haozijava.rmi.usezk.call;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import haozijava.rmi.usezk.impl.IHelloService;

/**
 * @className:haozijava.rmi.usezk.call.RmiClient
 * @description:调用RMI服务
 * @version:v1.0.0
 * @date:2016-6-27 下午5:03:43
 * @author:WangHao
 */
public class RmiClient
{
	/**
	 * 调用RMI: 1.RMI请求路径 2.RMI接口
	 * @throws RemoteException 
	 * @throws NotBoundException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws RemoteException, MalformedURLException, NotBoundException
	{
		String url = "rmi://localhost:1099/haozijava.rmi.usezk.iserver.HelloServiceImpl";
		IHelloService helloService = (IHelloService) Naming.lookup(url);
		String result = helloService.sayHello("Jack");
		System.out.println(result);
	}
}
