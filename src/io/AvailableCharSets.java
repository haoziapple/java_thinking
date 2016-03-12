/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.AvailableCharSets
 * @description:TODO
 * @date:2016-3-11 下午1:52:00
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-11     WangHao       v1.0.0        create
 *
 *
 */
package io;

import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.SortedMap;

//Displays Charsets and aliases
public class AvailableCharSets
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
	{
		SortedMap<String, Charset> charSets = Charset.availableCharsets();
		Iterator<String> it = charSets.keySet().iterator();
		while(it.hasNext())
		{
			String csName = it.next();
			System.out.print(csName);
			
			Iterator aliases = charSets.get(csName).aliases().iterator();
			if(aliases.hasNext())
				System.out.print(": ");
			while(aliases.hasNext())
			{
				System.out.print(aliases.next());
				if(aliases.hasNext())
					System.out.print(", ");
			}
			System.out.println();
		}
	}
}
