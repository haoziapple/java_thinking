/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:junit.MockSystemEnvironment
 * @description:TODO
 * @date:2016-6-14 下午3:26:38
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-14     WangHao       v1.0.0        create
 *
 *
 */
package junit;

/**
 * @className:junit.MockSystemEnvironment
 * @description:mock的实现
 * @version:v1.0.0
 * @date:2016-6-14 下午3:26:44
 * @author:WangHao
 */
public class MockSystemEnvironment implements Environmental
{

	@Override
	public long getTime()
	{
		return current_time;
	}

	private long current_time;

	// 提供set方法以控制对象状态
	public void setTime(long aTime)
	{
		current_time = aTime;
	}
}
