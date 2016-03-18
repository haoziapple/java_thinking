/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.Liftoff
 * @description:TODO
 * @date:2016-3-18 上午10:28:51
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

//Demonstration of the Runnable interface
public class Liftoff implements Runnable
{
	protected int countDown = 10; //Default
	private static int taskCount = 0;
	private final int id = taskCount++;
	public Liftoff() {}
	public Liftoff(int countDown)
	{
		this.countDown = countDown;
	}
	public String status()
	{
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
	}
	@Override
	public void run()
	{
		while(countDown-- > 0)
		{
			System.out.print(status());
			Thread.yield();
		}
	}

}
