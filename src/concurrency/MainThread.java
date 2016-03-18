/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.MainThread
 * @description:TODO
 * @date:2016-3-18 上午10:39:32
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
public class MainThread
{
	public static void main(String[] args)
	{
		Liftoff launch = new Liftoff();
		launch.run();
	}
}
