/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:containers.QueueBehavior
 * @description:TODO
 * @date:2016-2-29 下午7:32:31
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-29     WangHao       v1.0.0        create
 *
 *
 */
package containers;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueBehavior
{
	private static int count = 10;
	static <T> void test(Queue<T> queue, List<T> gen)
	{
		for(int i = 0; i < count; i++)
			queue.offer(gen.get(i));
		while(queue.peek() != null)
			System.out.print(queue.remove() + " ");
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		List<String> gen = new LinkedList<String>();
		gen.add("one"); gen.add("two"); gen.add("three");
		gen.add("one"); gen.add("two"); gen.add("three");
		gen.add("one"); gen.add("two"); gen.add("three");
		gen.add("one"); gen.add("two"); gen.add("three");
		System.out.println(gen);
		test(new LinkedList<String>(), gen);
		test(new PriorityQueue<String>(), gen);
	}
}
