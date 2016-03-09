/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.MemoryInput
 * @description:TODO
 * @date:2016-3-8 下午5:47:39
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

import java.io.IOException;
import java.io.StringReader;

public class MemoryInput
{
	public static void main(String[] args) throws IOException
	{
		StringReader in = new StringReader(BufferedInputFile.read("DirList.java"));
		int c;
		while((c = in.read()) != -1)
			System.out.print((char)c);
	}

}
