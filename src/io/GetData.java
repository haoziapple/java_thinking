/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.GetData
 * @description:TODO
 * @date:2016-3-11 下午2:15:32
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

//Getting different representations from a ByteBuffer
public class GetData
{
	private static final int BSIZE = 1024;
	public static void main(String[] args)
	{
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		
		//Allocation automatically zeros the ByteBuffer:
		int i = 0;
		while(i++ < bb.limit())
			if(bb.get() != 0)
				System.out.println("nonzero");
		System.out.println("i = " + i);
		bb.rewind();
		
		//Store and read a char array:
		bb.asCharBuffer().put("Howdy!");
		char c;
		while((c = bb.getChar()) != 0)
			System.out.print(c + " ");
		System.out.println();
		bb.rewind();
		
		//Store and read a short:
		bb.asShortBuffer().put((short)471142);
		System.out.println(bb.getShort());
		bb.rewind();
		
		//Store and read a int:
		bb.asIntBuffer().put(99471142);
		System.out.println(bb.getInt());
		bb.rewind();
		
		//Store and read a long:
		bb.asLongBuffer().put(99471142);
		System.out.println(bb.getLong());
		bb.rewind();
		
		//Store and read a float:
		bb.asFloatBuffer().put(99471142);
		System.out.println(bb.getFloat());
		bb.rewind();
		
		//Store and read a double:
		bb.asDoubleBuffer().put(7.22);
		System.out.println(bb.getDouble());
		bb.rewind();
	}

}
