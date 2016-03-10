/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.Echo
 * @description:TODO
 * @date:2016-3-10 下午2:33:38
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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//How to read from standard input
//(RunByHand)
public class Echo
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in));
		String s;
		while((s = stdin.readLine()) != null && s.length() != 0)
			System.out.println(s);
		//An empty line or Ctrl-Z teminates the program
	}
}
