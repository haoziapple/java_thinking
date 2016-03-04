/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:typeinfo.ShowMethods
 * @description:TODO
 * @date:2016-2-15 下午1:14:21
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-15     WangHao       v1.0.0        create
 *
 *
 */
package typeinfo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

//{Args: typeinfo.ShowMethods}
//Using reflection to show all the methods of a class
//even if the methods are defined in the base class
public class ShowMethods
{
	private static String usage = 
			"usage:\n" +
			"To show all methods in class or:\n" +
			"ShowMethods qualified class name word\n" +
			"To search for methods involving word";
	private static Pattern p = Pattern.compile("\\w+\\.");
	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args)
	{
		if(args.length < 1) {
			SweetShop.print(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class<?> c = Class.forName(args[0]);
			Method[] methods = c.getMethods();
			Constructor[] ctors = c.getConstructors();
			if(args.length == 1) {
				for(Method method : methods)
//					SweetShop.print(
//							p.matcher(method.toString()).replaceAll(""));
					SweetShop.print(method.toString());
				for(Constructor ctor : ctors)
					SweetShop.print(
							p.matcher(ctor.toString()).replaceAll(""));
				lines = methods.length + ctors.length;
			} else {
				for(Method method : methods)
					if(method.toString().indexOf(args[1]) != -1) {
						SweetShop.print(
								p.matcher(method.toString()).replaceAll(""));
						lines++;
					}
				for(Constructor ctor : ctors)
					if(ctor.toString().indexOf(args[1]) != -1) {
						SweetShop.print(
								p.matcher(ctor.toString()).replaceAll(""));
						lines++;
					}
			}
		} catch (ClassNotFoundException e) {
			SweetShop.print("No such class: " + e);
		}
			
	}

}
