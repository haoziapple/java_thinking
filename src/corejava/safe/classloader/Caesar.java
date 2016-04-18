/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.safe.classloader.Caesar
 * @description:TODO
 * @date:2016-4-18 下午2:45:11
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-18     WangHao       v1.0.0        create
 *
 *
 */
package corejava.safe.classloader;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Encrypts a file using the Caesar cipher.
 */
public class Caesar
{
	public static void main(String[] args) throws Exception
	{
		if (args.length != 3)
		{
			System.out.println("USAGE: java classLoader in out key");
			return;
		}

		FileInputStream in = new FileInputStream(args[0]);
		FileOutputStream out = new FileOutputStream(args[1]);

		int key = Integer.parseInt(args[2]);
		int ch;
		while ((ch = in.read()) != -1)
		{
			byte c = (byte) (ch + key);
			out.write(c);
		}
	}
}
