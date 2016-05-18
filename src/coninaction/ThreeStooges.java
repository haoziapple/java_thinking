/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:coninaction.ThreeStooges
 * @description:TODO
 * @date:2016-5-18 下午7:40:05
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-5-18     WangHao       v1.0.0        create
 *
 *
 */
package coninaction;

import java.util.HashSet;
import java.util.Set;

/**
 * @className:coninaction.ThreeStooges
 * @description:在可变对象基础上构建的不可变类
 * @version:v1.0.0
 * @date:2016-5-18 下午7:40:09
 * @author:WangHao
 */
public class ThreeStooges
{
	private final Set<String> stooges = new HashSet<String>();

	public ThreeStooges()
	{
		stooges.add("Moe");
		stooges.add("Larry");
		stooges.add("Curly");
	}

	public boolean isStooge(String name)
	{
		return stooges.contains(name);
	}

}
