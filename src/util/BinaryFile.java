/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:util.BinaryFile
 * @description:TODO
 * @date:2016-3-9 下午2:05:31
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
package util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//Utility for reading files in bunary form.
public class BinaryFile
{
	public static byte[] read(File bFile) throws IOException
	{
		BufferedInputStream bf = new BufferedInputStream(
				new FileInputStream(bFile));
		try
		{
			byte[] data = new byte[bf.available()];
			bf.read(data);
			return data;
		}finally{
			bf.close();
		}
	}
	public static byte[] read(String bFile) throws IOException
	{
		return read(new File(bFile).getAbsoluteFile());
	}
}
