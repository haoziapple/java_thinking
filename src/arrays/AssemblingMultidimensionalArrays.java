/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:arrays.AssemblingMultidimensionalArrays
 * @description:TODO
 * @date:2016-2-19 上午10:23:11
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-19     WangHao       v1.0.0        create
 *
 *
 */
package arrays;

import java.util.Arrays;

public class AssemblingMultidimensionalArrays
{
	public static void main(String[] args)
	{
		Integer[][] a;
		a = new Integer[3][];
		for(int i = 0; i < a.length; i++)
		{
			a[i] = new Integer[3];
			for(int j = 0; j < a[i].length; j++)
			{
				a[i][j] = i*j;
				System.out.println(Arrays.deepHashCode(a));
				System.out.println(Arrays.deepToString(a));
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
