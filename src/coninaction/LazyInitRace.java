/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:coninaction.LazyInitRace
 * @description:TODO
 * @date:2016-5-16 下午4:33:34
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-5-16     WangHao       v1.0.0        create
 *
 *
 */
package coninaction;

/**
 * @className:coninaction.LazyInitRace
 * @description:延迟初始化中的竞态条件（不要这么做）
 * @version:v1.0.0
 * @date:2016-5-16 下午4:33:38
 * @author:WangHao
 */
// NotThreadSafe！
public class LazyInitRace
{
	private Object instance = null;

	public Object getInstance()
	{
		if (instance == null)
			instance = new Object();
		return instance;
	}
}
