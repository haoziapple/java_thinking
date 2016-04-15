/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.net.server.ThreadedEchoServer
 * @description:TODO
 * @date:2016-4-15 下午3:43:09
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
 * This program implements a multithreaded server that listens to port 8189 and
 * echos back all client input.
 */
public class ThreadedEchoServer
{
	public static void main(String[] args)
	{
		try
		{
			int i = 1;
			ServerSocket s = new ServerSocket(8189);
			while (true)
			{
				Socket incoming = s.accept();
				System.out.println("Spawning " + i);
				Runnable r = new ThreadedEchoHandler(incoming);
				Thread t = new Thread(r);
				t.start();
				i++;
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}

class ThreadedEchoHandler implements Runnable
{
	private Socket incoming;

	public ThreadedEchoHandler(Socket i)
	{
		incoming = i;
	}

	@Override
	public void run()
	{
		try
		{
			InputStream inStream=incoming.getInputStream();
			OutputStream outStream=incoming.getOutputStream();
			
			Scanner in=new Scanner(inStream);
			PrintWriter out=new PrintWriter(outStream, true/*autoFlust*/);
			
			out.println("Hello! Enter BYE to exit.");
			//echo client input
			boolean done=false;
			while(!done&&in.hasNextLine())
			{
				String line=in.nextLine();
				out.println("Echo: "+line);
				if(line.trim().equals("BYE"))
					done=true;
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				incoming.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
