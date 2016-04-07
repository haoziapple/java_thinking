/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.collection.LinkedListTest
 * @description:TODO
 * @date:2016-4-7 下午1:50:25
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

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @className:corejava.collection.LinkedListTest
 * @description:This program demonstrates operations on linked lists.
 * @version:v1.0.0
 * @date:2016-4-7 下午1:50:35
 * @author:WangHao
 */
public class LinkedListTest
{
	public static void main(String[] args)
	{
		List<String> a = new LinkedList<String>();
		a.add("Amy");
		a.add("Carl");
		a.add("Erica");

		List<String> b = new LinkedList<String>();
		b.add("Bob");
		b.add("Doug");
		b.add("Frances");
		b.add("Gloria");

		// merge the words form b into a
		ListIterator<String> aIter = a.listIterator();
		Iterator<String> bIter = b.iterator();

		while (bIter.hasNext())
		{
			if (aIter.hasNext())
				aIter.next();
			aIter.add(bIter.next());
		}

		System.out.println(a);

		// remove every second word from b
		bIter = b.iterator();
		while (bIter.hasNext())
		{
			bIter.next(); // skip one element
			if (bIter.hasNext())
			{
				bIter.next(); //skip next element
				bIter.remove(); //remove that element
			}
		}
		
		System.out.println(b);
		//bulk operation:remove all words in b from a
		a.removeAll(b);
		
		System.out.println(a);

	}
}
