/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:coninaction.StatelessFactorizer
 * @description:TODO
 * @date:2016-5-16 下午4:04:33
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
 * @className:coninaction.StatelessFactorizer
 * @description:一个无状态的Servlet
 * @version:v1.0.0
 * @date:2016-5-16 下午4:09:15
 * @author:WangHao
 */
// 无状态对象一定是线程安全的!
public class StatelessFactorizer implements Servlet
{
	@Override
	public void service(ServletRequest req, ServletResponse rsp) throws ServletException, IOException
	{
		// BigInteger i = extractFromRequest(req);
		// BigInteger[] factors = factor(i);
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
