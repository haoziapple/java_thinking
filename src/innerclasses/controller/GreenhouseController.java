/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:innerclasses.controller.GreenhouseController
 * @description:TODO
 * @date:2016-1-28 下午2:15:31
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

public class GreenhouseController
{
	public static void main(String[] args) {
		GreenhouseContorls gc = new GreenhouseContorls();
		//gc.addEvent(gc.new Bell(900));
		Event[] eventList = {
			gc.new LightOn(400),
			gc.new LightOff(400)
		};
		gc.addEvent(gc.new Restart(2000, eventList));
		if(args.length == 1)
			gc.addEvent(new GreenhouseContorls.Terminate(new Integer(args[0])));
		gc.run();
	}

}
