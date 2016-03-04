/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.ConcurrentLinkedQueueTest
 * @description:TODO
 * @date:2016-2-18 下午5:09:32
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-18     WangHao       v1.0.0        create
 *
 *
 */
package haozijava;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentLinkedQueueTest
{
	private static ConcurrentLinkedQueue<Integer> queue = new ConcurrentLinkedQueue<Integer>();
	//线程个数
	private static int count = 2;
	//CountDownLatch，一个同步辅助类，在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待。
	private static CountDownLatch latch = new CountDownLatch(count); 
	
	public static void main(String[] args) throws InterruptedException {
		long timeStart = System.currentTimeMillis();
		ExecutorService es = Executors.newFixedThreadPool(4);
		
		//向队列里添加了100个数
		ConcurrentLinkedQueueTest.offer();
		for (int i = 0; i < count; i++) {
			es.submit(new Poll());
		}
		latch.await();//使得主线程(main)阻塞直到latch.countDown()为零才继续执行
		System.out.println("cost time " + (System.currentTimeMillis() - timeStart) + "ms");
		es.shutdown();
	}
	
	public static void offer()
	{
		for (int i = 0; i < 100; i++)
		{
			queue.offer(i);
		}
	}
	
	public static class Poll implements Runnable {
		public void run() {
			while (!queue.isEmpty()) {
				System.out.println(queue.poll());
			}
			latch.countDown();
		}
	}
}
