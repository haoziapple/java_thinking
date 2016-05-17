/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:coninaction.NoVisibility
 * @description:TODO
 * @date:2016-5-17 下午3:27:20
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-5-17     WangHao       v1.0.0        create
 *
 *
 */
package coninaction;

/**
 * @className:coninaction.NoVisibility
 * @description:在没有同步的情况下共享变量（不要这么做）
 * @version:v1.0.0
 * @date:2016-5-17 下午3:27:24
 * @author:WangHao
 */
public class NoVisibility
{
	private static boolean ready = false;
	private static int number = 0;

	private static class ReaderThread extends Thread
	{
		public void run()
		{
			while (!ready)
				Thread.yield();
			System.out.println(number);
		}
	}

	public static void main(String[] args)
	{
		new ReaderThread().start();
		number = 42;
		ready = true;
	}
}
