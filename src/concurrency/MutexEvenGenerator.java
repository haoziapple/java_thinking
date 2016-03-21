/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.MutexEvenGenerator
 * @description:TODO
 * @date:2016-3-21 下午5:28:56
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

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//Preventing thread collisions with mutexes.
//{RunByHand}
public class MutexEvenGenerator extends IntGenerator
{
	private int currentEvenValue = 0;
	private Lock lock = new ReentrantLock();
	public int next()
	{
		try
		{
			++currentEvenValue;
			Thread.yield(); //Cause failure faster
			++currentEvenValue;
			return currentEvenValue;
		}
		finally
		{
			lock.unlock();
		}
	}
	public static void main(String[] args)
	{
		EvenChecker.test(new MutexEvenGenerator());
	}
}
