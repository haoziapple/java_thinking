/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.Daemons
 * @description:TODO
 * @date:2016-3-19 下午3:10:13
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

//Daemon threads spawn other daemon threads.
class Daemon implements Runnable
{
	private Thread[] t = new Thread[10];
	public void run()
	{
		for(int i=0; i<t.length; i++)
		{
			t[i] = new Thread(new DaemonSpawn());
			t[i].start();
			System.out.println("DaemonSpawn " + i + " started.");
		}
		for(int i=0; i<t.length; i++)
		{
			System.out.println("t[" + i + "].isDaemon() = " + t[i].isDaemon() + ", ");
		}
		while(true)
			Thread.yield();
	}
}

class DaemonSpawn implements Runnable
{
	public void run()
	{
		while(true)
			Thread.yield();
	}
}

public class Daemons
{
	public static void main(String[] args) throws Exception
	{
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		System.out.println("d.isDaemon() = " + d.isDaemon() + ", ");
		//Allow the daemon threads to
		//finish their startup processes:
		TimeUnit.SECONDS.sleep(1);
	}
}
