/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:util.PPrint
 * @description:TODO
 * @date:2016-2-19 下午3:16:34
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-19     WangHao       v1.0.0        create
 *
 *
 */
package util;

import java.util.Arrays;
import java.util.Collection;

//Pretty-printer for collections
public class PPrint
{
	public static String pformat(Collection<?> c)
	{
		if (c.size() == 0)
			return "[]";
		StringBuilder result = new StringBuilder("[");
		for (Object elem : c)
		{
			if (c.size() != 1)
				result.append("\n ");
			result.append(elem);
		}
		if (c.size() != 1)
			result.append("\n");
		result.append("]");
		return result.toString();
	}

	public static void pprint(Collection<?> c)
	{
		System.out.println(pformat(c));
	}

	public static void pprint(Object[] c)
	{
		System.out.println(pformat(Arrays.asList(c)));
	}
} // /:~
