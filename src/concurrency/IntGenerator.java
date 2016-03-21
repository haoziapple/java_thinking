/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.IntGenerator
 * @description:TODO
 * @date:2016-3-21 下午2:32:12
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
public abstract class IntGenerator
{
	private volatile boolean canceled = false;
	public abstract int next();
	
	//Allow this to be canceled:
	public void cancel()
	{
		canceled = true;
	}
	public boolean isCanceled()
	{
		return canceled;
	}

}
