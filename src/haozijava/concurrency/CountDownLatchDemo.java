/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.concurrency.CountDownLatchDemo
 * @description:TODO
 * @date:2016-4-29 下午5:02:19
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

import java.util.concurrent.CountDownLatch;

/**
 * @className:haozijava.concurrency.CountDownLatchDemo
 * @description:分布执行任务
 * @version:v1.0.0
 * @date:2016-4-29 下午5:03:07
 * @author:WangHao
 */
public class CountDownLatchDemo implements Runnable
{
	private int id;

	// 线程之间不影响，到了终点后继续做自己的事情
	private CountDownLatch countDownLatch;

	public CountDownLatchDemo(int id, CountDownLatch countDownLatch)
	{
		this.id = id;
		this.countDownLatch = countDownLatch;
	}

	@SuppressWarnings("static-access")
	@Override
	public void run()
	{
		try
		{

			System.out.println("第" + (id + 1) + "小老婆开始查找《四十二章经》...");
			Thread.currentThread().sleep(id * 1000);
			System.out.println("第" + (id + 1) + "本《四十二章经》找到");

			// 计数器将等待数字-1
			countDownLatch.countDown();

			System.out.println("第" + (id + 1) + "小老婆继续干其他事情");
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		CountDownLatch countDownLatch = new CountDownLatch(8);

		for (int i = 0; i < 8; i++)
		{
			new Thread(new CountDownLatchDemo(i, countDownLatch)).start();
		}

		try
		{

			System.out.println("韦小宝等着等着8本四十二章……");

			// 韦小宝等着等着
			countDownLatch.await();

			// 等待运动员到达终点
			System.out.println("8本四十二章经找寻完成，可以寻宝了！");
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
