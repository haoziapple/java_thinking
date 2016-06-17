/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:base.operators.Literals
 * @description:TODO
 * @date:2016-6-16 上午9:11:13
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-16     WangHao       v1.0.0        create
 *
 *
 */
package base.operators;

import static util.Print.*;

/**
 * @className:base.operators.Literals
 * @description:使用字符表示直接常量
 * @version:v1.0.0
 * @date:2016-6-16 上午9:12:19
 * @author:WangHao
 */
public class Literals
{
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		int i1 = 0x2f; // Hexadecimal (lowercase)
		print("i1: " + Integer.toBinaryString(i1));

		int i2 = 0X2F; // Hexadecimal(uppercase)
		print("i2: " + Integer.toBinaryString(i2));

		int i3 = 0177; // Octal(leading zero)
		print("i3: " + Integer.toBinaryString(i3));

		char c = 0xffff; // max char hex value
		print("c: " + c + "c in binary: " + Integer.toBinaryString(c));

		byte b = 0x7f; // max byte hex value
		print("b: " + b + " " + Integer.toBinaryString(b));

		short s = 0x7fff; // max short hex value
		print("s: " + s + " " + Integer.toBinaryString(s));

		long n1 = 200L; // long suffix
		long n2 = 200l; // long suffix (but can be confusing)
		long n3 = 200;

		float f1 = 1;
		float f2 = 1F; // float suffix
		float f3 = 1f; // float suffix

		double d1 = 1d; // double suffix
		double d2 = 1D; // double suffix
	}
}
