/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:containers.Test
 * @description:TODO
 * @date:2016-3-7 下午7:24:11
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-7     WangHao       v1.0.0        create
 *
 *
 */
package containers;
//Framework for performing timed tests of containers.
public abstract class Test<C>
{
	String name;
	public Test(String name){this.name = name;}
	//Override this method for different tests.
	//Returns actual number of repetitions of test.
	abstract int test(C container, TestParam tp);
}
