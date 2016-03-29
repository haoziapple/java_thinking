/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:concurrency.EvenGenerator
 * @description:TODO
 * @date:2016-3-21 下午3:26:20
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-3-21     WangHao       v1.0.0        create
 *
 *
 */
package concurrency;
//when threads collide
public class EvenGenerator extends IntGenerator
{
	private int currentEvenValue = 0;
	@Override
	public int next()
	{
		++currentEvenValue; //Danger point here!
		++currentEvenValue;
		return currentEvenValue;
	}
	public static void main(String[] args)
	{
		EvenChecker.test(new EvenGenerator());
	}

}
