/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:util.Print
 * @description:TODO
 * @date:2016-6-16 上午9:14:40
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-16     WangHao       v1.0.0        create
 *
 *
 */
package util;

import java.io.PrintStream;

/**
 * @className:util.Print
 * @description:打印字串
 * @version:v1.0.0
 * @date:2016-6-16 上午9:14:44
 * @author:WangHao
 */
public class Print
{
	public static void print(Object obj)
	{
		System.out.println(obj);
	}

	public static void print()
	{
		System.out.println();
	}

	// Print with no line break;
	public static void printnb(Object obj)
	{
		System.out.print(obj);
	}

	// The new Java SE5 printf() (from C):
	public static PrintStream printf(String format, Object... args)
	{
		return System.out.printf(format, args);
	}
}
