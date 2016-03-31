/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.component.SemaphoreDemo
 * @description:TODO
 * @date:2016-3-30 下午1:13:52
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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

//A task to check a resource out of a pool:
class CheckoutTask<T> implements Runnable
{
	private static int counter = 0;
	private final int id = counter++;
	private Pool<T> pool;

	public CheckoutTask(Pool<T> pool)
	{
		this.pool = pool;
	}

	public void run()
	{
		try
		{
			T item = pool.checkOut();
			System.out.println(this + " checked out " + item);
			pool.checkIn(item);
		}
		catch (InterruptedException e)
		{
			// Acceptable way to terminate
		}
	}

	public String toString()
	{
		return "CheckoutTask " + id + " ";
	}
}

public class SemaphoreDemo
{
	final static int SIZE = 25;

	public static void main(String[] args) throws Exception
	{
		final Pool<Fat> pool = new Pool<Fat>(Fat.class, SIZE);
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < SIZE; i++)
			exec.execute(new CheckoutTask<Fat>(pool));
		System.out.println("All CheckoutTasks created");
		List<Fat> list = new ArrayList<Fat>();
		for (int i = 0; i < SIZE; i++)
		{
			Fat f = pool.checkOut();
			System.out.print(i + ": main() thread checked out ");
			f.operation();
			list.add(f);
		}
		Future<?> blocked = exec.submit(new Runnable()
		{
			@Override
			public void run()
			{
				try
				{
					// Semaphore prevents additional checkout,
					// so call it blocked:
					pool.checkOut();
				}
				catch (InterruptedException e)
				{
					System.out.println("checkOut() interrupted");
				}
			}
		});
		TimeUnit.SECONDS.sleep(2);
		blocked.cancel(true);// Break out of blocked call
		System.out.println("Checking in objects in " + list);
		for (Fat f : list)
			pool.checkIn(f);
		for (Fat f : list)
			pool.checkIn(f);
		exec.shutdown();
	}
}
