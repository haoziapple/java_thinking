/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.AtomicEvenGenerator
 * @description:TODO
 * @date:2016-3-22 下午2:39:11
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-22     WangHao       v1.0.0        create
 *
 *
 */
package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

//Atomic classes are occasionally useful in regular code.
//{RunByHand}
public class AtomicEvenGenerator extends IntGenerator
{
	private AtomicInteger currentEvenValue = new AtomicInteger(0);
	
	public int next()
	{
		return currentEvenValue.addAndGet(2);
	}
	
	public static void main(String[] args)
	{
		EvenChecker.test(new AtomicEvenGenerator());
	}

}
