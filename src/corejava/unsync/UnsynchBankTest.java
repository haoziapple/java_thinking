/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.unsync.UnsynchBankTest
 * @description:TODO
 * @date:2016-4-7 下午8:33:05
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
 * This program shows data corruption when multiple threads access a data
 * structure.
 */
public class UnsynchBankTest
{
	public static final int NACCOUNTS = 100;
	public static final double INITIAL_BALANCE = 1000;

	public static void main(String[] args)
	{
		Bank b = new Bank(NACCOUNTS, INITIAL_BALANCE);
		int i;
		for (i = 0; i < NACCOUNTS; i++)
		{
			TransferRunnable r = new TransferRunnable(b, i, INITIAL_BALANCE);
			Thread t = new Thread(r);
			t.start();
		}
	}

}
