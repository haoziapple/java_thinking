/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:containers.ToDoList
 * @description:TODO
 * @date:2016-2-29 下午7:50:40
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

import java.util.PriorityQueue;

public class ToDoList extends PriorityQueue<ToDoList.ToDoItem>
{
	
	 /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	static class ToDoItem implements Comparable<ToDoItem>
	{
		private char primary;
		private int secondary;
		private String item;
		public ToDoItem(String td, char pri, int sec)
		{
			primary = pri;
			secondary = sec;
			item = td;
		}
		@Override
		public int compareTo(ToDoItem arg)
		{
			if(primary > arg.primary)
				return 1;
			if(primary == arg.primary)
				if(secondary > arg.secondary)
					return 1;
				else if(secondary == arg.secondary)
					return 0;
			return -1;
		}
		public String toString()
		{
			return Character.toString(primary)
					+ secondary + ": " + item;
		}
	}
	public void add(String td, char pri, int sec)
	{
		super.add(new ToDoItem(td, pri, sec));
	}
	
	public static void main(String[] args)
	{
		ToDoList list = new ToDoList();
		list.add("test", 'c', 4);
		list.add("Feed dog", 'A', 2);
		list.add("Feed bird", 'B', 7);
		list.add("Mow lawn", 'C', 3);
		list.add("Water lawn", 'B', 1);
		while(!list.isEmpty())
			System.out.println(list.remove());
	}
}
