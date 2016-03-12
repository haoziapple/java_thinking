/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.FreezeAlien
 * @description:TODO
 * @date:2016-3-11 下午9:30:18
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
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//Create a serialized output file.
@SuppressWarnings("serial")
class Alien implements Serializable{}

public class FreezeAlien
{
	public static void main(String[] args) throws Exception
	{
		ObjectOutput out = new ObjectOutputStream(new FileOutputStream("X.file"));
		Alien quellek = new Alien();
		out.writeObject(quellek);
	}
}
