/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.SimpleDaemons
 * @description:TODO
 * @date:2016-3-19 下午12:00:45
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

import java.util.concurrent.TimeUnit;

//Daemon threads don't pervent the program from ending.
public class SimpleDaemons implements Runnable
{

	@Override
	public void run()
	{
		try
		{
			while(true)
			{
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println(Thread.currentThread() + " " + this);
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("sleep() interrupted");
		}
	}
	public static void main(String[] args) throws Exception
	{
		for(int i=0; i<10; i++)
		{
			Thread daemon = new Thread(new SimpleDaemons());
			daemon.setDaemon(true);//Must call before start()
			daemon.start();
		}
		System.out.println("All daemons started");
		TimeUnit.MILLISECONDS.sleep(100);
	}
}
