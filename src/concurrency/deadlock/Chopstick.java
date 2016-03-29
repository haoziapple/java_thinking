/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.deadlock.Chopstick
 * @description:TODO
 * @date:2016-3-24 下午5:21:18
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
package concurrency.deadlock;

//Chopsticks for dining philosophers.
public class Chopstick
{
	private boolean taken = false;

	public synchronized void take() throws InterruptedException
	{
		while (taken)
			wait();
		taken = true;
	}

	public synchronized void drop()
	{
		taken = false;
		notifyAll();
	}
}
