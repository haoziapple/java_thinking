/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:util.Range
 * @description:TODO
 * @date:2016-6-20 下午3:30:43
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-20     WangHao       v1.0.0        create
 *
 *
 */
package util;

/**
 * @className:util.Range
 * @description:Array creation methods that can be used without qualifiers,
 *                    using Java SE5 static imports
 * @version:v1.0.0
 * @date:2016-6-20 下午3:30:48
 * @author:WangHao
 */
public class Range
{
	// Produce a sequence [0..n)
	public static int[] range(int n)
	{
		int[] result = new int[n];
		for (int i = 0; i < n; i++)
		{
			result[i] = i;
		}
		return result;
	}

	// Produce a sequence[start..end)
	public static int[] range(int start, int end)
	{
		int sz = end - start;
		int[] result = new int[sz];
		for (int i = 0; i < sz; i++)
		{
			result[i] = start + i;
		}
		return result;
	}

	// Produce a sequence[start..end) incrementing by step
	public static int[] range(int start, int end, int step)
	{
		int sz = (end - start) / step;
		int[] result = new int[sz];
		for (int i = 0; i < sz; i++)
		{
			result[i] = start + (i * step);
		}
		return result;
	}
}
