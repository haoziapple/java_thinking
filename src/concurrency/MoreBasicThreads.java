/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.MoreBasicThreads
 * @description:TODO
 * @date:2016-3-18 上午10:45:43
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-18     WangHao       v1.0.0        create
 *
 *
 */
package concurrency;

//Adding more threads.
public class MoreBasicThreads
{
	public static void main(String[] args)
	{
		for(int i=0; i<5; i++)
			new Thread(new Liftoff()).start();
		System.out.println("Waiting for Liftoff");
	}
}
