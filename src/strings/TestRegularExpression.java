/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:strings.TestRegularExpression
 * @description:TODO
 * @date:2016-2-5 下午5:14:09
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-5     WangHao       v1.0.0        create
 *
 *
 */
package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//allows you to easily try out regular expression
//{Args: abcabcabcdefabc "abc+" "(abc)+" "(abc){2,}" }
public class TestRegularExpression
{
	public static void main(String args[])
	{
		if (args.length < 2)
		{
			System.out.println("Usage:\njava TestRegularExpression" + "characterSequence regularExpression+");
			System.exit(0);
		}
		System.out.println("Input: \"" + args[0] + "\"");
		for (String arg : args)
		{
			System.out.println("Regular expression: \"" + arg + "\"");
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(args[0]);
			while (m.find())
			{
				System.out.println("Match \"" + m.group() + "\" at postions " + m.start() + "-" + (m.end() - 1));
			}
		}
	}

}
