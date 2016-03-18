/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:enumerated.SecurityCategory
 * @description:TODO
 * @date:2016-3-17 下午1:11:14
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

import util.Enums;

//More succinct subcategorization of enums.
public enum SecurityCategory
{
	STOCK(Security.Stock.class), BOND(Security.Bond.class);
	Security[] values;
	SecurityCategory(Class<? extends Security> kind)
	{
		values = kind.getEnumConstants();
	}
	interface Security
	{
		enum Stock implements Security{
			SHORT, LONG, MARGIN
		}
		enum Bond implements Security{
			MUNICIPAL, JUNK
		}
	}
	public Security randomSelection()
	{
		return Enums.random(values);
	}
	public static void main(String[] args)
	{
		for(int i=0; i<10; i++)
		{
			SecurityCategory category = Enums.random(SecurityCategory.class);
			System.out.println(category + ": " + category.randomSelection());
		}
	}

}
