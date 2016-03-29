/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.deadlock.DeadlockingDiningPhilosophers
 * @description:TODO
 * @date:2016-3-25 下午1:37:06
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-25     WangHao       v1.0.0        create
 *
 *
 */
package concurrency.deadlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//Demonstrates how deadlock can be hidden in a program.
//{Args: 0 5 timeout}
/**
 * 当以下四个条件同时满足时，就会发生死锁：
 * 1.互斥条件。任务使用的资源中至少有一个是不能共享的。
 * 这里，一根Chopstick一次就只能被一个Philosopher使用。
 * 2.至少有一个任务它必须持有一个资源且正在等待获取一个当前被别的任务持有的资源。
 * 也就是说，要发生死锁，Philosophy必须拿着一根Chopstick并且等待另一根。
 * 3.资源不能被任务抢占，任务必须把资源释放当做普通事件。
 * Philosophy很有礼貌，他们不会从其他Philosophy那里抢Chopstick
 * 4.必须有循环等待，这时，一个任务等待其他任务所持有的资源，后者又在等待另一个
 * 任务所持有的资源，这样一直下去，直到有一个任务在等待第一个任务所持有的资源，
 * 使得大家都被锁住。
 * 
 */
public class DeadlockingDiningPhilosophers
{
	public static void main(String[] args) throws Exception
	{
		int ponder = 5;
		if (args.length > 0)
			ponder = Integer.parseInt(args[0]);
		int size = 5;
		if (args.length > 1)
			size = Integer.parseInt(args[1]);
		ExecutorService exec = Executors.newCachedThreadPool();
		Chopstick[] sticks = new Chopstick[size];
		for (int i = 0; i < size; i++)
			sticks[i] = new Chopstick();
		for (int i = 0; i < size; i++)
			exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size], i, ponder));
		if (args.length == 3 && args[2].equals("timeout"))
			TimeUnit.SECONDS.sleep(5);
		else
		{
			System.out.println("Press 'Enter' to quit");
			System.in.read();
		}
		exec.shutdownNow();
	}
}
