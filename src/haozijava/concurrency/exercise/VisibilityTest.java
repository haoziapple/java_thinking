/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.concurrency.exercise.VisibilityTest
 * @description:TODO
 * @date:2016-5-5 上午9:32:50
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-5-5     WangHao       v1.0.0        create
 *
 *
 */
package haozijava.concurrency.exercise;

import java.util.concurrent.TimeUnit;

public class VisibilityTest
{
	private static boolean is = true;

	public static void main(String[] args)
	{
		new Thread(new Runnable()
		{
			@SuppressWarnings("unused")
			@Override
			public void run()
			{
				int i = 0;
				while (VisibilityTest.is)
				{

					i++;

					// 1synchronized (this) { } 会强制刷新主内存的变量值到线程栈?
					// 2System.out.println("1"); println 是synchronized
					// 的,会强制刷新主内存的变量值到线程栈?
					// 3sleep 会从新load主内存的值?
					// try {
					// TimeUnit.MICROSECONDS.sleep(1);
					// }catch (InterruptedException e) {
					// e.printStackTrace();
					// }
				}
			}
		}).start();
		try
		{
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		new Thread(new Runnable()
		{
			@Override
			public void run()
			{
				is = false; // 设置is为false，使上面的线程结束while循环
			}
		}).start();
	}

}
