/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.reflection.ReflectionTest
 * @description:TODO
 * @date:2016-4-5 下午2:07:08
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
package corejava.reflection;

import static java.lang.System.out;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * This program uses reflection to print all features of a class.
 */
public class ReflectionTest
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
	{
		// read class name from command line args or user input
		String name;
		if (args.length > 0)
			name = args[0];
		else
		{
			Scanner in = new Scanner(System.in);
			out.println("Enter class name (e.g. java.util.Date): ");
			name = in.next();
		}
		try
		{
			// print class name and superclass name(if !=Object)
			Class cl = Class.forName(name);
			Class supercl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			if (modifiers.length() > 0)
				out.print(modifiers + " ");
			out.print("class " + name);
			if (supercl != null && supercl != Object.class)
				out.print(" extends " + supercl.getName());
			out.print("\n{\n");
			printConstructors(cl);
			out.println();
			printMethods(cl);
			out.println();
			printFields(cl);
			out.println("}");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		System.exit(0);
	}

	/**
	 * Prints all constructors of a class
	 */
	@SuppressWarnings("rawtypes")
	public static void printConstructors(Class cl)
	{
		Constructor[] constructors = cl.getConstructors();
		for (Constructor c : constructors)
		{
			String name = c.getName();
			System.out.print(" ");
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length() > 0)
				out.print(modifiers + " ");
			out.print(name + "(");

			// Print parameter types
			Class[] paramTypes = c.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++)
			{
				if (j > 0)
					System.out.print(", ");
				out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}

	/**
	 * Prints all methods of a class
	 */
	@SuppressWarnings("rawtypes")
	public static void printMethods(Class cl)
	{
		Method[] methods = cl.getDeclaredMethods();
		for (Method m : methods)
		{
			Class retType = m.getReturnType();
			String name = m.getName();

			System.out.print(" ");
			// print modifiers, return type and method name
			String modifiers = Modifier.toString(m.getModifiers());
			if (modifiers.length() > 0)
				out.print(modifiers + " ");
			out.print(retType.getName() + " " + name + "(");

			// print parameter types
			Class[] paramTypes = m.getParameterTypes();
			for (int j = 0; j < paramTypes.length; j++)
			{
				if (j > 0)
					System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}

	@SuppressWarnings("rawtypes")
	public static void printFields(Class cl)
	{
		Field[] fields = cl.getDeclaredFields();
		for (Field f : fields)
		{
			Class type = f.getType();
			String name = f.getName();
			System.out.print(" ");
			String modifiers = Modifier.toString(f.getModifiers());
			if (modifiers.length() > 0)
				System.out.print(modifiers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}
	}
}
