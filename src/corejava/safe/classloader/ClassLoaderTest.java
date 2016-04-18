/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.safe.classloader.ClassLoaderTest
 * @description:TODO
 * @date:2016-4-18 下午2:58:05
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-18     WangHao       v1.0.0        create
 *
 *
 */
package corejava.safe.classloader;

import java.awt.GridBagLayout;
import java.io.IOException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * This program demonstrates a custom class loader that decrypts class files.
 */
public class ClassLoaderTest
{
	public static void main(String[] args)
	{
		JFrame frame = new ClassLoaderFrame();
		frame.setTitle("ClassLoaderTest");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

/**
 * This frame contains two text fields for the name of the class to load and
 * decryption key.
 */
@SuppressWarnings("serial")
class ClassLoaderFrame extends JFrame
{
	@SuppressWarnings("unused")
	private JTextField keyField = new JTextField("3", 4);
	@SuppressWarnings("unused")
	private JTextField nameField = new JTextField("Calculator", 30);
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 200;

	public ClassLoaderFrame()
	{
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLayout(new GridBagLayout());
	}

	/**
	 * Runs the main method of a given class.
	 */
	public void runClass(String name, String key)
	{
		try
		{
			ClassLoader loader = new CryptoClassLoader(Integer.parseInt(key));
			Class<?> c = loader.loadClass(name);
			Method m = c.getMethod("main", String[].class);
			m.invoke(null, (Object) new String[]
			{});
		}
		catch (Throwable e)
		{
			JOptionPane.showMessageDialog(this, e);
		}
	}
}

class CryptoClassLoader extends ClassLoader
{
	private int key;

	public CryptoClassLoader(int k)
	{
		key = k;
	}

	protected Class<?> findClass(String name) throws ClassNotFoundException
	{
		try
		{
			byte[] classBytes = null;
			classBytes = loadClassBytes(name);
			Class<?> cl = defineClass(name, classBytes, 0, classBytes.length);
			if (cl == null)
				throw new ClassNotFoundException(name);
			return cl;
		}
		catch (IOException e)
		{
			throw new ClassNotFoundException(name);
		}
	}

	private byte[] loadClassBytes(String name) throws IOException
	{
		String cname = name.replace('.', '/') + ".caesar";
		byte[] bytes = Files.readAllBytes(Paths.get(cname));
		for (int i = 0; i < bytes.length; i++)
			bytes[i] = (byte) (bytes[i] - key);
		return bytes;
	}
}
