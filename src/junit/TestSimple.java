/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:junit.TestSimple
 * @description:TODO
 * @date:2016-4-14 下午7:15:17
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

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestSimple extends TestCase
{
	public TestSimple(String name)
	{
		super(name);
	}

	public void testAdd()
	{
		assertEquals(2, 1 + 1);
	}

	public static Test suite()
	{
		TestSuite suite = new TestSuite();
		suite.addTest(new TestClassOne("testAddition"));
		suite.addTest(new TestClassOne("testSubstraction"));
		suite.addTestSuite(TestClassOne.class);

		TestSetup wrapper = new TestSetup(suite)
		{
			protected void setUp()
			{
				oneTimeSetUp();
			}

			protected void tearDown()
			{
				oneTimeTearDown();
			}
		};
		return wrapper;
	}

	// oneTimeSetUp方法，在整个suite之前执行
	public static void oneTimeSetUp()
	{
		System.out.println("oneTimeSetUp方法，在整个suite之前执行");
	}

	// oneTimeTearDown方法，在整个suite之后执行
	public static void oneTimeTearDown()
	{
		System.out.println("oneTimeTearDown方法，在整个suite之后执行");
	}
}
