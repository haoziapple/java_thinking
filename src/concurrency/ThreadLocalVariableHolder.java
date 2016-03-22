/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.ThreadLocalVariableHolder
 * @description:TODO
 * @date:2016-3-22 下午4:43:04
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

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Automatically giving each thread its own storage.
class Accessor implements Runnable
{
	private final int id;

	public Accessor(int idn)
	{
		id = idn;
	}

	@Override
	public void run()
	{
		while (!Thread.currentThread().isInterrupted())
		{
			ThreadLocalVariableHolder.increment();
			System.out.println(this);
			Thread.yield();
		}
	}

	public String toString()
	{
		return "#" + id + ": " + ThreadLocalVariableHolder.get();
	}
}

public class ThreadLocalVariableHolder
{
	private static ThreadLocal<Integer> value = new ThreadLocal<Integer>()
	{
		private Random rand = new Random(47);

		protected synchronized Integer initialValue()
		{
			return rand.nextInt(10000);
		}
	};

	public static void increment()
	{
		value.set(value.get() + 1);
	}

	public static int get()
	{
		return value.get();
	}

	public static void main(String[] args) throws Exception
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			exec.execute(new Accessor(i));
		TimeUnit.SECONDS.sleep(1); // Run for a while
		exec.shutdownNow(); // All Accessors will quit
	}
}
