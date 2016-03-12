/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.PreferencesDemo
 * @description:TODO
 * @date:2016-3-12 下午1:34:53
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-12     WangHao       v1.0.0        create
 *
 *
 */
package io;

import java.util.prefs.Preferences;

public class PreferencesDemo
{
	public static void main(String[] args) throws Exception
	{
		Preferences prefs = Preferences.userNodeForPackage(PreferencesDemo.class);
		prefs.put("Location", "Oz");
		prefs.put("Footwear", "Ruby Slippers");
		prefs.putInt("Companions", 4);
		prefs.putBoolean("Are there witches?", true);

		int usageCount = prefs.getInt("UsageCount", 0);
		usageCount++;
		prefs.putInt("UsageCount", usageCount);
		for (String key : prefs.keys())
			System.out.println(key + ": " + prefs.get(key, null));
		// You must always provide a default value:
		System.out.println("How many companions does Dorothy have? " + prefs.getInt("Companions", 0));
	}
}
