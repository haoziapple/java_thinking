/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.MultiLock
 * @description:TODO
 * @date:2016-3-23 下午1:56:21
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-23     WangHao       v1.0.0        create
 *
 *
 */
package concurrency;

//One thread can reacquire the same lock
public class MultiLock
{
	public synchronized void f1(int count)
	{
		if (count-- > 0)
		{
			System.out.println("f1() calling f2 with count " + count);
			f2(count);
		}
	}

	public synchronized void f2(int count)
	{
		if (count-- > 0)
		{
			System.out.println("f2() calling f1 with count " + count);
			f1(count);
		}
	}
	public static void main(String[] args) throws Exception
	{
		final MultiLock multiLock = new MultiLock();
		new Thread()
		{
			public void run()
			{
				multiLock.f1(10);
			}
		}.start();
	}
}
