/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.BufferedInputFile
 * @description:TODO
 * @date:2016-3-8 下午2:56:52
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedInputFile
{
	// Throw exceptions to console:
	public static String read(String filename) throws IOException
	{
		// Reading input by lines:
		BufferedReader in = new BufferedReader(new FileReader(filename));
		String s;
		StringBuilder sb = new StringBuilder();
		while((s = in.readLine()) != null)
			sb.append(s + "\n");
		in.close();
		return sb.toString();
	}
	public static void main(String[] args) throws IOException
	{
		System.out.println(read("DirList.java"));
	}

}
