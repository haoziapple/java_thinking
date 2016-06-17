/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:base.operators.Exponents
 * @description:TODO
 * @date:2016-6-17 上午10:14:13
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

/**
 * @className:base.operators.Exponents
 * @description:指数表示方法
 * @version:v1.0.0
 * @date:2016-6-17 上午10:14:19
 * @author:WangHao
 */
public class Exponents
{
	public static void main(String[] args)
	{
		// Uppercase and lowercase 'e' are the same：
		float expFloat = 1.39e-43f;
		System.out.println(expFloat);
		expFloat = 1.39E-43f;
		System.out.println(expFloat);

		double expDouble = 47e47d; // 'd' is optional
		double expDouble2 = 47e47; // Automatically double
		System.out.println(expDouble);
		System.out.println(expDouble2);
	}
}
