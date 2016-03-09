/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.FileOutputShortcut
 * @description:TODO
 * @date:2016-3-8 下午7:11:45
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
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;

public class FileOutputShortcut
{
	static String file = "FileOutputShortcut.out";
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(
				new StringReader(
						BufferedInputFile.read("DirList.java")));
		//Here's the shortcut:
		PrintWriter out = new PrintWriter(file);
		int lineCount = 1;
		String s;
		while((s = in.readLine()) != null)
			out.println(lineCount++ + ": " + s);
		out.close();
		//Show the stored file:
		System.out.println(BufferedInputFile.read(file));
	}

}
