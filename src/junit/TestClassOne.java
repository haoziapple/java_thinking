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
	public TestClassOne(String method)
	{
		super(method);
	}

	public void testAddition()
	{
		assertEquals(4, 2 + 2);
	}

	public void testSubstraction()
	{
		assertEquals(0, 2 - 2);
	}
}
