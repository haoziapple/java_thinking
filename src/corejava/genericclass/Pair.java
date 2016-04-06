/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.genericclass.Pair
 * @description:TODO
 * @date:2016-4-6 下午3:01:00
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-6     WangHao       v1.0.0        create
 *
 *
 */
package corejava.genericclass;

public class Pair<T>
{
	private T first;
	private T second;

	public Pair()
	{
		first = null;
		second = null;
	}

	public Pair(T first, T second)
	{
		this.first = first;
		this.second = second;
	}

	public T getFirst()
	{
		return first;
	}

	public void setFirst(T first)
	{
		this.first = first;
	}

	public T getSecond()
	{
		return second;
	}

	public void setSecond(T second)
	{
		this.second = second;
	}

}
