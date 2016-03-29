/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.ExceptionThread
 * @description:TODO
 * @date:2016-3-21 下午2:01:55
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-21     WangHao       v1.0.0        create
 *
 *
 */
package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//{ThrowsException}
public class ExceptionThread implements Runnable
{
	@Override
	public void run()
	{
		throw new RuntimeException();
	}
	public static void main(String[] args)
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionThread());
	}
}
