/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.algorithm.MaxSubSum
 * @description:TODO
 * @date:2016-5-12 上午11:07:21
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

/**
 * @className:haozijava.algorithm.MaxSubSum
 * @description:数据结构与算法分析2.4.3：最大子序列和问题的求解
 * @version:v1.0.0
 * @date:2016-5-12 上午11:07:28
 * @author:WangHao
 */
public class MaxSubSum
{
	/**
	 * Cubic maximum contiguous subsequence sum algorithm
	 */
	public static int maxSubSum1(int[] a)
	{
		int maxSum = 0;
		for (int i = 0; i < a.length; i++)
			for (int j = i; j < a.length; j++)
			{
				int thisSum = 0;
				for (int k = i; k <= j; k++)
					thisSum += a[k];
				if (thisSum > maxSum)
					maxSum = thisSum;
			}
		return maxSum;
	}

	/**
	 * Quadratic maximum contiguous subsequence sum algorithm
	 */
	public static int maxSubSum2(int[] a)
	{
		int maxSum = 0;

		for (int i = 0; i < a.length; i++)
		{
			int thisSum = 0;
			for (int j = i; j < a.length; j++)
			{
				thisSum += a[j];

				if (thisSum > maxSum)
					maxSum = thisSum;
			}
		}

		return maxSum;
	}

	/**
	 * Recursive maximum contiguous subsequence sum algorithm. Finds maximum sum
	 * in subarray spanning a[left...right]. Does not attempt to maintain actual
	 * best sequence.
	 */
	public static int maxSumRec(int[] a, int left, int right)
	{
		if (left == right) // Base case
			if (a[left] > 0)
				return a[left];
			else
				return 0;

		int center = (left + right) / 2;
		int maxLeftSum = maxSumRec(a, left, center);
		int maxRightSum = maxSumRec(a, center + 1, right);

		int maxLeftBorderSum = 0, leftBorderSum = 0;
		for (int i = center; i >= left; i--)
		{
			leftBorderSum += a[i];
			if (leftBorderSum > maxLeftBorderSum)
				maxLeftBorderSum = leftBorderSum;
		}

		int maxRightBorderSum = 0, rightBorderSum = 0;
		for (int i = center + 1; i <= right; i++)
		{
			rightBorderSum += a[i];
			if (rightBorderSum > maxRightBorderSum)
				maxRightBorderSum = rightBorderSum;
		}

		// 求出maxLeftsum, maxRightSum, (maxLeftBorderSum+maxRightBorderSum)中的最大值
		return maxLeftSum >= maxRightSum ? maxLeftSum >= (maxLeftBorderSum + maxRightBorderSum) ? maxLeftSum
				: (maxLeftBorderSum + maxRightBorderSum)
				: maxRightSum >= (maxLeftBorderSum + maxRightBorderSum) ? maxRightSum
						: (maxLeftBorderSum + maxRightBorderSum);
	}

	/**
	 * Driver for divide-and-conquer maximum contiguous subsequence sum
	 * algorithm.
	 */
	public static int maxSubSum3(int[] a)
	{
		return maxSumRec(a, 0, a.length - 1);
	}

	/**
	 * Linear-time maximum contiguous subsequence sum algorithm.
	 */
	public static int maxSubSum4(int[] a)
	{
		int maxSum = 0, thisSum = 0;

		for (int j = 0; j < a.length; j++)
		{
			thisSum += a[j];

			if (thisSum > maxSum)
				maxSum = thisSum;
			else if (thisSum < 0)
				thisSum = 0;
		}

		return maxSum;
	}

	public static void main(String[] args)
	{
		int[] a = { 6, 2, 4, 7, -50, -30, -20, -100, 6, 9, 10, 2 };
		System.out.println(maxSubSum4(a));
	}
}
