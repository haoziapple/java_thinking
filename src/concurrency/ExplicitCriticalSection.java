/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.ExplictCriticalSection
 * @description:TODO
 * @date:2016-3-22 下午4:16:38
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

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Using explicit Lock objects to create critical sections.

//Synchronize the entire method:
class ExplicitPairManager1 extends PairManager
{
	private Lock lock = new ReentrantLock();

	@Override
	public synchronized void increment()
	{
		lock.lock();
		try
		{
			p.incrementX();
			p.incrementY();
			store(getPair());
		}
		finally
		{
			lock.unlock();
		}
	}
}

//Use a critical section
class ExplicitPairManager2 extends PairManager
{
	private Lock lock = new ReentrantLock();
	@Override
	public void increment()
	{
		Pair temp;
		lock.lock();
		try
		{
			p.incrementX();
			p.incrementY();
			temp = getPair();
		}
		finally
		{
			lock.unlock();
		}
		store(temp);
	}
	
}
public class ExplicitCriticalSection
{
	public static void main(String[] args) throws Exception
	{
		PairManager
			pman1 = new ExplicitPairManager1(),
			pman2 = new ExplicitPairManager2();
		CriticalSection.testApproaches(pman1, pman2);
	}
}
