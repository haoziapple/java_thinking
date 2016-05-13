/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.algorithm.BinarySearch
 * @description:TODO
 * @date:2016-5-12 下午3:26:15
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-5-12     WangHao       v1.0.0        create
 *
 *
 */
package haozijava.algorithm;

public class BinarySearch
{
	public static final int NOT_FOUND = -1;

	public static <T extends Comparable<? super T>> int binarySearch(T[] a, T x)
	{
		int low = 0, high = a.length - 1;

		while (low <= high)
		{
			int mid = (low + high) / 2;

			if (a[mid].compareTo(x) < 0)
				low = mid + 1;
			else if (a[mid].compareTo(x) > 0)
				high = mid - 1;
			else
				return mid; // Found
		}
		return NOT_FOUND;
	}

}
