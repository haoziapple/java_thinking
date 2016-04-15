/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.net.InetAddressTest
 * @description:TODO
 * @date:2016-4-15 下午3:10:51
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-15     WangHao       v1.0.0        create
 *
 *
 */
package corejava.net;

import java.io.IOException;
import java.net.InetAddress;

/**
 * This program demonstrates the InetAddress class. Supply a host name as
 * command-line argument, or run without command-line arguments to see the
 * address of the local host.
 */
public class InetAddressTest
{
	public static void main(String[] args) throws IOException
	{
		if (args.length > 0)
		{
			String host = args[0];
			InetAddress[] addresses = InetAddress.getAllByName(host);
			for (InetAddress a : addresses)
				System.out.println(a);
		}
		else
		{
			InetAddress localHostAddress = InetAddress.getLocalHost();
			System.out.println(localHostAddress);
		}
	}
}
