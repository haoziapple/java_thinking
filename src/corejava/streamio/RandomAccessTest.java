/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.streamio.RandomAccessTest
 * @description:TODO
 * @date:2016-4-8 下午10:31:08
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

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class RandomAccessTest
{
	public static void main(String[] args) throws IOException
	{
		Employee[] staff = new Employee[3];
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		DataOutputStream out = new DataOutputStream(new FileOutputStream("employee.dat"));

		// save all employee records to the file employee.dat
		for (Employee e : staff)
			writeData(out, e);

		out.close();

		RandomAccessFile in = new RandomAccessFile("employee.dat", "r");

		// retrieve all records into a new array

		// compute the array size
		int n = (int) (in.length() / Employee.RECORD_SIZE);
		Employee[] newStaff = new Employee[n];

		for (int i = n - 1; i >= 0; i--)
		{
			newStaff[i] = new Employee();
			in.seek(i * Employee.RECORD_SIZE);
			newStaff[i] = readData(in);
		}

		in.close();
		// print the newly read employee records
		for (Employee e : newStaff)
			System.out.println(e);

	}

	/**
	 * Write employee data to a data output
	 */
	public static void writeData(DataOutput out, Employee e) throws IOException
	{
		DataIO.writeFixedString(e.getName(), Employee.NAME_SIZE, out);
		out.writeDouble(Double.parseDouble(e.getSalary()));

		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(e.getHireDay());
		out.writeInt(calendar.get(Calendar.YEAR));
		out.writeInt(calendar.get(Calendar.MONTH) + 1);
		out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
	}

	/**
	 * Reads employee data from a data input.
	 */
	public static Employee readData(DataInput in) throws IOException
	{
		String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
		double salary = in.readDouble();
		int y = in.readInt();
		int m = in.readInt();
		int d = in.readInt();

		return new Employee(name, salary, y, m, d);
	}
}

class DataIO
{
	public static String readFixedString(int size, DataInput in) throws IOException
	{

		StringBuilder b = new StringBuilder(size);
		int i = 0;
		boolean more = true;

		while (more && i < size)
		{
			char ch = in.readChar();
			i++;
			if (ch == 0)
			{
				more = false;
			}
			else
			{
				b.append(ch);
			}
		}

		in.skipBytes(2 * (size - i));

		return b.toString();
	}

	public static void writeFixedString(String s, int size, DataOutput out) throws IOException
	{
		for (int i = 0; i < size; i++)
		{
			char ch = 0;
			if (i < s.length())
				ch = s.charAt(i);
			out.writeChar(ch);
		}
	}
}