/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.Redirecting
 * @description:TODO
 * @date:2016-3-10 下午2:59:10
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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Redirecting
{
	public static void main(String[] args) throws IOException
	{
		PrintStream console = System.out;
		BufferedInputStream in = new BufferedInputStream(
				new FileInputStream("DirList.java"));
		PrintStream out = new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream("test.out")));
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		String s;
		while((s = br.readLine()) != null)
			System.out.println(s);
		out.close(); //Remeber this!
		System.setOut(console);
	}
}
