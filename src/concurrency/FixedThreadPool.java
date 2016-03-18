/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.FixedThreadPool
 * @description:TODO
 * @date:2016-3-18 上午11:02:34
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

public class FixedThreadPool
{
	public static void main(String[] args)
	{
		//Constructor argument is number of threads:
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i=0; i<5; i++)
			exec.execute(new Liftoff());
		exec.shutdown();
	}

}
