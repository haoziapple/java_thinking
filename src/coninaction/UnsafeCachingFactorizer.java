/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:coninaction.UnsafeCachingFactorizer
 * @description:TODO
 * @date:2016-5-16 下午4:56:38
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-5-16     WangHao       v1.0.0        create
 *
 *
 */
package coninaction;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @className:coninaction.UnsafeCachingFactorizer
 * @description:在没有足够原子性保证的情况下对其最近计算结果进行缓存（不要这么做）
 * @version:v1.0.0
 * @date:2016-5-16 下午4:56:43
 * @author:WangHao
 */
// NotThreadSafe!
public class UnsafeCachingFactorizer implements Servlet
{
	// 无法同时更新lastNumber和lastFactors
	private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();

	private final AtomicReference<BigInteger[]> lastFactors = new AtomicReference<BigInteger[]>();

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException
	{
		BigInteger i = extractFromRequest(req);
		if (i.equals(lastNumber.get()))
			encodeIntoResponse(resp, lastFactors.get());
		else
		{
			BigInteger[] factors = factor(i);
			lastNumber.set(i);
			lastFactors.set(factors);
			encodeIntoResponse(resp, factors);
		}
	}

	/**
	 * @Description:
	 * @param i
	 * @return
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016-5-16 下午5:03:23
	 */
	private BigInteger[] factor(BigInteger i)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @Description:
	 * @param resp
	 * @param bigIntegers
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016-5-16 下午5:03:17
	 */
	private void encodeIntoResponse(ServletResponse resp, BigInteger[] bigIntegers)
	{
		// TODO Auto-generated method stub

	}

	/**
	 * @Description:
	 * @param req
	 * @return
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016-5-16 下午5:03:13
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
