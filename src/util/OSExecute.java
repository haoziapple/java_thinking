/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:util.OSExecute
 * @description:TODO
 * @date:2016-3-10 下午3:24:29
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-10     WangHao       v1.0.0        create
 *
 *
 */
package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//Run an operating system command
//and send the output to the console
public class OSExecute
{
	public static void command(String command) throws Exception
	{
		boolean err = false;
		try
		{
			Process process = new ProcessBuilder(command.split(" ")).start();
			BufferedReader results = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String s;
			while((s = results.readLine()) != null)
				System.out.println(s);
			BufferedReader errors = new BufferedReader(
					new InputStreamReader(process.getErrorStream()));
			
			//Report errors and return nonzero value
			//to calling process if there are problems:
			while((s = errors.readLine()) != null)
			{
				System.err.println(s);
				err = true;
			}
		} 
		catch(Exception e)
		{
			//Compensate for Windows 2000, which throws an exception for the default command line:
			if(!command.startsWith("CMD /C"))
				command("CMD /C " + command);
			else
				throw new RuntimeException(e);
		}
		if(err)
		{
			throw new Exception("Errors executing " + command);
		}
	}
}
