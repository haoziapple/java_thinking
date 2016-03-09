/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.FormattedMemoryInput
 * @description:TODO
 * @date:2016-3-8 下午6:21:54
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

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;

public class FormattedMemoryInput
{
	public static void main(String[] args) throws IOException
	{
		try{
			DataInputStream in = new DataInputStream(
					new ByteArrayInputStream(
							BufferedInputFile.read(
									"DirList.java").getBytes()));
			while(true)
				System.out.print((char)in.readByte());
		}catch(EOFException e)
		{
			System.err.println("End of stream");
		}
	}
}
