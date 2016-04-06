/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.OrnamentalGarden
 * @description:TODO
 * @date:2016-3-22 下午4:57:34
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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Count
{
	private int count = 0;
	private Random rand = new Random(47);

	// Remove the synchronized keyword to see counting fail:
	public synchronized int increment()
	{
		int temp = count;
		if (rand.nextBoolean())// Yield half the time
			Thread.yield();
		return (count = ++temp);
	}

	public synchronized int value()
	{
		return count;
	}
}

class Entrance implements Runnable
{
	private static Count count = new Count();
	private static List<Entrance> entrances = new ArrayList<Entrance>();
	private int number = 0;

	// Doesn't need synchronization to read:
	private final int id;
	private static volatile boolean canceled = false;

	// Atomic operation on a volatile field:
	public static void cancel()
	{
		canceled = true;
	}

	public Entrance(int id)
	{
		this.id = id;
		// Keep this task in a list.Also prevents garbage collection of dead
		// tasks:
		entrances.add(this);
	}

	@Override
	public void run()
	{
		while (!canceled)
		{
			synchronized (this)
			{
				++number;
			}
			System.out.println(this + " Total: " + count.increment());
			try
			{
				TimeUnit.MILLISECONDS.sleep(100);
			}
			catch (InterruptedException e)
			{
				System.out.println("sleep interrupted");
			}
		}
		System.out.println("Stopping " + this);
	}

	public synchronized int getValue()
	{
		return number;
	}

	public static int getTotalCount()
	{
		return count.value();
	}

	public static int sumEntrances()
	{
		int sum = 0;
		for (Entrance entrance : entrances)
			sum += entrance.getValue();
		return sum;
	}
}

public class OrnamentalGarden
{
	public static void main(String[] args) throws Exception
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		for (int i = 0; i < 5; i++)
			exec.execute(new Entrance(i));
		// Run for a while, then stop and collect the data:
		TimeUnit.SECONDS.sleep(3);
		Entrance.cancel();
		exec.shutdown();
		if (!exec.awaitTermination(250, TimeUnit.MILLISECONDS))
			System.out.println("Some tasks were not terminated!");
		System.out.println("Total: " + Entrance.getTotalCount());
		System.out.println("Sum of Entrances: " + Entrance.sumEntrances());
	}
}