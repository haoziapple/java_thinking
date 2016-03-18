/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.CachedThreadPool
 * @description:TODO
 * @date:2016-3-18 上午10:51:13
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

public class CachedThreadPool
{
	public static void main(String[] args)
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0; i<5; i++)
			exec.execute(new Liftoff());
		exec.shutdown();
	}
}
