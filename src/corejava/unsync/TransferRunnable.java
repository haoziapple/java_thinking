/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.unsync.TransferRunnable
 * @description:TODO
 * @date:2016-4-7 下午7:27:54
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-7     WangHao       v1.0.0        create
 *
 *
 */
package corejava.unsync;

/**
 * A runnable that transfers money from an account to other accounts in a bank.
 */
public class TransferRunnable implements Runnable
{
	private Bank bank;
	private int fromAccount;
	private double maxAmount;
	private int DELAY = 10;

	public TransferRunnable(Bank b, int from, double max)
	{
		bank = b;
		fromAccount = from;
		maxAmount = max;
	}

	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				int toAccount = (int) (bank.size() * Math.random());
				double amount = maxAmount * Math.random();
				bank.transfer(fromAccount, toAccount, amount);
				Thread.sleep((int) (DELAY * Math.random()));
			}
		}
		catch (InterruptedException e)
		{

		}
	}
}
