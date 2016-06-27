/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.rmi.usezk.iserver.HelloServiceImpl
 * @description:TODO
 * @date:2016-6-27 下午4:53:39
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
package haozijava.rmi.usezk.iserver;

import haozijava.rmi.usezk.impl.IHelloService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @className:haozijava.rmi.usezk.iserver.HelloServiceImpl
 * @description:RMI接口的实现类
 * @version:v1.0.0
 * @date:2016-6-27 下午4:53:43
 * @author:WangHao
 */
@SuppressWarnings("serial")
public class HelloServiceImpl extends UnicastRemoteObject implements IHelloService
{

	/**
	 * 必须提供一个构造器，并且必须排除RemoteException
	 * 
	 * @throws RemoteException
	 */
	public HelloServiceImpl() throws RemoteException
	{
		super();
	}

	/**
	 * 方法实现
	 */
	@Override
	public String sayHello(String name) throws RemoteException
	{
		return String.format("Hello %s", name);
	}

}
