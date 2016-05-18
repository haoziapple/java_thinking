/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:coninaction.OnValueCache
 * @description:TODO
 * @date:2016-5-18 下午7:50:33
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-5-18     WangHao       v1.0.0        create
 *
 *
 */
package coninaction;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @className:coninaction.OnValueCache
 * @description:对数值及其因数分解结果进行缓存的不可变容器类
 * @version:v1.0.0
 * @date:2016-5-18 下午7:50:40
 * @author:WangHao
 */
public class OneValueCache
{
	private final BigInteger lastNumber;
	private final BigInteger[] lastFactors;

	public OneValueCache(BigInteger i, BigInteger[] factors)
	{
		lastNumber = i;
		lastFactors = Arrays.copyOf(factors, factors.length);
	}

	public BigInteger[] getFactors(BigInteger i)
	{
		if (lastNumber == null || !lastNumber.equals(i))
			return null;
		else
			return Arrays.copyOf(lastFactors, lastFactors.length);
	}

}
