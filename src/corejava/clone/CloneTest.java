/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.clone.CloneTest
 * @description:TODO
 * @date:2016-4-5 下午3:53:46
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
package corejava.clone;

public class CloneTest
{
	public static void main(String[] args)
	{
		Employee original=new Employee("John Q. Public", 50000);
		original.setHireDay(2000, 1, 1);
		try
		{
			Employee copy=original.clone();
			copy.raiseSalary(10);
			copy.setHireDay(2002, 12, 31);
			System.out.println("original="+original);
			System.out.println("copy="+copy);
		}
		catch (CloneNotSupportedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
