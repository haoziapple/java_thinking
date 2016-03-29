/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:util.DaemonThreadFactory
 * @description:TODO
 * @date:2016-3-19 下午1:23:23
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

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory
{
	@Override
	public Thread newThread(Runnable r)
	{
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}

}
