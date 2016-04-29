/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:haozijava.concurrency.FutureTaskDemo
 * @description:TODO
 * @date:2016-4-29 下午4:33:11
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-29     WangHao       v1.0.0        create
 *
 *
 */
package haozijava.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @className:haozijava.concurrency.FutureTaskDemo
 * @description:分线程汇总
 * @version:v1.0.0 
 * @date:2016-4-29 下午4:39:08
 * @author:WangHao
 */
public class FutureTaskDemo
{
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args)
	{

		// 初始化一个Callable对象和FutureTask对象
		Callable otherPerson = new OtherPerson();

		// 由此任务去执行
		FutureTask futureTask = new FutureTask(otherPerson);

		// 使用futureTask创建一个线程
		Thread newhread = new Thread(futureTask);

		System.out.println("newhread线程现在开始启动，启动时间为：" + System.nanoTime() + " 纳秒");

		newhread.start();

		System.out.println("主线程——东方不败，开始执行其他任务");

		System.out.println("东方不败开始准备小刀，消毒...");

		// 兄弟线程在后台的计算线程是否完成，如果未完成则等待
		// 阻塞
		while (!futureTask.isDone())
		{

			try
			{
				Thread.sleep(500);
				System.out.println("东方不败：“等兄弟回来了，我就和小弟弟告别……颤抖……”");
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}

		System.out.println("newhread线程执行完毕，此时时间为" + System.nanoTime());
		String result = null;
		try
		{
			result = (String) futureTask.get();

		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} catch (ExecutionException e)
		{
			e.printStackTrace();
		}

		if ("OtherPerson：：：经过一番厮杀取得《葵花宝典》".equals(result))
		{
			System.out.println("兄弟，干得好，我挥刀自宫了啊！");
		} else
		{
			System.out.println("还好我没自宫！否则白白牺牲了……");
		}

	}
}

@SuppressWarnings("rawtypes")
class OtherPerson implements Callable
{

	@Override
	public Object call() throws Exception
	{

		// 先休息休息再拼命去！
		Thread.sleep(5000);
		String result = "OtherPerson：：：经过一番厮杀取得《葵花宝典》";
		System.out.println(result);
		return result;
	}

}
