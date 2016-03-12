/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:enumerated.EnumClass
 * @description:TODO
 * @date:2016-3-12 下午2:03:11
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-12     WangHao       v1.0.0        create
 *
 *
 */
package enumerated;
//Capabilities of the Enum class
enum Shrubbery {GROUND, CRAWLING, HANGING}

public class EnumClass
{
	public static void main(String[] args)
	{
		for(Shrubbery s : Shrubbery.values())
		{
			System.out.println(s + " ordinal: " + s.ordinal());
			System.out.print(s.compareTo(Shrubbery.CRAWLING) + " ");
			System.out.print(s.equals(Shrubbery.CRAWLING) + " ");
			System.out.println(s == Shrubbery.CRAWLING);
			System.out.println(s.getDeclaringClass());
			System.out.println(s.name());
			System.out.println("-----------------------------");
		}
		//Produce an enum value from a string name:
		for(String s : "HANGING CRAWLING GROUND".split(" "))
		{
			Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
			System.out.println(shrub);
		}
	}
}
