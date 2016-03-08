/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:containers.Prediction
 * @description:TODO
 * @date:2016-3-7 下午3:01:57
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

import java.util.Random;

public class Prediction
{
	private static Random rand = new Random(47);
	private boolean shadow = rand.nextDouble() > 0.5;
	public String toString()
	{
		if(shadow)
			return "Six more weeks of Winter!";
		else
			return "Early Spring!";
	}
}
