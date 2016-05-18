/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:coninaction.VolatileCachedFactorizer
 * @description:TODO
 * @date:2016-5-18 下午8:04:59
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

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @className:coninaction.VolatileCachedFactorizer
 * @description:使用指向不可变容器对象的volatile类型引用以缓存最新的结果
 * @version:v1.0.0
 * @date:2016-5-18 下午8:05:08
 * @author:WangHao
 */
// ThreadSafe
public class VolatileCachedFactorizer
{
	private volatile OneValueCache cache = new OneValueCache(null, null);

	public void service(ServletRequest req, ServletResponse resp)
	{
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = cache.getFactors(i);
		if (factors == null)
		{
			factors = factor(i);
			cache = new OneValueCache(i, factors);
		}
		encodeIntoResponse(resp, factors);
	}

	
	 
	 
	 /**
	 * @Description:
	 * @param resp
	 * @param factors
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016-5-18 下午8:11:07
	 */
	private void encodeIntoResponse(ServletResponse resp, BigInteger[] factors)
	{
		// TODO Auto-generated method stub
		
	}



	/**
	 * @Description:
	 * @param i
	 * @return
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016-5-18 下午8:11:05
	 */
	private BigInteger[] factor(BigInteger i)
	{
		// TODO Auto-generated method stub
		return null;
	}


	/**
	 * @Description:
	 * @param req
	 * @return
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016-5-18 下午8:11:03
	 */
	private BigInteger extractFromRequest(ServletRequest req)
	{
		// TODO Auto-generated method stub
		return null;
	}
}
