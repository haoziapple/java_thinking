/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:innerclasses.controller.GreenhouseContorls
 * @description:TODO
 * @date:2016-1-28 下午1:36:00
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
package innerclasses.controller;

import innerclasses.Event;

public class GreenhouseContorls extends Controller
{
	@SuppressWarnings("unused")
	//控制灯的开关
	private boolean light = false;
	public class LightOn extends Event {
		public LightOn(long delayTime) {
			super(delayTime);
		}
		public void action() {
			light = true;
		}
		public String toString() {return "Light is on";}
	}
	
	public class LightOff extends Event {
		public LightOff(long delayTime) {super(delayTime);}
		public void action() {
			light = false;
		}
		public String toString() {return "Light is off";}
	}
	
	//action方法在eventList中添加了一个新的Bell事件
	public class Bell extends Event {
		public Bell(long delayTime) {super(delayTime);}
		public void action() {
			addEvent(new Bell(delayTime));
		}
		public String toString() {return "Bing!";}
	}
	
	public class Restart extends Event {
		private Event[] eventList;
		public Restart(long delayTime, Event[] eventList) {
			super(delayTime);
			this.eventList = eventList;
			for (Event e : eventList)
				addEvent(e);
		}
		public void action() {
			for (Event e : eventList) {
				e.start(); //Rerun each event
				addEvent(e);
			}
		}
		public String toString() {
			return "Restarting system";
		}
	}

	public static class Terminate extends Event {
		public Terminate(long delayTime) {
			super(delayTime);
		}
		public void action() {System.exit(0);}
		public String toString() {return "Terminating";}
	}
}
