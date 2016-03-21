/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.SettingDefaultHandler
 * @description:TODO
 * @date:2016-3-21 下午2:28:27
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

public class SettingDefaultHandler
{
	public static void main(String[] args)
	{
		Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionThread());
	}
}
