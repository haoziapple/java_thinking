/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.charencode.myfirsttest.TestReadMem
 * @description:TODO
 * @date:2016-6-27 下午4:34:02
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-27     WangHao       v1.0.0        create
 *
 *
 */
package haozijava.charencode.myfirsttest;

import java.io.UnsupportedEncodingException;

/**
 * @className:haozijava.charencode.myfirsttest.TestReadMem
 * @description:测试内存中的字符编码
 * @version:v1.0.0
 * @date:2016-6-27 下午4:34:08
 * @author:WangHao
 */
public class TestReadMem
{
	String s;
	byte[] bytes;
	String s1;
	String s2;
	
	public TestReadMem() throws UnsupportedEncodingException
	{
		s = "我是 cm";
		bytes = s.getBytes();
		s1 = new String(bytes, "GBK");
		s2 = new String(bytes);
	}
	
	public static void main(String[] args)
	{
		
	}
}
