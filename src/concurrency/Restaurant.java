/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.Restaurant
 * @description:TODO
 * @date:2016-3-24 上午11:05:16
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-24     WangHao       v1.0.0        create
 *
 *
 */
package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//The producer-consumer approach to task cooperation
class Meal
{
	private final int orderNum;

	public Meal(int orderNum)
	{
		this.orderNum = orderNum;
	}

	public String toString()
	{
		return "Meal " + orderNum;
	}
}

class WaitPerson implements Runnable
{
	private Restaurant restaurant;

	public WaitPerson(Restaurant r)
	{
		restaurant = r;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				synchronized (this)
				{
					while (restaurant.meal == null)
						wait(); // for the chef to produce a meal
				}
				System.out.println("Waitperson got " + restaurant.meal);
				synchronized (restaurant.chef)
				{
					restaurant.meal = null;
					restaurant.chef.notifyAll();// Ready for another
				}
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("WaitPerson interrupted");
		}
	}

}

class Chef implements Runnable
{
	private Restaurant restaurant;
	private int count = 0;

	public Chef(Restaurant r)
	{
		restaurant = r;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				synchronized (this)
				{
					while (restaurant.meal != null)
						wait();// ..for the meal to be taken
				}
				if (++count == 10)
				{
					System.out.println("Out of food, closing");
					restaurant.exec.shutdownNow();
				}
				System.out.print("Order up! ");
				synchronized (restaurant.waitPerson)
				{
					restaurant.meal = new Meal(count);
					restaurant.waitPerson.notifyAll();
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("Chef interrupted");
		}
	}

}

public class Restaurant
{
	Meal meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);

	public Restaurant()
	{
		exec.execute(chef);
		exec.execute(waitPerson);
	}

	public static void main(String[] args)
	{
		new Restaurant();
	}
}
