/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:coninaction.SynchronizedFactorizer
 * @description:TODO
 * @date:2016-5-16 下午5:11:32
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

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @className:coninaction.SynchronizedFactorizer
 * @description:能正确地缓存最新的计算结果，但并发性却非常糟糕（不要这么做）
 * @version:v1.0.0
 * @date:2016-5-16 下午5:11:36
 * @author:WangHao
 */
// ThreadSafe!
public class SynchronizedFactorizer implements Servlet
{
	private BigInteger lastNumber;

	private BigInteger[] lastFactors;

	// 同一时刻只有一个线程可以执行service方法
	@Override
	public synchronized void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException
	{
		BigInteger i = extractFromRequest(req);
		if (i.equals(lastNumber))
			encodeIntoResponse(resp, lastFactors);
		else
		{
			BigInteger[] factors = factor(i);
			lastNumber = i;
			lastFactors = factors;
			encodeIntoResponse(resp, factors);
		}
	}

	
	 
	 
	 /**
	 * @Description:
	 * @param i
	 * @return
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016-5-16 下午5:17:18
	 */
	private BigInteger[] factor(BigInteger i)
	{
		// TODO Auto-generated method stub
		return null;
	}



	/**
	 * @Description:
	 * @param resp
	 * @param lastFactors2
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016-5-16 下午5:17:16
	 */
	private void encodeIntoResponse(ServletResponse resp, BigInteger[] lastFactors2)
	{
		// TODO Auto-generated method stub
		
	}


	/**
	 * @Description:
	 * @param req
	 * @return
	 * @version:v1.0
	 * @author:WangHao
	 * @date:2016-5-16 下午5:17:15
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
