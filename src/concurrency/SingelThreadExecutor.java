/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.SingelThreadExecutor
 * @description:TODO
 * @date:2016-3-18 上午11:15:07
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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingelThreadExecutor
{
	public static void main(String[] args)
	{
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for(int i=0; i<5; i++)
			exec.execute(new Liftoff());
		exec.shutdown();
	}
}
