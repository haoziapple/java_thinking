/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:enumerated.EnumMaps
 * @description:TODO
 * @date:2016-3-17 下午2:04:34
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-17     WangHao       v1.0.0        create
 *
 *
 */
package enumerated;

//Basics of EnumMaps.
import static enumerated.AlarmPoints.*;
import java.util.EnumMap;
import java.util.Map;

interface Command
{
	void action();
}

public class EnumMaps
{
	public static void main(String[] args)
	{
		EnumMap<AlarmPoints, Command> em = new EnumMap<AlarmPoints, Command>(AlarmPoints.class);
		em.put(KITCHEN, new Command()
		{
			@Override
			public void action()
			{
				System.out.println("Kitchen fire!");
			}
		});
		em.put(BATHROOM, new Command()
		{
			@Override
			public void action()
			{
				System.out.println("Bathroom alert!");
			}
		});
		for(Map.Entry<AlarmPoints, Command> e : em.entrySet())
		{
			System.out.print(e.getKey() + ": ");
			e.getValue().action();
		}
		try
		//If there's no value for a particular key:
		{
			em.get(UTILITY).action();
		} catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
