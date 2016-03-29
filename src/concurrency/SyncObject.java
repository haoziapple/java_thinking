/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.SyncObject
 * @description:TODO
 * @date:2016-3-22 下午4:30:56
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-22     WangHao       v1.0.0        create
 *
 *
 */
package concurrency;

//Synchronizing on another object.
class DualSynch
{
	private Object syncObject = new Object();
	public synchronized void f()
	{
		for(int i=0;i<5;i++)
		{
			System.out.println("f()");
			Thread.yield();
		}
	}
	public void g()
	{
		synchronized(syncObject)
		{
			for(int i=0;i<5;i++)
			{
				System.out.println("g()");
				Thread.yield();
			}
		}
	}
}

public class SyncObject
{
	public static void main(String[] args)
	{
		final DualSynch ds = new DualSynch();
		new Thread()
		{
			public void run()
			{
				ds.f();
			}
		}.start();
		ds.g();
	}
}
