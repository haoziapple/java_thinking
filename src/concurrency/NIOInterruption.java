/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.NIOInterruption
 * @description:TODO
 * @date:2016-3-23 下午1:35:27
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-23     WangHao       v1.0.0        create
 *
 *
 */
package concurrency;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedByInterruptException;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

//Interrupting a blocked NIO channel

class NIOBlocked implements Runnable
{
	private final SocketChannel sc;

	public NIOBlocked(SocketChannel sc)
	{
		this.sc = sc;
	}

	@Override
	public void run()
	{
		try
		{
			System.out.println("Waiting for read() in " + this);
			sc.read(ByteBuffer.allocate(1));
		}
		catch (ClosedByInterruptException e)
		{
			System.out.println("ClosedByInterruptException");
		}
		catch(AsynchronousCloseException e)
		{
			System.out.println("AsynchronousCloseException");
		}
		catch (IOException e)
		{
			throw new RuntimeException(e);
		}
		System.out.println("Exiting NIOBlocked.run() " + this);
	}
}

public class NIOInterruption
{
	public static void main(String[] args) throws Exception
	{
		ExecutorService exec = Executors.newCachedThreadPool();
		ServerSocket server = new ServerSocket(8080);
		InetSocketAddress isa = new InetSocketAddress("localhost", 8080);
		SocketChannel sc1 = SocketChannel.open(isa);
		SocketChannel sc2 = SocketChannel.open(isa);
		Future<?> f = exec.submit(new NIOBlocked(sc1));
		exec.execute(new NIOBlocked(sc2));
		exec.shutdown();
		TimeUnit.SECONDS.sleep(3);

		// Produce an interrupt via cancel:
		f.cancel(true);
		TimeUnit.SECONDS.sleep(3);
		// Release the block by closing the channel:
		sc2.close();
	}
}
