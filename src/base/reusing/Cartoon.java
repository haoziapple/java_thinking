/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:base.reusing.Cartoon
 * @description:TODO
 * @date:2016-6-20 下午3:57:17
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-20     WangHao       v1.0.0        create
 *
 *
 */
package base.reusing;

import static util.Print.*;

/**
 * @className:base.reusing.Cartoon
 * @description:Constructor calls during inheritance
 * @version:v1.0.0
 * @date:2016-6-20 下午3:57:23
 * @author:WangHao
 */

class Art
{
	Art()
	{
		print("Art constructor");
	}
}

class Drawing extends Art
{
	Drawing()
	{
		print("Drawing constructor");
	}
}

public class Cartoon extends Drawing
{
	public Cartoon()
	{
		print("Cartoon construcor");
	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Cartoon x = new Cartoon();
	}
}
