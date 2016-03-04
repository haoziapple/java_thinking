/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.BlockingQueueTest2
 * @description:TODO
 * @date:2016-2-18 下午3:48:26
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

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest2
{
	public class Basket {
		//篮子可以容纳三个
		BlockingQueue<String> basket = new LinkedBlockingQueue<String>(3);
		public void produce() throws InterruptedException {
			basket.put("An apple");
		}
		public String consume() throws InterruptedException {
			return basket.take();
		}
	}
	class Producer implements Runnable {
		private String instance;
		private Basket basket;
		
		public Producer(String instance, Basket basket) {
			this.instance = instance;
			this.basket = basket;
		}

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run()
		{
			try {
				while (true) {
					System.out.println("producer is ready to run: " + instance);
					basket.produce();
					System.out.println("production is done! " + instance);
					Thread.sleep(300);
				}
			} catch (InterruptedException e) {
				System.out.println("Producer Interruptted");
			}
		}
	}
	class Consumer implements Runnable {
		private String instance;
		private Basket basket;
		public Consumer(String instance, Basket basket) {
			this.instance = instance;
			this.basket = basket;
		}

		/* (non-Javadoc)
		 * @see java.lang.Runnable#run()
		 */
		@Override
		public void run()
		{
			try {
				while(true) {
					System.out.println("consumer is ready to run: " + instance);
					System.out.println(basket.consume());
					System.out.println("consumption is done: " + instance);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				System.out.println("Consumer Interrupted");
			}
		}
	}
	public static void main(String[] args) {
		BlockingQueueTest2 test = new BlockingQueueTest2();
		Basket basket = test.new Basket();
		  ExecutorService service = Executors.newCachedThreadPool();
	        Producer producer = test.new Producer("生产者001", basket);
	        Producer producer2 = test.new Producer("生产者002", basket);
	        Consumer consumer = test.new Consumer("消费者001", basket);
	        service.submit(producer);
	        service.submit(producer2);
	        service.submit(consumer);
	        // 程序运行5s后，所有任务停止
//	        try {
//	            Thread.sleep(1000 * 5);
//	        } catch (InterruptedException e) {
//	            e.printStackTrace();
//	        }
//	        service.shutdownNow();    }

	}

}
