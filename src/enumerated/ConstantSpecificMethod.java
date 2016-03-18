/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:enumerated.ConstantSpecificMethod
 * @description:TODO
 * @date:2016-3-17 下午2:26:47
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

import java.text.DateFormat;
import java.util.Date;

public enum ConstantSpecificMethod
{
	DATE_TIME
	{
		String getInfo()
		{
			return DateFormat.getDateInstance().format(new Date());
		}
	},
	CLASSPATH
	{
		String getInfo()
		{
			return System.getenv("CLASSPATH");
		}
	},
	VERSION
	{
		String getInfo()
		{
			return System.getProperty("java.version");
		}
	};
	abstract String getInfo();
	
	public static void main(String[] args)
	{
		for(ConstantSpecificMethod csm : values())
			System.out.println(csm.getInfo());
	}
}
