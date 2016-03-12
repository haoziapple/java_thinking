/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.Endians
 * @description:TODO
 * @date:2016-3-11 下午3:14:28
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
import java.nio.ByteOrder;
import java.util.Arrays;

//通过字节存放模式设置来改变字符中的字节次序
//一般默认为高位优先，即重要的字节存放在地址最低的存储单元
//Endian differences and data storage
public class Endians
{
	public static void main(String[] args)
	{
		ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
		bb.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(bb.array()));
		bb.rewind();
		
		bb.order(ByteOrder.BIG_ENDIAN);
		bb.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(bb.array()));
		bb.rewind();
		
		bb.order(ByteOrder.LITTLE_ENDIAN);
		bb.asCharBuffer().put("abcdef");
		System.out.println(Arrays.toString(bb.array()));
	}
}
