/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.synch.SyncBank
 * @description:TODO
 * @date:2016-4-8 上午11:10:01
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
public class SyncBank
{
	private double[] accounts;
	
	public synchronized void transfer(int from, int to, int amount) throws InterruptedException
	{
		while(accounts[from]<amount)
			wait(); //wait on intrinsic object lock's single condition
		accounts[from]-=amount;
		System.out.printf(" %10.2f from %d to %d", amount, from, to);
		accounts[to]+=amount;
		System.out.printf(" Total Balance: %10.2f/n", getTotalBalance());
		notifyAll(); //notify all threads waiting on the condition
	}
	public synchronized double getTotalBalance()
	{
		double sum=0;
		for(double a:accounts)
			sum+=a;
		return sum;
	}
	
	public int size()
	{
		return accounts.length;
	}

}
