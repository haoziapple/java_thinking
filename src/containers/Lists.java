/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:containers.Lists
 * @description:TODO
 * @date:2016-3-3 下午2:30:47
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-3     WangHao       v1.0.0        create
 *
 *
 */
package containers;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Lists
{
	private static boolean b;
	private static String s;
	private static int i;
	private static Iterator<String> it;
	private static ListIterator<String> lit;
	public static void basicTest(List<String> a)
	{
		a.add(1, "x"); //add at location 1
		a.add("x"); //add at end
	}

}
