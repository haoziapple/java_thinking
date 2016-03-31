/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.component.Fat
 * @description:TODO
 * @date:2016-3-30 下午1:07:10
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-30     WangHao       v1.0.0        create
 *
 *
 */
package concurrency.component;

//Objects that are expensive to create.
public class Fat
{
	private volatile double d;// Prevent optimization
	private static int counter = 0;
	private final int id = counter++;

	public Fat()
	{
		// Expensive, interruptible operation:
		for (int i = 1; i < 10000; i++)
		{
			d += (Math.PI + Math.E) / (double) i;
		}
	}

	public void operation()
	{
		System.out.println(this);
	}

	public String toString()
	{
		return "Fat id: " + id;
	}
}
