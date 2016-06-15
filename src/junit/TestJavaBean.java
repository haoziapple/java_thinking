/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:junit.TestJavaBean
 * @description:TODO
 * @date:2016-6-14 下午3:02:36
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-6-14     WangHao       v1.0.0        create
 *
 *
 */
package junit;

/**
 * @className:junit.TestJavaBean
 * @description:在JUnit中测试一般JavaBean
 * @version:v1.0.0
 * @date:2016-6-14 下午3:04:02
 * @author:WangHao
 */
public class TestJavaBean
{
	private String test1 = "";

	private String test2 = "";

	public String getTest1()
	{
		return test1;
	}

	public void setTest1(String test1)
	{
		this.test1 = test1;
	}

	public String getTest2()
	{
		return test2;
	}

	public void setTest2(String test2)
	{
		this.test2 = test2;
	}

	// 重写equals方法
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;
		if (this == obj)
			return true;
		if (obj instanceof TestJavaBean)
		{
			TestJavaBean other = (TestJavaBean) obj;
			return (other.test1).equals(this.test1);
		}
		return false;
	}

	public static void main(String[] args)
	{
		TestJavaBean bean = new TestJavaBean();
		System.out.println(bean);
		bean.setTest1("name1");
		System.out.println(bean);
		bean.setTest2("name2");
		System.out.println(bean);
	}
}
