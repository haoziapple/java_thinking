/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.streamio.ObjectStreamTest
 * @description:TODO
 * @date:2016-4-11 下午1:04:49
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-11     WangHao       v1.0.0        create
 *
 *
 */
package corejava.streamio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest
{
	public static void main(String[] args) throws IOException,ClassNotFoundException
	{
		Employee harry=new Employee("Harry Hacker", 50000, 1989, 10, 1);
		Employee tony = new Employee("Tony Tester", 40000, 1990, 3, 15);
		Employee carl = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		
		Employee[] staff=new Employee[3];
		staff[0]=carl;
		staff[1]=harry;
		staff[2]=tony;
		
		//save all employee records to the file employee.dat
		ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream("employee.dat"));
		out.writeObject(staff);
		
		ObjectInputStream in=new ObjectInputStream(new FileInputStream("employee.dat"));
		//retieve all records into a new array
		Employee[] newStaff=(Employee[]) in.readObject();
		
		//raise salary
		newStaff[1].setSalary("20");
		
		//print the newly read employee records
		for(Employee e:newStaff)
			System.out.println(e);
	}

}
