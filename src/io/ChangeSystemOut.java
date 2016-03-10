/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.ChangeSystemOut
 * @description:TODO
 * @date:2016-3-10 下午2:55:33
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-10     WangHao       v1.0.0        create
 *
 *
 */
package io;

import java.io.PrintWriter;

//Turn System.out into a PrinterWriter.
public class ChangeSystemOut
{
	public static void main(String[] args)
	{
		PrintWriter out = new PrintWriter(System.out, true);
		out.println("Hello, world");
	}
}
