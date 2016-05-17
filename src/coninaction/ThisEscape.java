/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:coninaction.ThisEscape
 * @description:TODO
 * @date:2016-5-17 下午4:49:24
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-5-17     WangHao       v1.0.0        create
 *
 *
 */
package coninaction;

import java.awt.Event;
import java.util.EventListener;

/**
 * @className:coninaction.ThisEscape
 * @description:隐式地使this引用逸出（不要这么做）
 * @version:v1.0.0
 * @date:2016-5-17 下午4:49:26
 * @author:WangHao
 */
public class ThisEscape
{
	public ThisEscape(EventSource source)
	{
		source.registerListener(new EventListener()
		{
			@SuppressWarnings("unused")
			public void onEvent(Event e)
			{
				// doSomething(e);
			}
		});
	}
}
