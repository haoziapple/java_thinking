/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.SimpleThread
 * @description:TODO
 * @date:2016-3-19 下午3:39:51
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
//Inheriting directly from the Thread class.
public class SimpleThread extends Thread
{
	private int countDown = 5;
	private static int threadCount = 0;
	public SimpleThread()
	{
		//Store the thread name:
		super(Integer.toString(++threadCount));
		start();
	}
	public String toString()
	{
		return "#" + getName() + "(" + countDown + "), ";
	}
	public void run()
	{
		while(true)
		{
			System.out.println(this);
			if(--countDown == 0)
				return;
		}
	}
	public static void main(String[] args)
	{
		for(int i=0; i<5; i++)
			new SimpleThread();
	}
}