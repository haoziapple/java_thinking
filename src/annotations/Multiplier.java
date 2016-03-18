/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:annotations.Multiplier
 * @description:TODO
 * @date:2016-3-17 下午6:33:19
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-17     WangHao       v1.0.0        create
 *
 *
 */
package annotations;

//APT-based annotation processing.
@ExtractInterface("IMultiplier")
public class Multiplier
{
	public int multiply(int x, int y)
	{
		int total = 0;
		for(int i = 0; i<x ; i++)
			total = add(total, y);
		return total;
	}
	private int add(int x, int y)
	{
		return x+y;
	}
	public static void main(String[] args)
	{
		Multiplier m = new Multiplier();
		System.out.println("11*16 = " + m.multiply(11, 16));
	}
}
