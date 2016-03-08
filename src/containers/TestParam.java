/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:containers.TestParam
 * @description:TODO
 * @date:2016-3-7 下午7:47:50
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-7     WangHao       v1.0.0        create
 *
 *
 */
package containers;
// A data transfer object
public class TestParam
{
	public final int size;
	public final int loops;
	public TestParam(int size, int loops)
	{
		this.size = size;
		this.loops = loops;
	}
	// Create an array of TestParam from a varags sequence:
	public static TestParam[] array(int... values)
	{
		int size = values.length/2;
		TestParam[] result = new TestParam[size];
		int n = 0;
		for(int i=0; i < size; i++)
			result[i] = new TestParam(values[n++], values[n++]);
		return result;
	}
	//Convert a String array to a TestParam array:
	public static TestParam[] array(String[] values)
	{
		int[] vals = new int[values.length];
		for(int i = 0; i < vals.length; i++)
			vals[i] = Integer.decode(values[i]);
		return array(vals);
	}
}
