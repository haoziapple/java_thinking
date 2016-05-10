/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.concurrency.threadpool.TestThreadPool
 * @description:TODO
 * @date:2016-5-10 下午4:51:20
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-5-10     WangHao       v1.0.0        create
 *
 *
 */
package haozijava.concurrency.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @className:haozijava.concurrency.threadpool.TestThreadPool
 * @description:线程池测试
 * @version:v1.0.0
 * @date:2016-5-10 下午4:51:25
 * @author:WangHao
 */
public class TestThreadPool
{
	public static void main(String[] args)
	{
		// 创建线程池
		ExecutorService exec = Executors.newFixedThreadPool(3);

		// 建立100个线程
		for (int index = 0; index < 100; index++)
		{
			Runnable run = new Runnable()
			{
				public void run()
				{

					// 随机毫秒
					long time = (long) (Math.random() * 500);
					System.out.println("Sleeping " + Thread.currentThread().getName() + ":" + time + "ms");
					try
					{
						Thread.sleep(time);

					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}

				}

			};

			// 执行
			exec.execute(run);
		}

		// 关闭
		exec.shutdown();

	}
}
