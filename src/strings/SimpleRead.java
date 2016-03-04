/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:strings.SimpleRead
 * @description:TODO
 * @date:2016-2-14 下午1:12:51
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-14     WangHao       v1.0.0        create
 *
 *
 */
package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class SimpleRead
{
	public static BufferedReader input = new BufferedReader(new StringReader("Sir Robin of Camelot\n22 1.62803"));
	public static void main(String[] args) {
		try {
			System.out.println("What is your name?");
			String name = input.readLine();
			System.out.println(name);
			
			
		} catch(IOException e) {
			System.err.print("I/O exception");
		}
	}
}
