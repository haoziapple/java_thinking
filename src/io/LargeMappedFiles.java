/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.LargeMappedFiles
 * @description:TODO
 * @date:2016-3-11 下午4:06:37
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-11     WangHao       v1.0.0        create
 *
 *
 */
package io;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

//内存映射文件
//Creating a very large file using mapping
//{RunByHand}
public class LargeMappedFiles
{
	static int length = 0x8FFFFFF; // 128MB

	public static void main(String[] args) throws Exception
	{
		MappedByteBuffer out = new RandomAccessFile("test.dat", "rw").
				getChannel().
				map(FileChannel.MapMode.READ_WRITE,0, length);
		for(int i = 0; i < length; i++)
			out.put((byte) 'x');
		System.out.println("Finished writing");
		for(int i = length/2; i < length/2 + 6; i++)
			System.out.print((char)out.get(i));
	}
}
