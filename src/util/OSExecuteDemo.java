/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:util.OSExecuteDemo
 * @description:TODO
 * @date:2016-3-10 下午3:59:01
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
public class OSExecuteDemo
{
	public static void main(String[] args)
	{
		try
		{
			OSExecute.command("javap DirList");
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
