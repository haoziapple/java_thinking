/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:typeinfo.SimpleDynamicProxy
 * @description:TODO
 * @date:2016-2-16 下午1:31:32
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-16     WangHao       v1.0.0        create
 *
 *
 */
package typeinfo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;
	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		System.out.println("**** proxy: " + proxy.getClass() +
				", method: " + method + ",args: " + args);
		if(args != null)
			for(Object arg : args)
				System.out.println("test " + arg);
		// TODO Auto-generated method stub
		return method.invoke(proxied, args);
//					return null;
	}
	
}
public class SimpleDynamicProxy
{
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("bobobo");
	}
	public static void main(String[] args) {
		RealObject real = new RealObject();
		consumer(real);
		//Insert a proxy and call again
		Interface proxy = (Interface)Proxy.newProxyInstance(Interface.class.getClassLoader(),
				new Class[]{Interface.class}, new DynamicProxyHandler(real));
		consumer(proxy);
	}
}
