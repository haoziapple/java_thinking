/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:coninaction.CountingFactorizer
 * @description:TODO
 * @date:2016-5-16 下午4:46:49
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
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @className:coninaction.CountingFactorizer
 * @description:使用AtomicLong类型的变量来统计已处理请求的数量
 * @version:v1.0.0
 * @date:2016-5-16 下午4:47:23
 * @author:WangHao
 */
// ThreadSafe!
public class CountingFactorizer implements Servlet
{
	// Servlet的状态就是计数器的状态！
	// 因为计数器是线程安全的，因此Servlet也是线程安全的。
	private final AtomicLong count = new AtomicLong(0);

	public long getCount()
	{
		return count.get();
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException
	{
		// BigInteger i = extractFromRequest(req);
		// BigInteger[] factors = factor[i];
		count.incrementAndGet();
		// encodeIntoResponse(resp, factors);
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
