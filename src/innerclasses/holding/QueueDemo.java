/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:innerclasses.holding.QueueDemo
 * @description:TODO
 * @date:2016-1-30 上午11:22:54
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

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class QueueDemo
{
	@SuppressWarnings("rawtypes")
	public static void printQ(Queue queue) {
		while(queue.peek() != null)
			System.out.print(queue.remove() + " ");
		System.out.println();
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random(47);
		for (int i = 0; i < 10; i++)
			queue.offer(rand.nextInt(i + 10));
		printQ(queue);
		Queue<Character> qc = new LinkedList<Character>();
		for (char c : "test queue".toCharArray())
			qc.offer(c);
		printQ(qc);
	}

}
