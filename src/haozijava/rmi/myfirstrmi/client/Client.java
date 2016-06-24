/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.rmi.myfirstrmi.client.Client
 * @description:TODO
 * @date:2016-6-24 下午3:18:48
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
package haozijava.rmi.myfirstrmi.client;

import haozijava.rmi.myfirstrmi.IService;

import java.rmi.Naming;

/**
 * @className:haozijava.rmi.myfirstrmi.client.Client
 * @description:rmi客户端程序
 * @version:v1.0.0
 * @date:2016-6-24 下午3:19:37
 * @author:WangHao
 */
public class Client
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
	{
		String url = "rmi://localhost:8888/";
		try
		{
			// 在RMI服务注册表中查找名称为service02的对象，并调用其上的方法
			IService service02 = (IService) Naming.lookup(url + "service02");

			Class stubClass = service02.getClass();
			System.out.println(service02 + " 是 " + stubClass.getName() + " 的实例！");
			// 获得本底存根已实现的接口类型
			Class[] interfaces = stubClass.getInterfaces();
			for (Class c : interfaces)
			{
				System.out.println("存根类实现了 " + c.getName() + " 接口！");
			}
			System.out.println(service02.service("你好！"));
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
