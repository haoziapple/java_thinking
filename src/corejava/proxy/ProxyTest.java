/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.proxy.ProxyTest
 * @description:TODO
 * @date:2016-4-5 下午5:12:18
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-5     WangHao       v1.0.0        create
 *
 *
 */
package corejava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * @className:corejava.proxy.ProxyTest
 * @description:This program demonstrates the use of proxies
 * @version:v1.0.0
 * @date:2016-4-5 下午5:12:27
 * @author:WangHao
 */
public class ProxyTest
{
	public static void main(String[] args)
	{
		Object[] elements = new Object[1000];

		// fill elements with proxies for integers 1...1000
		for (int i = 0; i < elements.length; i++)
		{
			Integer value = i + 1;
			InvocationHandler handler = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[]
			{ Comparable.class }, handler);
			elements[i] = proxy;
		}

		// construct a random integer
		Integer key = new Random().nextInt(elements.length) + 1;

		// search for the key
		int result = Arrays.binarySearch(elements, key);

		// print match if found
		if (result >= 0)
			System.out.println(elements[result]);
	}
}

/**
 * @className:corejava.proxy.TraceHandler
 * @description:An invocation handler that prints out the method name and
 *                 parameters, then invokes the original method
 * @version:v1.0.0
 * @date:2016-4-5 下午5:15:45
 * @author:WangHao
 */
class TraceHandler implements InvocationHandler
{
	private Object target;

	public TraceHandler(Object t)
	{
		target = t;
	}

	@Override
	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable
	{
		// print implicit argument
		System.out.print(target);

		// print method name
		System.out.print("." + m.getName() + "(");

		// print explicit arguments
		if (args != null)
		{
			for (int i = 0; i < args.length; i++)
			{
				System.out.print(args[i]);
				if (i < args.length - 1)
					System.out.print(", ");
			}
		}
		System.out.println(")");

		// invoke actual method
		return m.invoke(target, args);
	}
}
