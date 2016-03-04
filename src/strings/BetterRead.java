/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:strings.BetterRead
 * @description:TODO
 * @date:2016-2-14 下午1:25:37
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-14     WangHao       v1.0.0        create
 *
 *
 */
package strings;

import java.util.Scanner;

public class BetterRead
{
	public static void main(String[] args)
	{
		Scanner stdin = new Scanner(SimpleRead.input);
		System.out.println("What is your name?");
		String name = stdin.nextLine();
		System.out.println(name);

		System.out.println("How old? What is your favorite double?");
		System.out.println("(input: <age> <double>)");
		int age = stdin.nextInt();
		double fav = stdin.nextDouble();
		System.out.println(age);
		System.out.println(fav);
	}

}
