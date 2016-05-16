/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:coninaction.UnsafeCountingFactorizer
 * @description:TODO
 * @date:2016-5-16 下午4:12:55
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

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @className:coninaction.UnsafeCountingFactorizer
 * @description:在没有同步的情况下统计已处理请求数量的Servlet（不要这么做）
 * @version:v1.0.0
 * @date:2016-5-16 下午4:13:37
 * @author:WangHao
 */
// NotThreadSafe!
// 竞态条件（Race Condition）
// 
public class UnsafeCountingFactorizer implements Servlet
{
	private long count = 0;

	public long getCount()
	{
		return count;
	}

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException
	{
		// BigInteger i = extractFromRequest(req);
		// BigInteger[] factors = factor(i);
		// ++count;
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
