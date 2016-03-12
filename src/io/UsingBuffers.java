/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.UsingBuffers
 * @description:TODO
 * @date:2016-3-11 下午3:34:50
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
import java.nio.CharBuffer;

//交换相邻字符
public class UsingBuffers
{
	private static void symmetricScramble(CharBuffer buffer)
	{
		while(buffer.hasRemaining())
		{
			buffer.mark();
			char c1 = buffer.get();
			char c2 = buffer.get();
			buffer.reset();
			buffer.put(c2).put(c1);
		}
	}
	public static void main(String[] args)
	{
		char[] data = "UsingBuffers".toCharArray();
		ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
		CharBuffer cb = bb.asCharBuffer();
		cb.put(data);
		
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
		symmetricScramble(cb);
		System.out.println(cb.rewind());
	}
}
