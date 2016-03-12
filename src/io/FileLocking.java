/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.FileLocking
 * @description:TODO
 * @date:2016-3-11 下午4:30:21
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

import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.concurrent.TimeUnit;

//文件加锁
public class FileLocking
{
	public static void main(String[] args) throws Exception
	{
		FileOutputStream fos = new FileOutputStream("file.txt");
		FileLock fl = fos.getChannel().tryLock();
		if(fl != null)
		{
			System.out.println("Locked File");
			TimeUnit.MILLISECONDS.sleep(100);
			fl.release();
			System.out.println("Released Lock");
		}
		fos.close();
	}

}
