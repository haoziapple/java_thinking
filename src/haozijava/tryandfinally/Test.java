/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.tryandfinally.Test
 * @description:TODO
 * @date:2016-5-5 上午9:49:23
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-5-5     WangHao       v1.0.0        create
 *
 *
 */
package haozijava.tryandfinally;

public class Test
{
	public int aaa()
	{
		int x = 1;
		try
		{
			return ++x;
		} catch (Exception e)
		{
		} finally
		{
			++x;
		}
		return x;
	}

	public static void main(String[] args)
	{
		Test t = new Test();
		int y = t.aaa();
		System.out.println(y);
	}
}
