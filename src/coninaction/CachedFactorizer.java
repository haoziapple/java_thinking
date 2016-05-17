/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:coninaction.CachedFactorizer
 * @description:TODO
 * @date:2016-5-17 下午3:03:53
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-5-17     WangHao       v1.0.0        create
 *
 *
 */
package coninaction;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @className:coninaction.CachedFactorizer
 * @description:缓存最近执行因数分解的数值及其计算结果的Servlet
 * @version:v1.0.0
 * @date:2016-5-17 下午3:04:13
 * @author:WangHao
 */
// ThreadSafe!
public class CachedFactorizer implements Servlet
{
	private BigInteger lastNumber;
	private BigInteger[] lastFactors;
	private long hits;
	private long cacheHits;

	public synchronized long getHits()
	{
		return hits;
	}

	public synchronized double getCacheHitRatio()
	{
		return (double) cacheHits / (double) hits;
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException
	{
		BigInteger i = extractFromRequest(req);
		BigInteger[] factors = null;
		synchronized (this)
		{
			++hits;
			if (i.equals(lastNumber))
			{
				++cacheHits;
				factors = lastFactors.clone();
			}
		}
		if (factors == null)
		{
			factors = factor(i);
			synchronized (this)
			{
				lastNumber = i;
				lastFactors = factors.clone();
			}
		}
		encodeIntoResponse(resp, factors);
	}
	 
	 /**
	 * @Description:
	 * @param resp
	 * @param factors
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016-5-17 下午3:18:14
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
	 * @date:2016-5-17 下午3:18:12
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
	 * @date:2016-5-17 下午3:18:09
	 */
	private BigInteger extractFromRequest(ServletRequest req)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#destroy()
	 */
	@Override
	public void destroy()
	{
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#getServletConfig()
	 */
	@Override
	public ServletConfig getServletConfig()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#getServletInfo()
	 */
	@Override
	public String getServletInfo()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Servlet#init(javax.servlet.ServletConfig)
	 */
	@Override
	public void init(ServletConfig arg0) throws ServletException
	{
		// TODO Auto-generated method stub

	}

}
