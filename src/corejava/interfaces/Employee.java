/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.interfaces.Employee
 * @description:TODO
 * @date:2016-4-5 下午3:02:03
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
package corejava.interfaces;

public class Employee implements Comparable<Employee>
{
	private String name;
	private double salary;

	public Employee(String n, double s)
	{
		name = n;
		salary = s;
	}

	public String getName()
	{
		return name;
	}

	public double getSalary()
	{
		return salary;
	}

	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	@Override
	public int compareTo(Employee other)
	{
		return Double.compare(salary, other.salary);
	}

}
