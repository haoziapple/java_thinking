/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.net.server.EchoServer
 * @description:TODO
 * @date:2016-4-15 下午3:23:39
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
package corejava.net.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * This program implements a simple server that listens to port 8189 and echos
 * back all client input.
 */
public class EchoServer
{
	public static void main(String[] args) throws IOException
	{
		// establish server socket
		ServerSocket s = new ServerSocket(8189);

		// wait for client connection
		Socket incoming = s.accept();
		InputStream inStream = incoming.getInputStream();
		OutputStream outStream = incoming.getOutputStream();

		Scanner in = new Scanner(inStream);
		PrintWriter out = new PrintWriter(outStream, true /* autoFlush */);

		out.println("Hello! Enter BYE to exit.");

		// echo client input
		boolean done = false;
		while (!done && in.hasNextLine())
		{
			String line = in.nextLine();
			out.println("Echo: " + line);
			if (line.trim().equals("BYE"))
				done = true;
		}
	}

}
