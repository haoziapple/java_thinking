/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:enumerated.OzWitch
 * @description:TODO
 * @date:2016-3-14 上午10:14:05
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-14     WangHao       v1.0.0        create
 *
 *
 */
package enumerated;
//The witches in the land of Oz.
public enum OzWitch
{
	//Instance must be defined first, before methods:
	WEST("Miss Gulch, aka the Wicked of the West"),
	NORTH("Glinda, the Good Witch of the North"),
	SOUTH("Good by inference, but missing");
	
	private String description;
	
	//Constructor must be package or private access:
	private OzWitch(String description)
	{
		this.description = description;
	}
	public String getDescription()
	{
		return description;
	}
	public static void main(String[] args)
	{
		for(OzWitch witch : OzWitch.values())
			System.out.println(witch + ": " + witch.getDescription());
	}
}
