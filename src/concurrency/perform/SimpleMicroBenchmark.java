/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.perform.SimpleMicroBenchmark
 * @description:TODO
 * @date:2016-4-1 下午1:59:38
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-1     WangHao       v1.0.0        create
 *
 *
 */
package concurrency.perform;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//The dangers of microbenchmarking
abstract class Incrementable
{
	protected long counter = 0;

	public abstract void increment();
}

class SynchronizingTest extends Incrementable
{
	@Override
	public synchronized void increment()
	{
		++counter;
	}
}

class LockingTest extends Incrementable
{
	private Lock lock = new ReentrantLock();

	public void increment()
	{
		lock.lock();
		try
		{
			++counter;
		}
		finally
		{
			lock.unlock();
		}
	}
}

public class SimpleMicroBenchmark
{
	static long test(Incrementable incr)
	{
		long start = System.nanoTime();
		for (long i = 0; i < 10000000L; i++)
			incr.increment();
		return System.nanoTime() - start;
	}

	public static void main(String[] args)
	{
		long synchTime = test(new SynchronizingTest());
		long lockTime = test(new LockingTest());
		System.out.printf("synchronized: %1$10d\n", synchTime);
		System.out.printf("Lock:         %1$10d\n", lockTime);
		System.out.printf("Lock/synchronized = %1$.3f", (double) lockTime / (double) synchTime);
	}
}
