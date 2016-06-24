/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.charencode.myfirsttest.TestReadByte
 * @description:TODO
 * @date:2016-6-24 下午3:27:59
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

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @className:haozijava.charencode.myfirsttest.TestReadByte
 * @description:数据流读取字节时的编码测试
 * @version:v1.0.0
 * @date:2016-6-24 下午3:28:15
 * @author:WangHao
 */
public class TestReadByte
{
	public static void main(String[] args) throws IOException
	{
		File file = new File("test.txt");
		InputStream input = new FileInputStream(file);
		StringBuffer buffer = new StringBuffer();
		byte[] bytes = new byte[1024];
		for (int n; (n = input.read(bytes)) != -1;)
		{
			// buffer.append(new String(bytes, 0, n, "GBK"));
			// buffer.append(new String(bytes, 0, n, "UTF-8"));
			buffer.append(new String(bytes, 0, n));
		}
		System.out.println(buffer);
	}
}
