/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:innerclasses.holding.EnvironmentVar
 * @description:TODO
 * @date:2016-2-1 上午10:33:49
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-1     WangHao       v1.0.0        create
 *
 *
 */
package innerclasses.holding;

import java.util.Map;

public class EnvironmentVar
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
	{
		for(Map.Entry entry : System.getenv().entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
	}

}
