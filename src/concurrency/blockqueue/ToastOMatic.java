/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.blockqueue.ToastOMatic
 * @description:TODO
 * @date:2016-3-24 下午3:00:55
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
package concurrency.blockqueue;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

class Toast
{
	public enum Status
	{
		DRY, BUTTERED, JAMMED
	}

	private Status status = Status.DRY;
	private final int id;

	public Toast(int idn)
	{
		id = idn;
	}

	public void butter()
	{
		status = Status.BUTTERED;
	}

	public void jam()
	{
		status = Status.JAMMED;
	}

	public Status getStatus()
	{
		return status;
	}

	public int getId()
	{
		return id;
	}

	public String toString()
	{
		return "Toast " + id + ": " + status;
	}
}

@SuppressWarnings("serial")
class ToastQueue extends LinkedBlockingQueue<Toast>
{

}

class Toaster implements Runnable
{
	private ToastQueue toastQueue;
	private int count = 0;
	private Random rand = new Random(47);

	public Toaster(ToastQueue tq)
	{
		toastQueue = tq;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				TimeUnit.MILLISECONDS.sleep(100 + rand.nextInt(500));
				// Make toast
				Toast t = new Toast(count++);
				System.out.println(t);
				// Insert into queue
				toastQueue.put(t);
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("Toaster interrupted");
		}
		System.out.println("Toaster off");
	}
}

// Apply butter to toast:
class Butterer implements Runnable
{
	private ToastQueue dryQueue, butteredQueue;

	public Butterer(ToastQueue dry, ToastQueue buttered)
	{
		dryQueue = dry;
		butteredQueue = buttered;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				// Blocks until next piece of toast is available:
				Toast t = dryQueue.take();
				t.butter();
				System.out.println(t);
				butteredQueue.put(t);
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("Butterer interrupted");
		}
		System.out.println("Butterer off");
	}
}

// Apply jam to buttered toast:
class Jammer implements Runnable
{
	private ToastQueue butteredQueue, finishedQueue;

	public Jammer(ToastQueue buttered, ToastQueue finished)
	{
		butteredQueue = buttered;
		finishedQueue = finished;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				// Blocks until next piece of toast is available:
				Toast t = butteredQueue.take();
				t.jam();
				System.out.println(t);
				finishedQueue.put(t);
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("Jammer interrupted");
		}
		System.out.println("Jammer off");
	}
}

// Consume the toast:
class Eater implements Runnable
{
	private ToastQueue finishedQueue;
	private int counter = 0;

	public Eater(ToastQueue finished)
	{
		finishedQueue = finished;
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				// Blocks until next piece of toast is available:
				Toast t = finishedQueue.take();
				// Verify that the toast is coming in order.
				// and that all pieces are getting jammed:
				if (t.getId() != counter++ || t.getStatus() != Toast.Status.JAMMED)
				{
					System.out.println(">>>> Error: " + t);
					System.exit(1);
				}
				else
					System.out.println("Chomp! " + t);
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("Eater interrupted");
		}
		System.out.println("Eater off");
	}
}

public class ToastOMatic
{
	public static void main(String[] args) throws Exception
	{
		ToastQueue dryQueue = new ToastQueue(), butteredQueue = new ToastQueue(), finishedQueue = new ToastQueue();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Toaster(dryQueue));
		exec.execute(new Butterer(dryQueue, butteredQueue));
		exec.execute(new Jammer(butteredQueue, finishedQueue));
		exec.execute(new Eater(finishedQueue));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}

}
