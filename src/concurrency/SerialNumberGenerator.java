/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.SerialNumberGenerator
 * @description:TODO
 * @date:2016-3-22 上午11:09:44
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-22     WangHao       v1.0.0        create
 *
 *
 */
package concurrency;
public class SerialNumberGenerator
{
	private static volatile int serialNumber = 0;
	public static int nextSerialNubmer()
	{
		return serialNumber++; //Not thread-safe
	}
}
