/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:innerclasses.Event
 * @description:TODO
 * @date:2016-1-28 下午1:05:35
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-1-28     WangHao       v1.0.0        create
 *
 *
 */
package innerclasses;
public abstract class Event
{
	private long eventTime;
	protected final long delayTime;
	public Event(long delayTime) {
		this.delayTime = delayTime;
		start();
	}
	
	//想重复事件，可在action中调用start方法
	public void start() {
		//当前时间 + 系统时间 = 事件触发时间
		eventTime = System.nanoTime() + delayTime;
	}
	
	//ready()告诉你何时可以运行action()方法
	public boolean ready() {
		return System.nanoTime() >= eventTime;
	}

	public abstract void action();
}
