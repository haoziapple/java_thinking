/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.streamio.TextFileTest
 * @description:TODO
 * @date:2016-4-8 下午8:52:41
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-8     WangHao       v1.0.0        create
 *
 *
 */
package corejava.streamio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class TextFileTest
{
	public static void main(String[] args) throws IOException
	{
		Employee[] staff = new Employee[3];

		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

		// save all employee records to the file employee.dat
		PrintWriter out = new PrintWriter("employee.dat", "UTF-8");
		try
		{
			writeData(staff, out);
		}
		finally
		{
			out.close();
		}

		// retrieve all records into a new array
		Scanner in = new Scanner(new FileInputStream("employee.dat"), "UTF-8");
		try
		{
			Employee[] newStaff = readData(in);
			// print the newly read employee records
			for (Employee e : newStaff)
				System.out.println(e);
		}
		finally
		{
			in.close();
		}
	}

	/**
	 * Writes all employees in an array to a print writer
	 */
	private static void writeData(Employee[] employees, PrintWriter out) throws IOException
	{
		// write number of employees
		out.println(employees.length);

		for (Employee e : employees)
			writeEmployee(out, e);
	}

	/**
	 * Reads an array of employees from a scanner
	 */
	private static Employee[] readData(Scanner in)
	{
		// retrieve the array size
		int n = in.nextInt();
		in.nextLine(); // consume newline

		Employee[] employees = new Employee[n];
		for (int i = 0; i < n; i++)
		{
			employees[i] = readEmployee(in);
		}
		return employees;
	}

	/**
	 * Writes employee data to a print writer
	 */
	public static void writeEmployee(PrintWriter out, Employee e)
	{
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(e.getHireDay());
		out.println(e.getName() + "|" + e.getSalary() + "|" + calendar.get(Calendar.YEAR) + "|"
				+ (calendar.get(Calendar.MONTH) + 1) + "|" + calendar.get(Calendar.DAY_OF_MONTH));
	}

	public static Employee readEmployee(Scanner in)
	{
		String line = in.nextLine();
		String[] tokens = line.split("\\|");
		String name = tokens[0];
		double salary = Double.parseDouble(tokens[1]);
		int year = Integer.parseInt(tokens[2]);
		int month = Integer.parseInt(tokens[3]);
		int day = Integer.parseInt(tokens[4]);
		return new Employee(name, salary, year, month, day);
	}

}

class Employee
{
	public static final int NAME_SIZE = 40;
	public static final int RECORD_SIZE = 2 * NAME_SIZE + 8 + 4 + 4 + 4;
	private Date hireDay;
	private String name;
	private String salary;

	public Employee()
	{
	}

	public Employee(String name, double salary, int year, int month, int day)
	{
		this.name = name;
		this.salary = Double.toString(salary);
		this.hireDay = new GregorianCalendar(year, month, day).getTime();
	}

	public String toString()
	{
		return name + salary;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSalary()
	{
		return salary;
	}

	public void setSalary(String salary)
	{
		this.salary = salary;
	}

	public Date getHireDay()
	{
		return hireDay;
	}

	public void setHireDay(Date hireDay)
	{
		this.hireDay = hireDay;
	}

}