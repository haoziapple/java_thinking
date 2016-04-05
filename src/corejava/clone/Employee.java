/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.clone.Employee
 * @description:TODO
 * @date:2016-4-5 下午3:37:49
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

import java.util.Date;
import java.util.GregorianCalendar;

//Cloneable is a tagging interface or marker interface
//if (obj instanceof Cloneable)...
//can be used to verify an object
public class Employee implements Cloneable
{
	private String name;
	private double salary;
	private Date hireDay;

	public Employee(String n, double s)
	{
		name = n;
		salary = s;
		hireDay = new Date();
	}

	public Employee clone() throws CloneNotSupportedException
	{
		// call Object.clone()
		Employee cloned = (Employee) super.clone();

		// clone mutable fields
		cloned.hireDay = (Date) hireDay.clone();

		return cloned;
	}

	public void setHireDay(int year, int month, int day)
	{
		Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();

		// Example of instance field mutation
		hireDay.setTime(newHireDay.getTime());
	}

	public void raiseSalary(double byPercent)
	{
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	public String toString()
	{
		return "Employee[name=" + name + ",salary" + salary + ",hireDay=" + hireDay + "]";
	}

}
