/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:containers.ListPerformance
 * @description:TODO
 * @date:2016-3-8 上午9:50:21
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-8     WangHao       v1.0.0        create
 *
 *
 */
package containers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

//Demonstrates performance differences in lists 
public class ListPerformance
{
	static Random rand = new Random();
	static int reps = 1000;
	static List<Test<List<Integer>>> tests = new ArrayList<Test<List<Integer>>>();
	static List<Test<LinkedList<Integer>>> qTests = new ArrayList<Test<LinkedList<Integer>>>();
	static
	{
		tests.add(new Test<List<Integer>>("add")
		{

			@Override
			int test(List<Integer> list, TestParam tp)
			{
				int loops = tp.loops;
				int listSize = tp.size;
				for (int i = 0; i < loops; i++)
				{
					list.clear();
					for (int j = 0; j < listSize; j++)
						list.add(j);
				}
				return loops * listSize;
			}
		});
		tests.add(new Test<List<Integer>>("get")
		{

			@Override
			int test(List<Integer> list, TestParam tp)
			{
				int loops = tp.loops * reps;
				int listSize = list.size();
				for (int i = 0; i < loops; i++)
					list.get(rand.nextInt(listSize));
				return loops;
			}
		});
		tests.add(new Test<List<Integer>>("set")
		{

			@Override
			int test(List<Integer> list, TestParam tp)
			{
				int loops = tp.loops * reps;
				int listSize = list.size();
				for (int i = 0; i < loops; i++)
					list.set(rand.nextInt(listSize), 47);
				return loops;
			}
		});
		// Tests for queue behavior:
		qTests.add(new Test<LinkedList<Integer>>("addFirst")
		{
			@Override
			int test(LinkedList<Integer> list, TestParam tp)
			{
				int loops = tp.loops;
				int size = tp.size;
				for (int i = 0; i < loops; i++)
				{
					list.clear();
					for (int j = 0; j < size; j++)
						list.addLast(47);
				}
				return loops * size;
			}
		});
		qTests.add(new Test<LinkedList<Integer>>("rmFirst")
		{
			@SuppressWarnings("serial")
			@Override
			int test(LinkedList<Integer> list, TestParam tp)
			{
				int loops = tp.loops;
				int size = tp.size;
				for(int i = 0; i < loops; i++)
				{
					list.clear();
					list.addAll(new ArrayList<Integer>(size){});
					while(list.size() > 0)
						list.removeFirst();
				}
				return loops * size;
			}
		});
	}
	static class ListTester extends Tester<List<Integer>>
	{
		public ListTester(List<Integer> container, List<Test<List<Integer>>> tests)
		{
			super(container, tests);
		}
		//Fill to the appropriate size before each test:
		@SuppressWarnings("serial")
		@Override
		protected List<Integer> initialize(int size)
		{
			container.clear();
			container.addAll(new ArrayList<Integer>(size){});
			return container;
		}
		//Convenience method:
		public static void run(List<Integer> list, List<Test<List<Integer>>> tests)
		{
			new ListTester(list, tests).timedTest();
		}
	}
}
