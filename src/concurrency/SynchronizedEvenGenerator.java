/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.SynchronizedEvenGenerator
 * @description:TODO
 * @date:2016-3-21 下午3:53:07
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
//Simplifying mutexes with the synchronized keyword.
//{RunByHand}
public class SynchronizedEvenGenerator extends IntGenerator
{
	private int currentEvenValue = 0;
	@Override
	public synchronized int next()
	{
		++currentEvenValue;
		Thread.yield(); //Cause failure faster
		++currentEvenValue;
		return currentEvenValue;
	}
	public static void main(String[] args)
	{
		EvenChecker.test(new SynchronizedEvenGenerator());
	}
}
