/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.IntBufferDemo
 * @description:TODO
 * @date:2016-3-11 下午2:53:24
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

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

//视图缓冲器
//Manipulating ints in a ByteBuffer with an IntBuffer
public class IntBufferDemo
{
	private static final int BSIZE = 1024;
	public static void main(String[] args)
	{
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		IntBuffer ib = bb.asIntBuffer();
		//Store an array of int:
		ib.put(new int[]{11, 42, 47, 99, 143, 811, 1016});
		//Absolute location read and write:
		System.out.println(ib.get(3));
		ib.put(3, 1811);
		//Setting a new limit before rewinding the buffer.
		ib.flip();
		while(ib.hasRemaining())
		{
			int i = ib.get();
			System.out.println(i);
		}
	}
}
