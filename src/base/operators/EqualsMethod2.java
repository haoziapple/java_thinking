/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:base.operators.EqualMethod2
 * @description:TODO
 * @date:2016-6-15 下午5:54:43
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
 * @className:base.operators.EqualsMethod2
 * @description:Default equals() does not compare contents
 * @version:v1.0.0
 * @date:2016-6-15 下午5:55:06
 * @author:WangHao
 */

class Value
{
	int i;
}

public class EqualsMethod2
{
	public static void main(String[] args)
	{
		Value v1 = new Value();
		Value v2 = new Value();
		v1.i = v2.i = 100;
		System.out.println(v1.equals(v2));
	}
}
