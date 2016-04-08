/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.synch.Bank
 * @description:TODO
 * @date:2016-4-8 上午10:48:58
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
package corejava.synch;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A bank with a number of bank accounts that uses for serializing access.
 */
public class Bank
{
	private final double[] accounts;
	private Lock bankLock;
	private Condition sufficientFunds;

	public Bank(int n, double initialBalance)
	{
		accounts = new double[n];
		for (int i = 0; i < accounts.length; i++)
			accounts[i] = initialBalance;
		bankLock = new ReentrantLock();
		sufficientFunds = bankLock.newCondition();
	}

	public void transfer(int from, int to, double amount) throws InterruptedException
	{
		bankLock.lock();
		try
		{
			while (accounts[from] < amount)
				sufficientFunds.await();
			System.out.print(Thread.currentThread());
			accounts[from] -= amount;
			System.out.printf(" %10.2f from %d to %d", amount, from, to);
			accounts[to] += amount;
			System.out.printf(" Total Balance: %10.2f/n", getTotalBalance());
			sufficientFunds.signalAll();
		}
		finally
		{
			bankLock.unlock();
		}
	}

	public double getTotalBalance()
	{
		bankLock.lock();
		try
		{
			double sum=0;
			
			for(double a:accounts)
				sum+=a;
					
					return sum;
		}
		finally
		{
			bankLock.unlock();
		}
	}
	
	public int size()
	{
		return accounts.length;
	}
}
