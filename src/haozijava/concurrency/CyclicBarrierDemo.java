/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.concurrency.CyclicBarrierDemo
 * @description:TODO
 * @date:2016-4-29 下午5:11:07
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

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo
{
	public static void main(String[] args)
	{
		CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable()
		{

			@Override
			public void run()
			{
				System.out.println("所有玩家进入第二关！");
			}
		});

		for (int i = 0; i < 4; i++)
		{
			new Thread(new Player(i, cyclicBarrier)).start();
		}
	}

}

class Player implements Runnable
{

	/**
	 * 线程之间需要交互，到一定的条件下，所有线程才能往下走
	 */
	private CyclicBarrier cyclicBarrier;
	private int id;

	public Player(int id, CyclicBarrier cyclicBarrier)
	{
		this.cyclicBarrier = cyclicBarrier;
		this.id = id;
	}

	@Override
	public void run()
	{
		try
		{
			System.out.println("玩家" + id + "正在玩第一关...");
			cyclicBarrier.await();
			System.out.println("玩家" + id + "进入第二关...");
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} catch (BrokenBarrierException e)
		{
			e.printStackTrace();
		}
	}
}
