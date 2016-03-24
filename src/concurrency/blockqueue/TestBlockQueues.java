/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.blockqueue.TestBlockQueues
 * @description:TODO
 * @date:2016-3-24 下午1:39:25
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

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import concurrency.Liftoff;

//{RunByHand}
class LiftOffRunner implements Runnable
{
	private BlockingQueue<Liftoff> rockets;

	public LiftOffRunner(BlockingQueue<Liftoff> queue)
	{
		rockets = queue;
	}

	public void add(Liftoff lo)
	{
		try
		{
			rockets.put(lo);
		}
		catch (InterruptedException e)
		{
			System.out.println("Interrupted during put()");
		}
	}

	@Override
	public void run()
	{
		try
		{
			while (!Thread.interrupted())
			{
				Liftoff rocket = rockets.take();
				rocket.run();
			}
		}
		catch (InterruptedException e)
		{
			System.out.println("Waking form take()");
		}
		System.out.println("Exiting LiftOffRunner");
	}

}

public class TestBlockQueues
{
	static void getkey()
	{
		try
		{
			// Compensate for Windows/Linux difference in the
			// length of the result produced by the enter key:
			new BufferedReader(new InputStreamReader(System.in)).readLine();
		}
		catch (java.io.IOException e)
		{
			throw new RuntimeException(e);
		}
	}

	static void getkey(String message)
	{
		System.out.println(message);
		getkey();
	}

	static void test(String msg, BlockingQueue<Liftoff> queue)
	{
		System.out.println(msg);
		LiftOffRunner runner = new LiftOffRunner(queue);
		Thread t = new Thread(runner);
		t.start();
		for (int i = 0; i < 5; i++)
			runner.add(new Liftoff(5));
		getkey("Press 'Enter' (" + msg + ")");
		t.interrupt();
		System.out.println("Finished " + msg + " test");
	}
	public static void main(String[] args)
	{
		test("LinkedBlockingQueue", //Unlimited size
				new LinkedBlockingQueue<Liftoff>());
		test("ArrayBlockingQueue", //Fixed size
				new ArrayBlockingQueue<Liftoff>(3));
		test("SynchronousQueue", //Size of 1
				new SynchronousQueue<Liftoff>());
	}
}
