/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.DaemonFromFactory
 * @description:TODO
 * @date:2016-3-19 下午1:29:11
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-19     WangHao       v1.0.0        create
 *
 *
 */
package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import util.DaemonThreadFactory;

//Using a Thread Factory to create daemons.
public class DaemonFromFactory implements Runnable
{
	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("Interrupted");
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i=0; i<10; i++)
			exec.execute(new DaemonFromFactory());
		System.out.println("All daemons started");
		TimeUnit.MILLISECONDS.sleep(500); //Run for a while
	}

}
