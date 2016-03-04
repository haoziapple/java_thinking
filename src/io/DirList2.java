/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.DirList2
 * @description:TODO
 * @date:2016-2-19 下午2:20:41
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-19     WangHao       v1.0.0        create
 *
 *
 */
package io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

// Uses anonymous inner classes
// {Args: "D.*\.java"}
public class DirList2
{
	public static FilenameFilter filter(final String regex)
	{
		//Creation of anonymous inner class
		return new FilenameFilter() {
			private Pattern pattern = Pattern.compile(regex);
			public boolean accept(File dir, String name) {
				//return pattern.matcher(name).matches();
				return Pattern.matches(regex, name);
			}
		};
	}
	
	public static void main(String[] args) {
		File path = new File(".");
		String[] list;
		if(args.length == 0)
			list = path.list();
		else
			list = path.list(filter(args[0]));
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list)
			System.out.println(dirItem);
	}
}
