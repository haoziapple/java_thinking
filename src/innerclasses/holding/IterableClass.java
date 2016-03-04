/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:innerclasses.holding.IterableClass
 * @description:TODO
 * @date:2016-2-1 上午10:23:56
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-1     WangHao       v1.0.0        create
 *
 *
 */
package innerclasses.holding;

import java.util.Iterator;

public class IterableClass implements Iterable<String>
{
	protected String[] words = ("Test String iterator").split(" ");

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<String> iterator()
	{
		return new Iterator<String>()
		{
			private int index = 0;

			@Override
			public boolean hasNext()
			{
				return index < words.length;
			}

			@Override
			public String next()
			{
				return words[index++];
			}

			@Override
			public void remove()
			{
				// TODO Auto-generated method stub

			}

		};
	}

	public static void main(String[] args)
	{
		for (String s : new IterableClass())
			System.out.print(s + " ");
	}

}
