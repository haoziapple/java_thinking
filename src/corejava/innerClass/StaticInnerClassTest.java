/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.innerClass.StaticInnerClassTest
 * @description:TODO
 * @date:2016-4-5 下午4:54:38
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-5     WangHao       v1.0.0        create
 *
 *
 */
package corejava.innerClass;

//demonstrates the use of static inner classes.

class ArrayAlg
{
	/**
	 * A pair of floating-point numbers
	 * 
	 * @className:corejava.innerClass.Pair
	 * @description:TODO
	 * @version:v1.0.0
	 * @date:2016-4-5 下午4:56:31
	 * @author:WangHao
	 */
	public static class Pair
	{
		private double first;
		private double second;

		public Pair(double f, double s)
		{
			this.first = f;
			this.second = s;
		}

		public double getFirst()
		{
			return this.first;
		}

		public double getSecond()
		{
			return this.second;
		}
	}

	/**
	 * Computes both the minimum and maximum of an array
	 * 
	 * @Description:
	 * @param values
	 * @return
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016-4-5 下午5:00:43
	 */
	public static Pair minmax(double[] values)
	{
		double min = Double.MAX_VALUE;
		double max = Double.MIN_VALUE;
		for (double v : values)
		{
			if (min > v)
				min = v;
			if (max < v)
				max = v;
		}
		return new Pair(min, max);
	}

}

public class StaticInnerClassTest
{
	public static void main(String[] args)
	{
		double[] d = new double[20];
		for (int i = 0; i < d.length; i++)
			d[i] = 100 * Math.random();
		ArrayAlg.Pair p = ArrayAlg.minmax(d);
		System.out.println("min= " + p.getFirst());
		System.out.println("max= " + p.getSecond());
	}
}
