/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.waxomatic.WaxOMatic
 * @description:TODO
 * @date:2016-3-23 下午3:28:30
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
package concurrency.waxomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Basic task cooperation.
class Car
{
	private boolean waxOn = false;

	public synchronized void waxed()
	{
		waxOn = true;// Ready to buff
		notifyAll();
	}

	public synchronized void buffed()
	{
		waxOn = false;// Ready for another coat of wax
		notifyAll();
	}

	public synchronized void waitForWaxing() throws InterruptedException
	{
		while (waxOn == false)
		{
			wait();
		}
	}

	public synchronized void waitForBuffing() throws InterruptedException
	{
		while (waxOn == true)
			wait();
	}
}
class WaxOn implements Runnable
{
	private Car car;
	public WaxOn(Car c)
	{
		car =c;
	}
	@Override
	public void run()
	{
		try
		{
			while(!Thread.interrupted())
			{
				System.out.print("Wax On! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax On tast");
	}
}
class WaxOff implements Runnable
{
	private Car car;
	public WaxOff(Car c)
	{
		car=c;
	}
	@Override
	public void run()
	{
		try
		{
			while(!Thread.interrupted())
			{
				car.waitForWaxing();
				System.out.print("Wax Off! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		}
		catch(InterruptedException e)
		{
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax Off task");
	}
}

public class WaxOMatic
{
	public static void main(String[] args) throws Exception
	{
		Car car = new Car();
		ExecutorService exec=Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(5);//Run for a while...
		exec.shutdownNow();//Interrupt all tasks
	}
}
