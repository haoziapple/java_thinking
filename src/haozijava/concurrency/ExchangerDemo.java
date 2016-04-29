/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.concurrency.ExchangerDemo
 * @description:TODO
 * @date:2016-4-29 下午5:28:12
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-29     WangHao       v1.0.0        create
 *
 *
 */
package haozijava.concurrency;

import java.util.concurrent.Exchanger;

public class ExchangerDemo
{
	public static void main(String args[])
	{

		// 交换器
		Exchanger<String> exgr = new Exchanger<String>();

		new TeamB(exgr);
		new TeamA(exgr);
	}
}

/**
 * 项目组A
 * 
 */
class TeamA implements Runnable
{
	Exchanger<String> ex;

	String str;

	TeamA(Exchanger<String> c)
	{
		ex = c;
		str = new String();

		new Thread(this).start();
	}

	public void run()
	{
		char ch = 'A';
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 5; j++)
				str += (char) ch++;

			try
			{
				str = ex.exchange(str);
			} catch (InterruptedException exc)
			{
				System.out.println(exc);
			}
		}
	}
}

/**
 * 项目组B
 * 
 */
class TeamB implements Runnable
{
	Exchanger<String> ex;

	String str;

	TeamB(Exchanger<String> c)
	{
		ex = c;
		new Thread(this).start();
	}

	public void run()
	{

		for (int i = 0; i < 3; i++)
		{
			try
			{
				str = ex.exchange(new String());
				System.out.println("Got: " + str);
			} catch (InterruptedException exc)
			{
				System.out.println(exc);
			}
		}
	}
}
