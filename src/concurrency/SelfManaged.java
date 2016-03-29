/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.SelfManaged
 * @description:TODO
 * @date:2016-3-19 下午3:53:42
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
//A Runnable containing its own driver Thread.
public class SelfManaged implements Runnable
{
	private int countDown = 5;
	private Thread t = new Thread(this);
	public SelfManaged()
	{
		t.start();
	}
	public String toString()
	{
		return Thread.currentThread().getName() + "(" + countDown + "), ";
	}
	public void run()
	{
		while(true)
		{
			System.out.print(this);
			if(--countDown == 0)
				return;
		}
	}
	public static void main(String[] args)
	{
		for(int i=0; i<5; i++)
			new SelfManaged();
	}
}
