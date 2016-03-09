/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.StoringAndRecoveringData
 * @description:TODO
 * @date:2016-3-9 上午9:38:42
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-9     WangHao       v1.0.0        create
 *
 *
 */
package io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StoringAndRecoveringData
{
	public static void main(String[] args) throws IOException
	{
		DataOutputStream out = new DataOutputStream(
				new BufferedOutputStream(
						new FileOutputStream("Data.txt")));
		out.writeDouble(3.14159);
		out.writeUTF("That was pi");
		out.writeDouble(1.41413);
		out.writeUTF("Square root of 2");
		out.close();
		DataInputStream in = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream("Data.txt")));
		System.out.println(in.readDouble());
		//Only readUTF() will recover the Java-UTF String properly:
		System.out.println(in.readUTF());
		System.out.println(in.readDouble());
		System.out.println(in.readUTF());
	}
}