/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.xml.SAXTest
 * @description:TODO
 * @date:2016-4-14 下午5:15:55
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-14     WangHao       v1.0.0        create
 *
 *
 */
package corejava.xml;

import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @className:corejava.xml.SAXTest
 * @description:This program demonstrates how to use a SAX parser. The program
 *                   prints all hyperlinks of an XHTML web page.<br>
 * @version:v1.0.0
 * @date:2016-4-14 下午5:15:59
 * @author:WangHao
 */
public class SAXTest
{
	public static void main(String[] args) throws Exception
	{
		String url;
		if (args.length == 0)
		{
			url = "http://www.w3c.org";
			System.out.println("Using " + url);
		}
		else
			url = args[0];

		DefaultHandler handler = new DefaultHandler()
		{
			public void startElement(String namespaceURI, String lname, String qname, Attributes attrs)
			{
				if (lname.equals("a") && attrs != null)
				{
					for (int i = 0; i < attrs.getLength(); i++)
					{
						String aname = attrs.getLocalName(i);
						if (aname.equals("href"))
							System.out.println(attrs.getValue(i));
					}
				}
			}
		};
		
		SAXParserFactory factory=SAXParserFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd",false);
		SAXParser saxParser=factory.newSAXParser();
		InputStream in = new URL(url).openStream();
		saxParser.parse(in, handler);
	}
}
