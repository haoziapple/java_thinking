/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.genericclass.PairTest1
 * @description:TODO
 * @date:2016-4-6 下午3:03:12
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-6     WangHao       v1.0.0        create
 *
 *
 */
package corejava.genericclass;

public class PairTest1
{
	public static void main(String[] args)
	{
		String[] words =
		{ "Mary", "had", "a", "little", "lamb" };
		Pair<String> mm = ArrayAlg.minmax(words);
		System.out.println("min = " + mm.getFirst());
		System.out.println("max = " + mm.getSecond());
		System.out.println("Mary".compareTo("a"));
	}
}

class ArrayAlg
{
	/**
	 * Gets the minimum and maximum of an array of Strings.
	 */
	public static Pair<String> minmax(String[] a)
	{
		if (a == null || a.length == 0)
			return null;
		String min = a[0];
		String max = a[0];
		for (int i = 1; i < a.length; i++)
		{
			if (min.compareTo(a[i]) > 0)
				min = a[i];
			if (max.compareTo(a[i]) < 0)
				max = a[i];
		}
		return new Pair<String>(min, max);
	}
}