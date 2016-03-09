/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:io.DirList
 * @description:TODO
 * @date:2016-2-19 下午2:01:50
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

// Display a directory listing using regular expression
// {Args: "D.*\.java"}
public class DirList
{
	public static void main(String[] args)
	{
		File path = new File(".");
		String[] list;
		if (args.length == 0)
			list = path.list();
		else
			list = path.list(new DirFilter(args[0]));
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for (String dirItem : list)
			System.out.println(dirItem);
	}
}

class DirFilter implements FilenameFilter
{
	private Pattern pattern;

	public DirFilter(String regex)
	{
		pattern = Pattern.compile(regex);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.io.FilenameFilter#accept(java.io.File, java.lang.String)
	 */
	@Override
	public boolean accept(File dir, String name)
	{
		// TODO Auto-generated method stub
		return pattern.matcher(name).matches();
	}

}
