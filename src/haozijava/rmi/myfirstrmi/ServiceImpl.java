/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.rmi.myfirstrmi.ServiceImpl
 * @description:TODO
 * @date:2016-6-24 下午3:14:08
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-24     WangHao       v1.0.0        create
 *
 *
 */
package haozijava.rmi.myfirstrmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * @className:haozijava.rmi.myfirstrmi.ServiceImpl
 * @description:ServiceImpl实现类
 * @version:v1.0.0
 * @date:2016-6-24 下午3:14:25
 * @author:WangHao
 */
@SuppressWarnings("serial")
public class ServiceImpl extends UnicastRemoteObject implements IService
{
	@SuppressWarnings("unused")
	private String name;

	public ServiceImpl(String name) throws RemoteException
	{
		this.name = name;
	}

	@Override
	public String service(String content)
	{
		return "server >> " + content;
	}
}
