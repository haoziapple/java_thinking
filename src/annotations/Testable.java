/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:annotations.Testable
 * @description:TODO
 * @date:2016-3-17 下午4:16:14
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
package annotations;

import atunit.Test;

public class Testable
{
	public void execute()
	{
		System.out.println("Executing...");
	}
	@Test
	void testExecute()
	{
		execute();
	}
}
