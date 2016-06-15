/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:junit.TestClassOne
 * @description:TODO
 * @date:2016-4-14 下午7:19:28
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-14     WangHao       v1.0.0        create
 *
 *
 */
package junit;

import junit.framework.TestCase;

public class TestClassOne extends TestCase
{
	// setUp方法，在每个测试方法之前调用
	protected void setUp()
	{
		System.out.println("setUp方法，在每个测试方法之前调用");
	}

	// tearDown方法，在每个测试方法之后调用
	protected void tearDown()
	{
		System.out.println("tearDown方法，在每个测试方法之后调用");
	}

	public TestClassOne(String method)
	{
		super(method);
	}

	public void testAddition()
	{
		System.out.println("testAddition");
		assertEquals("testmessage", 4, 2 + 2);
	}

	public void testSubstraction()
	{
		System.out.println("testSubstraction");
		assertEquals(0, 2 - 2);
	}

	public void testAbort()
	{
		System.out.println("testAbort");
	}

	public void testEuqalObject()
	{
		TestJavaBean bean1 = new TestJavaBean();
		bean1.setTest1("1");
		TestJavaBean bean2 = new TestJavaBean();
		bean2.setTest1("1");
		assertEquals(bean1, bean2);
	}
}
