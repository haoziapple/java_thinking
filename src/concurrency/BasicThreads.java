/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.BasicThreads
 * @description:TODO
 * @date:2016-3-18 上午10:41:49
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
//The most basic use of the Thread class.
public class BasicThreads
{
	public static void main(String[] args)
	{
		Thread t = new Thread(new Liftoff());
		t.start();
		System.out.println("Waiting for Liftoff");
		System.out.println(System.getProperty("user.dir"));
	}

}
