/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.collection.Sieve
 * @description:TODO
 * @date:2016-4-7 下午6:27:42
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

import java.util.BitSet;

/**
 * This program runs the Sieve of Erathostenes benchmark. It computes all primes
 * up to 2,000,000.
 */
public class Sieve
{
	public static void main(String[] s)
	{
		int n = 2000000;
		long start = System.currentTimeMillis();
		BitSet b = new BitSet(n + 1);
		int count = 0;
		int i;
		for (i = 2; i <= n; i++)
			b.set(i);
		i = 2;
		while (i * i <= n)
		{
			if (b.get(i))
			{
				count++;
				int k = 2 * i;
				while (k <= n)
				{
					b.clear(k);
					k += i;
				}
			}
			i++;
		}
		while (i <= n)
		{
			if (b.get(i))
				count++;
			i++;
		}
		long end = System.currentTimeMillis();
		System.out.println(count + " primes");
		System.out.println((end - start) + " milliseconds");
	}
}
