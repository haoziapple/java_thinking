/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.Blips
 * @description:TODO
 * @date:2016-3-12 上午11:14:23
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-12     WangHao       v1.0.0        create
 *
 *
 */
package io;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

//18.12.2序列化的控制
//Simple use of Externalizable & a pitfall
class Blip1 implements Externalizable
{
	public Blip1()
	{
		System.out.println("Blip1 Constructor");
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	@Override
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException
	{
		System.out.println("Blip1.readExternal");
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException
	{
		System.out.println("Blip1.writeExternal");
	}
}

class Blip2 implements Externalizable
{
	Blip2()
	{
		System.out.println("Blip1 Constructor");
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#readExternal(java.io.ObjectInput)
	 */
	@Override
	public void readExternal(ObjectInput arg0) throws IOException, ClassNotFoundException
	{
		System.out.println("Blip2.readExternal");
	}

	/* (non-Javadoc)
	 * @see java.io.Externalizable#writeExternal(java.io.ObjectOutput)
	 */
	@Override
	public void writeExternal(ObjectOutput arg0) throws IOException
	{
		System.out.println("Blip1.writeExternal");
	}
}
public class Blips
{
	public static void main(String[] args) throws IOException, ClassNotFoundException
	{
		System.out.println("Constructing objects: ");
		Blip1 b1 = new Blip1();
		Blip2 b2 = new Blip2();
		ObjectOutputStream o = new ObjectOutputStream(
				new FileOutputStream("Blips.out"));
		System.out.println("Saving objects: ");
		o.writeObject(b1);
		o.writeObject(b2);
		o.close();
		
		//Now get them back:
		ObjectInputStream in = new ObjectInputStream(
				new FileInputStream("Blips.out"));
		System.out.println("Recovering b1: ");
		b1 = (Blip1)in.readObject();
		//OOP! Throws an exception:
//		System.out.println("Recovering b2: ");
//		b2 = (Blip2)in.readObject();
	}

}
