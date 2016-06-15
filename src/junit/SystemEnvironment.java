/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:junit.SystemEnvironment
 * @description:TODO
 * @date:2016-6-14 下午3:24:41
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
 * @className:junit.SystemEnvironment
 * @description:真实的代码实现
 * @version:v1.0.0
 * @date:2016-6-14 下午3:25:53
 * @author:WangHao
 */
public class SystemEnvironment implements Environmental
{
	@Override
	public long getTime()
	{
		return System.currentTimeMillis();
	}
	// other methods ...

}
