/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.AtomicIntegerTest
 * @description:TODO
 * @date:2016-3-22 下午2:28:45
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

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest implements Runnable
{
	private AtomicInteger i = new AtomicInteger(0);
	public int getValue()
	{
		return i.get();
	}
	private void evenIncrement()
	{
		i.addAndGet(2);
	}
	@Override
	public void run()
	{
		while(true)
			evenIncrement();
	}
	
	public static void main(String[] args)
	{
		new Timer().schedule(new TimerTask(){

			@Override
			public void run()
			{
				System.out.println("Aborting");
				System.exit(0);
			}
			
		}, 5000);//Terminate after 5 seconds
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicIntegerTest ait = new AtomicIntegerTest();
		exec.execute(ait);
		while(true)
		{
			int val = ait.getValue();
			if(val % 2 != 0)
			{
				System.out.println(val);
				System.exit(0);
			}
		}
	}
}
