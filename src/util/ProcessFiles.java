/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:util.ProcessFiles
 * @description:TODO
 * @date:2016-2-19 下午3:28:26
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-19     WangHao       v1.0.0        create
 *
 *
 */
package util;

import java.io.File;
import java.io.IOException;

public class ProcessFiles
{
	public interface Strategy {
		void process(File file);
	}
	private Strategy strategy;
	private String ext;
	/**
	 * @param strategy
	 * @param ext
	 */
	public ProcessFiles(Strategy strategy, String ext)
	{
		this.strategy = strategy;
		this.ext = ext;
	}
	public void start(String[] args) {
		try {
			if(args.length == 0)
				processDirectoryTree(new File("."));
			else
				for(String arg : args) {
					File fileArg = new File(arg);
					if(fileArg.isDirectory())
						processDirectoryTree(fileArg);
					else {
						//Allow user to leave off extension:
						if(!arg.endsWith("." + ext))
							arg += "." + ext;
						strategy.process(new File(arg).getCanonicalFile());
					}
				}
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}
	public void
	processDirectoryTree(File root) throws IOException {
		for(File file : Directory.walk(
				root.getAbsolutePath(), ".*\\." + ext))
			strategy.process(file.getCanonicalFile());
	}
	//Demonstration of how to use it:
	public static void main(String[] args) {
		new ProcessFiles(new ProcessFiles.Strategy()
		{
			@Override
			public void process(File file)
			{
				System.out.println(file);
			}
		}, "class").start(args);
	}
}
