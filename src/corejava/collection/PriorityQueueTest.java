/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.collection.PriorityQueueTest
 * @description:TODO
 * @date:2016-4-7 下午4:40:32
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-7     WangHao       v1.0.0        create
 *
 *
 */
package corejava.collection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.PriorityQueue;

/**
 * This program demonstrates the use of a priority queue.
 */
public class PriorityQueueTest
{
	public static void main(String[] args)
	{
		PriorityQueue<GregorianCalendar> pq = new PriorityQueue<GregorianCalendar>();
		pq.add(new GregorianCalendar(1906, Calendar.DECEMBER, 9));
		pq.add(new GregorianCalendar(1815, Calendar.DECEMBER, 10));
		pq.add(new GregorianCalendar(1903, Calendar.DECEMBER, 3));
		pq.add(new GregorianCalendar(1910, Calendar.JUNE, 22));

		//迭代并不是按照元素的排列顺序访问的
		System.out.println("Iterating over elements...");
		for (GregorianCalendar date : pq)
			System.out.println(date.get(Calendar.YEAR));
				
		//删除总是删掉剩余元素中优先级数最小的元素
		System.out.println("Removing elements...");
		while (!pq.isEmpty())
			System.out.println(pq.remove().get(Calendar.YEAR));
	}
}
