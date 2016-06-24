/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:base.reusing.BlankFinal
 * @description:TODO
 * @date:2016-6-20 下午5:44:22
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-20     WangHao       v1.0.0        create
 *
 *
 */
package base.reusing;

/**
 * @className:base.reusing.BlankFinal
 * @description:域指定为final但又未给定初值的域
 * @version:v1.0.0
 * @date:2016-6-20 下午5:44:34
 * @author:WangHao
 */

class Poppet
{
	@SuppressWarnings("unused")
	private int i;

	Poppet(int ii)
	{
		i = ii;
	}
}

public class BlankFinal
{
	@SuppressWarnings("unused")
	private final int i = 0; // Initialized final
	@SuppressWarnings("unused")
	private final int j; // Blank final
	@SuppressWarnings("unused")
	private final Poppet p; // Blank final reference

	// Blank finals MUST be initialized in the constructor:
	public BlankFinal()
	{
		j = 1; // Initialize blank final
		p = new Poppet(1); // Initialize blank final reference
	}

	public BlankFinal(int x)
	{
		j = x; // Initialize blank final
		p = new Poppet(x); // Initialize blank final reference
	}

	public static void main(String[] args)
	{
		new BlankFinal();
		new BlankFinal(47);
	}
}
