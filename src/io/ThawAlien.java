/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.ThawAlien
 * @description:TODO
 * @date:2016-3-11 下午9:40:52
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

import java.io.FileInputStream;
import java.io.ObjectInputStream;

//Try to recover a serialized file without the
//class of object that's stored in that file.
//{RunByHand}
public class ThawAlien
{
	public static void main(String[] args) throws Exception
	{
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("X.file"));
		Object mystery = in.readObject();
		System.out.println(mystery.getClass());
	}
}
