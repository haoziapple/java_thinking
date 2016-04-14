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

import junit.framework.TestCase;

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
}
