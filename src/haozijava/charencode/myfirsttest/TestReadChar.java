/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.charencode.myfirsttest.TestReadChar
 * @description:TODO
 * @date:2016-6-24 下午3:33:57
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-24     WangHao       v1.0.0        create
 *
 *
 */
package haozijava.charencode.myfirsttest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * @className:haozijava.charencode.myfirsttest.TestReadChar
 * @description:测试读取字节流时的编码转换
 * @version:v1.0.0
 * @date:2016-6-24 下午3:34:21
 * @author:WangHao
 */
public class TestReadChar
{
	public static void main(String[] args) throws IOException
	{
		String file = "test.txt";
		String charset = "UTF-8"; // 写字符换转成字节流
		FileOutputStream outputStream = new FileOutputStream(file);
		OutputStreamWriter writer = new OutputStreamWriter(outputStream, charset);
		try
		{
			writer.write("我是 cm");
		} finally
		{
			writer.close();
		} // 读取字节转换成字符
		FileInputStream inputStream = new FileInputStream(file);
		InputStreamReader reader = new InputStreamReader(inputStream, charset);
		StringBuffer buffer = new StringBuffer();
		char[] buf = new char[64];
		int count = 0;
		try
		{
			while ((count = reader.read(buf)) != -1)
			{
				buffer.append(buf, 0, count);
			}
		} finally
		{
			reader.close();
		}
		System.out.println(buffer);
	}
}
