/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.stringtest.StringTest
 * @description:TODO
 * @date:2016-6-27 下午5:20:36
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-27     WangHao       v1.0.0        create
 *
 *
 */
package haozijava.stringtest;

/**
 * @className:haozijava.stringtest.StringTest
 * @description:测试String类型
 * @version:v1.0.0
 * @date:2016-6-27 下午5:20:48
 * @author:WangHao
 */
public class StringTest
{
	public static void main(String[] args)
	{
		String a = "abc";
		String b = "def";

		String c = a + b;
		String d = "abc" + "def";

		String e = new String("abc");

		System.out.println(a == e);
		System.out.println(a.equals(e));
		System.out.println(a == "abc");
		System.out.println(a == e.intern());
		System.out.println(c == "abcdef");
		System.out.println(d == "abcdef");
	}
}
