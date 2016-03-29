/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.NaiveExceptionHandling
 * @description:TODO
 * @date:2016-3-21 下午2:04:56
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
public class NaiveExceptionHandling
{
	public static void main(String[] args)
	{
		try
		{
			ExecutorService exec = Executors.newCachedThreadPool();
			exec.execute(new ExceptionThread());
		}
		catch(RuntimeException ue)
		{
			//This statement will NOT execute!
			System.out.println("Exception has been handled!");
		}
	}
}
