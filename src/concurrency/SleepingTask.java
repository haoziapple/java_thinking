/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.SleepingTask
 * @description:TODO
 * @date:2016-3-18 上午11:50:01
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-18     WangHao       v1.0.0        create
 *
 *
 */
package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SleepingTask extends Liftoff
{
	public void run()
	{
		try
		{
			while(countDown-- >0)
			{
				System.out.println(status());
				//Old-style:
				//Thread.sleep(100);
				//Java SE5/6-style:
				TimeUnit.MILLISECONDS.sleep(1000);
			}
		}catch(InterruptedException e)
		{
			System.err.println("Interrupted");
		}
	}
	public static void main(String[] args)
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0; i<5; i++)
			exec.execute(new SleepingTask());
		exec.shutdown();
	}

}
