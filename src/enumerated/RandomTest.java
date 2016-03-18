/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:enumerated.RandomTest
 * @description:TODO
 * @date:2016-3-17 上午11:53:52
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-17     WangHao       v1.0.0        create
 *
 *
 */
package enumerated;

import util.Enums;

enum Activity{SITTING, LYING, STANDING, HOPPING, RUNNING, FALLING, FLYING}

public class RandomTest
{
	public static void main(String[] args)
	{
		for(int i = 0; i<20; i++)
			System.out.println(Enums.random(Activity.class));
	}
}
