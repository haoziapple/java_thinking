/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.multithread.FutureTest
 * @description:TODO
 * @date:2016-4-8 下午5:49:40
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-8     WangHao       v1.0.0        create
 *
 *
 */
package corejava.multithread;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTest
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.print("Enter base directory (e.g. /usr/local/jdk5.0/src):");
		String directory = in.nextLine();
		System.out.print("Enter keyword (e.g. volatile): ");
		String keyword = in.nextLine();

		MatchCounter counter = new MatchCounter(new File(directory), keyword);
		FutureTask<Integer> task=new FutureTask<Integer>(counter);
		Thread t=new Thread(task);
		t.start();
		try
		{
			System.out.println(task.get()+" matching files.");
		}
		catch(ExecutionException e)
		{
			e.printStackTrace();
		}
		catch(InterruptedException e)
		{
			
		}
	}
}

/**
 * This task counts the files in a directory and its subdirectories that
 * contains a given keyword
 */
class MatchCounter implements Callable<Integer>
{
	private File directory;
	private String keyword;
	private int count;

	public MatchCounter(File directory, String keyword)
	{
		this.directory = directory;
		this.keyword = keyword;
	}
	
	/**
	 * Searches a file for a given keyword.
	 */
	public boolean search(File file)
	{
		try
		{
			Scanner in=new Scanner(file);
			boolean found =false;
			while(!found&&in.hasNextLine())
			{
				String line=in.nextLine();
				if(line.contains(keyword))
					found=true;
			}
			return found;
		}
		catch(IOException e)
		{
			return false;
		}
	}

	@Override
	public Integer call() throws Exception
	{
		count = 0;
		try
		{
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<Future<Integer>>();

			for (File file : files)
				if (file.isDirectory())
				{
					MatchCounter counter = new MatchCounter(file, keyword);
					FutureTask<Integer> task = new FutureTask<Integer>(counter);
					results.add(task);
					Thread t = new Thread(task);
					t.start();
				}
				else
				{
					if (search(file))
						count++;
				}
			for (Future<Integer> result : results)
				try
				{
					count += result.get();
				}
				catch (ExecutionException e)
				{
					e.printStackTrace();
				}
		}
		catch (InterruptedException e)
		{

		}
		return count;
	}

}
