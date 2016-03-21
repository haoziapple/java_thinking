/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.Joining
 * @description:TODO
 * @date:2016-3-21 下午1:12:55
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-21     WangHao       v1.0.0        create
 *
 *
 */
package concurrency;
//Understanding join().

class Sleeper extends Thread
{
	private int duration;
	public Sleeper(String name, int sleepTime)
	{
		super(name);
		duration = sleepTime;
		start();
	}
	public void run()
	{
		try
		{
			sleep(duration);
		}
		catch(InterruptedException e)
		{
			System.out.println(getName() + " was interrupted. " + "isInterrupted(): " + isInterrupted());
			return;
		}
		System.out.println(getName() + " has awakened");
	}
}

class Joiner extends Thread
{
	private Sleeper sleeper;
	public Joiner(String name, Sleeper sleeper)
	{
		super(name);
		this.sleeper = sleeper;
		start();
	}
	public void run()
	{
		try
		{
			sleeper.join();
		}
		catch(InterruptedException e)
		{
			System.out.println("Interrupted");
		}
		System.out.println(getName() + " join completed");
	}
}

public class Joining
{
	public static void main(String[] args)
	{
		Sleeper
			sleepy = new Sleeper("Sleepy", 1500),
			grumpy = new Sleeper("Grumpy", 1500);
		Joiner
			dopey = new Joiner("Dopey", sleepy),
			doc = new Joiner("Doc", grumpy);
		grumpy.interrupt();
	}

}
