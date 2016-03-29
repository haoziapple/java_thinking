/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.AtomicityTest
 * @description:TODO
 * @date:2016-3-22 上午9:34:42
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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable
{
	private int i = 0;
	public int getValue()
	{
		return  i;
	}
	private synchronized void evenIncrement()
	{
		i++;
		i++;
	}
	@Override
	public void run()
	{
		while(true)
			evenIncrement();
	}
	public static void main(String[] args)
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicityTest at = new AtomicityTest();
		exec.execute(at);
		while(true)
		{
			int val = at.getValue();
			if(val % 2 != 0)
			{
				System.out.println(val);
				System.exit(0);
			}
		}
	}

}
