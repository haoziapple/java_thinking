/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:generics.Holder2
 * @description:TODO
 * @date:2016-2-17 下午2:23:29
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-17     WangHao       v1.0.0        create
 *
 *
 */
package generics;
public class Holder2
{
	private Object a;
	public Holder2(Object a) {this.a = a;}
	public Object get()
	{
		return a;
	}
	public void set(Object a)
	{
		this.a = a;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Holder2 h2 = new Holder2(new Automobile());
		Automobile a = (Automobile)h2.get();
		h2.set("Not an Automobile");
		String s = (String)h2.get();
		h2.set(1); //AutoBoxes to Integer
		Integer x = (Integer)h2.get();
	}
}
