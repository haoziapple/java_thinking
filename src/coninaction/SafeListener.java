/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:coninaction.SafeListener
 * @description:TODO
 * @date:2016-5-17 下午4:54:31
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
 * @className:coninaction.SafeListener
 * @description:使用工厂方法来防止this引用在构造过程中逸出
 * @version:v1.0.0
 * @date:2016-5-17 下午4:54:34
 * @author:WangHao
 */
public class SafeListener
{
	private final EventListener listener;

	private SafeListener()
	{
		listener = new EventListener()
		{
			@SuppressWarnings("unused")
			public void onEvent(Event e)
			{
				// doSomething(e);
			}
		};
	}

	public static SafeListener newInstance(EventSource source)
	{
		SafeListener safe = new SafeListener();
		source.registerListener(safe.listener);
		return safe;
	}

}

class EventSource
{

	
	 /**
	 * @Description:
	 * @param listener
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016-5-17 下午5:04:12
	 */
	public void registerListener(EventListener listener)
	{
		// TODO Auto-generated method stub
		
	}

}
