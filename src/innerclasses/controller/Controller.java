/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:innerclasses.controller.Controller
 * @description:TODO
 * @date:2016-1-28 下午1:23:39
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

import java.util.ArrayList;
import java.util.List;

public class Controller
{
	private List<Event> eventList = new ArrayList<Event>();
	public void addEvent(Event c) {
		eventList .add(c);
	}
	public void run() {
		while (eventList.size() > 0)
			for (Event e : new ArrayList<Event>(eventList))
				if (e.ready()) {
					System.out.println(e);
					e.action();
					eventList.remove(e);
				}
	}
}
