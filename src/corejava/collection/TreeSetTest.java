/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.collection.TreeSetTest
 * @description:TODO
 * @date:2016-4-7 下午3:33:25
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

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * This program sorts a set of item by comparing their description.
 */
public class TreeSetTest
{
	public static void main(String[] args)
	{
		SortedSet<Item> parts=new TreeSet<Item>();
		
		parts.add(new Item("Toaster", 1234));
		parts.add(new Item("Widget", 4562));
		parts.add(new Item("Modem", 9912));
		
		//Item默认排序按数字
		System.out.println(parts);
		
		//使用定制的比较器来按照描述信息排序
		SortedSet<Item> sortByDescription=new TreeSet<Item>(new Comparator<Item>()
				{
					public int compare(Item a, Item b)
					{
						String descA=a.getDescription();
						String descB=b.getDescription();
						
						return descA.compareTo(descB);
					}
				});
		
		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);
	}

}
