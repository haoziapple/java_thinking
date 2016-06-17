/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:base.operators.URShift
 * @description:TODO
 * @date:2016-6-17 上午10:54:18
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-17     WangHao       v1.0.0        create
 *
 *
 */
package base.operators;

import static util.Print.print;

/**
 * @className:base.operators.URShift
 * @description:Test of unsigned right shift 测试移位操作符
 * @version:v1.0.0
 * @date:2016-6-17 上午10:54:21
 * @author:WangHao
 */
public class URShift
{
	public static void main(String[] args)
	{
		int i = -1;
		print(Integer.toBinaryString(i));

		// 有符号右位移，若符号为正，在高位插入0
		// 若符号为负，在高位插入1

		// 无符号右移位，无论正负，都在高位插入0
		i >>>= 10;
		print(Integer.toBinaryString(i));

		long l = -1;
		print(Long.toBinaryString(l));
		l >>>= 10;
		print(Long.toBinaryString(l));

		// 对byte和short值进行右移位运算，结果可能不正确
		// 他们会先被转换为int，再进行右移操作，然后被截断，赋值给原来的类型
		short s = -1;
		print(Short.toString(s));
		print(Integer.toBinaryString(s));
		s >>>= 10;
		print(Short.toString(s));
		print(Integer.toBinaryString(s));

		byte b = -1;
		print(Byte.toString(b));
		print(Integer.toBinaryString(b));
		b >>>= 10;
		print(Byte.toString(b));
		print(Integer.toBinaryString(b));

		b = -1;
		print(Integer.toBinaryString(b >>> 10));
	}
}
