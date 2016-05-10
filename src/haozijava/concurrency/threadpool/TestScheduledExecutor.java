/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.concurrency.threadpool.TestScheduledExecutor
 * @description:TODO
 * @date:2016-5-10 下午5:02:15
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-5-10     WangHao       v1.0.0        create
 *
 *
 */
package haozijava.concurrency.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduledExecutor
{
	public static void main(String[] args)
	{
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);

		Runnable task = new Runnable()
		{

			@Override
			public void run()
			{

				System.out.println("task over");

			}

		};

		executor.scheduleAtFixedRate(task, 10, 2, TimeUnit.SECONDS);

	}
}
