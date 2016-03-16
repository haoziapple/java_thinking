/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:util.Enums
 * @description:TODO
 * @date:2016-3-14 上午11:03:53
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-14     WangHao       v1.0.0        create
 *
 *
 */
package util;

import java.util.Random;

public class Enums
{
	private static Random rand = new Random(47);
	public static <T extends Enum<T>> T random(Class<T> ec)
	{
		return random(ec.getEnumConstants());
	}
	public static <T> T random(T[] values)
	{
		return values[rand.nextInt(values.length)];
	}
}
