/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:typeinfo.SelectingMethods
 * @description:TODO
 * @date:2016-2-16 下午4:58:59
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

class MethodSelector implements InvocationHandler {
	private Object proxied;
	public MethodSelector(Object proxied) {
		this.proxied = proxied;
	}
	/* (non-Javadoc)
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		SweetShop.print(method.getName());
		if(method.getName().equals("interesting"))
			SweetShop.print("Proxy detected the interesting method");
		return method.invoke(proxied, args);
	}
	
}

interface SomeMethods {
	void boring1();
	void boring2();
	void interesting(String arg);
	void boring3();
}

class Implementation implements SomeMethods {
	public void boring1() {SweetShop.print("boring1");}
	public void boring2() {SweetShop.print("boring2");}
	public void interesting(String arg)
	{
		SweetShop.print("interesting " + arg);
	}
	public void boring3() {SweetShop.print("boring3");}
}
public class SelectingMethods
{
	public static void main(String[] args) {
		SomeMethods proxy = (SomeMethods)Proxy.newProxyInstance(
				SomeMethods.class.getClassLoader(),
				new Class[]{SomeMethods.class},
				new MethodSelector(new Implementation()));
		proxy.boring1();
		proxy.boring2();
		proxy.interesting("bobobo");
		proxy.boring3();
	}
}
