/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.net.SocketTest
 * @description:TODO
 * @date:2016-4-15 上午11:22:03
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
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * This program makes a socket connection to the atomic
 * clock in Boulder, Colorado, and prints the time that the server sends.
 */
public class SocketTest
{
	public static void main(String[] args) throws IOException
	{
		Socket s=new Socket("time-A.timefreq.bldrdoc.gov", 13);
		InputStream inStream=s.getInputStream();
		Scanner in=new Scanner(inStream);
		
		while(in.hasNextLine())
		{
			String line=in.nextLine();
			System.out.println(line);
		}
	}

}
