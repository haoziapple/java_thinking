/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.AttemptLocking
 * @description:TODO
 * @date:2016-3-21 下午5:36:00
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

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

//Locks in the concurrent library allow you to give up on trying to acquire a lock
public class AttemptLocking
{
	private ReentrantLock lock = new ReentrantLock();
	public void untimed()
	{
		boolean captured = lock.tryLock();
		try
		{
			System.out.println("tryLock(): " + captured);
		}
		finally
		{
			if(captured)
				lock.unlock();
		}
	}
	public void timed()
	{
		boolean captured = false;
		try
		{
			captured = lock.tryLock(2, TimeUnit.SECONDS);
		}
		catch(InterruptedException e)
		{
			throw new RuntimeException(e);
		}
		try
		{
			System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
		}
		finally
		{
			if(captured)
				lock.unlock();
		}
	}
	public static void main(String[] args)
	{
		final AttemptLocking al = new AttemptLocking();
		al.untimed(); //True -- lock is available
		al.timed(); //True -- lock is available
		// Now create a separate task to grab the lock:
		new Thread()
		{
			{
				setDaemon(true);
			}
			public void run()
			{
				al.lock.lock();
				System.out.println("acquired");
			}
		}.start();
		Thread.yield(); //Give the 2nd task a chance
		al.untimed(); //False -- lock grabbed by task
		al.timed(); //False -- lock grabbed by task
	}
}
