/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:util.DaemonThreadPoolExecutor
 * @description:TODO
 * @date:2016-3-19 下午3:06:05
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-19     WangHao       v1.0.0        create
 *
 *
 */
package util;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DaemonThreadPoolExecutor extends ThreadPoolExecutor
{
	public DaemonThreadPoolExecutor()
	{
		super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new DaemonThreadFactory());
	}

}
