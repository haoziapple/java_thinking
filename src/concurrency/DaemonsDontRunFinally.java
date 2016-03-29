/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.DaemonsDontRunFinally
 * @description:TODO
 * @date:2016-3-19 下午3:34:14
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-19     WangHao       v1.0.0        create
 *
 *
 */
package concurrency;

import java.util.concurrent.TimeUnit;

class ADaemon implements Runnable
{
	public void run()
	{
		try
		{
			System.out.println("Starting ADaemon");
			TimeUnit.SECONDS.sleep(1);
		}
		catch(InterruptedException e)
		{
			System.out.println("Exiting via InterruptedException");
		}
		finally
		{
			System.out.println("This should always run?");
		}
	}
}
public class DaemonsDontRunFinally
{
	public static void main(String[] args) throws Exception
	{
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
	}

}
