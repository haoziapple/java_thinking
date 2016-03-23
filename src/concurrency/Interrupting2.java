/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.Interrupting2
 * @description:TODO
 * @date:2016-3-23 下午2:22:40
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
package concurrency;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Interrupting a task blocked with a ReentrantLock.
class BlockedMutex
{
	private Lock lock = new ReentrantLock();
	public BlockedMutex()
	{
		//Acquire it right away, to demonstrate interruption
		//of a task blocked on a ReentrantLock:
		lock.lock();
	}
	public void f()
	{
		try
		{
			//This will never be available to a second task
			lock.lockInterruptibly(); //Special call
			System.out.println("lock acquired in f()");
		}
		catch(InterruptedException e)
		{
			System.out.println("Interrupted from lock acquisition in f()");
		}
	}
}
class Blocked2 implements Runnable
{
	BlockedMutex blocked = new BlockedMutex();
	@Override
	public void run()
	{
		System.out.println("Waiting for f() in BlockedMutex");
		blocked.f();
		System.out.println("Broken out of blocked call");
	}
}
public class Interrupting2
{
	public static void main(String[] args) throws Exception
	{
		Thread t = new Thread(new Blocked2());
		t.start();
		TimeUnit.SECONDS.sleep(1);
		System.out.println("Issuing t.interrupt()");
		t.interrupt();
	}
}
