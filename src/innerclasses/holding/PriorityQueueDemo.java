/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:innerclasses.holding.PriorityQueueDemo
 * @description:TODO
 * @date:2016-1-30 上午10:48:12
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-1-30     WangHao       v1.0.0        create
 *
 *
 */
package innerclasses.holding;

import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueDemo
{
	public static void main (String[] args) {
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		Random rand = new Random(47);
		for(int i = 0; i < 10; i++)
			pQueue.offer(rand.nextInt(i + 10));
		QueueDemo.printQ(pQueue);
	}
}
