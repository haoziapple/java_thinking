/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:base.operators.EqualsMethod
 * @description:TODO
 * @date:2016-6-15 下午5:27:57
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-15     WangHao       v1.0.0        create
 *
 *
 */
package base.operators;

/**
 * @className:base.operators.EqualsMethod
 * @description:测试对象的equals方法
 * @version:v1.0.0
 * @date:2016-6-15 下午5:28:13
 * @author:WangHao
 */
public class EqualsMethod
{
	public static void main(String[] args)
	{
		Integer n1 = new Integer(47);
		Integer n2 = new Integer(47);

		System.out.println(n1.equals(n2));
		System.out.println(n1 == n2);
	}
}
