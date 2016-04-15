/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.net.InterruptibleSocketTest
 * @description:TODO
 * @date:2016-4-15 下午4:11:15
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

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * This program show how to interrupt a socket channel.
 */
public class InterruptibleSocketTest
{

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				JFrame frame = new InterruptibleSocketFrame();
				frame.setTitle("InterruptibleSocketTest");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class InterruptibleSocketFrame extends JFrame
{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static final int TEXT_ROWS = 20;
	public static final int TEXT_COLUMNS = 60;

	private Scanner in;
	private JButton interruptibleButton;
	private JButton blockingButton;
	private JButton cancelButton;
	private JTextArea messages;
	private TestServer server;
	private Thread connectThread;

	public InterruptibleSocketFrame()
	{
		JPanel northPanel = new JPanel();
		add(northPanel, BorderLayout.NORTH);

		messages = new JTextArea(TEXT_ROWS, TEXT_COLUMNS);
		add(new JScrollPane(messages));

		interruptibleButton = new JButton("Interruptible");
		blockingButton = new JButton("Blocking");
		northPanel.add(interruptibleButton);
		northPanel.add(blockingButton);

		interruptibleButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				interruptibleButton.setEnabled(false);
				blockingButton.setEnabled(false);
				cancelButton.setEnabled(true);
				connectThread = new Thread(new Runnable()
				{
					@Override
					public void run()
					{
						try
						{
							connectInterruptibly();
						}
						catch (IOException e)
						{
							messages.append("\nInterruptibleSocketTest.connectInterruptibly: " + e);
						}
					}
				});
				connectThread.start();
			}
		});

		blockingButton.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent event)
			{
				interruptibleButton.setEnabled(false);
				blockingButton.setEnabled(false);
				cancelButton.setEnabled(true);
				connectThread = new Thread(new Runnable()
				{

					@Override
					public void run()
					{
						try
						{
							connectBlocking();
						}
						catch (IOException e)
						{
							messages.append("\nInterruptibleSocketTest.connectBlocking: " + e);
						}
					}

				});
				connectThread.start();
			}
		});

		cancelButton = new JButton("Cancel");
		cancelButton.setEnabled(false);
		northPanel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent event)
			{
				connectThread.interrupt();
				cancelButton.setEnabled(false);
			}
		});
		server = new TestServer();
		new Thread(server).start();
		this.pack();
	}

	/**
	 * Connects to the test server, using interruptible I/O
	 */
	public void connectInterruptibly() throws IOException
	{
		messages.append("Interruptible:\n");
		SocketChannel channel = SocketChannel.open(new InetSocketAddress("localhost", 8189));
		in = new Scanner(channel);
		while (!Thread.currentThread().isInterrupted())
		{
			messages.append("Reading ");
			if (in.hasNextLine())
			{
				String line = in.nextLine();
				messages.append(line);
				messages.append("\n");
			}
		}

		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				messages.append("Channel cloesd\n");
				interruptibleButton.setEnabled(true);
				blockingButton.setEnabled(true);
			}
		});
	}

	/**
	 * Connects to the test server, using blocking I/O
	 */
	public void connectBlocking() throws IOException
	{
		messages.append("Blocking:\n");
		Socket sock = new Socket("localhost", 8189);
		in = new Scanner(sock.getInputStream());
		while (!Thread.currentThread().isInterrupted())
		{
			messages.append("Reading ");
			if (in.hasNextLine())
			{
				String line = in.nextLine();
				messages.append(line);
				messages.append("\n");
			}
		}
		EventQueue.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				messages.append("Socket closed\n");
				interruptibleButton.setEnabled(true);
				blockingButton.setEnabled(true);
			}
		});
	}

}

/**
 * A multithreaded server that listens to port 8189 and sends numbers to client.
 * simulating a hanging server after 10 numbers
 */
class TestServer implements Runnable
{
	@Override
	public void run()
	{
		try
		{
			ServerSocket s = new ServerSocket(8189);

			while (true)
			{
				Socket incoming = s.accept();
				Runnable r = new TestServerHandler(incoming);
				Thread t = new Thread(r);
				t.start();
			}
		}
		catch (IOException e)
		{
			System.out.println("\nTestServer.run: " + e);
			// messages.append("\nTestServer.run: " + e);
		}
	}
}

class TestServerHandler implements Runnable
{
	private Socket incoming;
	private int counter;

	public TestServerHandler(Socket i)
	{
		incoming = i;
	}

	@Override
	public void run()
	{
		try
		{
			try
			{
				OutputStream outStream = incoming.getOutputStream();
				PrintWriter out = new PrintWriter(outStream, true/* autoFlust */);
				while (counter < 100)
				{
					counter++;
					if (counter <= 10)
						out.println(counter);
					Thread.sleep(100);
				}
			}
			finally
			{
				incoming.close();
				System.out.println("Closing server\n");
				// messages.append("Closing server\n");
			}
		}
		catch (Exception e)
		{
			System.out.println("\nTestServerHandler.run: " + e);
			// messages.append("\nTestServerHandler.run: " + e);
		}

	}

}
