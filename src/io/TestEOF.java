/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.TestEOF
 * @description:TODO
 * @date:2016-3-8 下午6:31:18
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-8     WangHao       v1.0.0        create
 *
 *
 */
package io;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class TestEOF
{
	public static void main(String[] args) throws IOException
	{
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream("DirList.java")));
		while(in.available() != 0)
			System.out.print((char)in.readByte());
	}
}
