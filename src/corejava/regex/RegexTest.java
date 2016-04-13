/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.regex.RegexTest
 * @description:TODO
 * @date:2016-4-13 下午5:25:33
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-13     WangHao       v1.0.0        create
 *
 *
 */
package corejava.regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This program tests regular expression matching. Enter a pattern and strings
 * to match, or hit Cancel to exit. If the pattern contains group, the group
 * boundaries are displayed in the match.
 */
public class RegexTest
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter pattern: ");
		String patternString = in.nextLine();

		Pattern pattern = Pattern.compile(patternString);

		while (true)
		{
			System.out.println("Enter string to match: ");
			String input = in.nextLine();
			if (input == null || input.equals(""))
				return;
			Matcher matcher = pattern.matcher(input);
			if (matcher.matches())
			{
				System.out.println("Match");
				int g = matcher.groupCount();
				if (g > 0)
				{
					for (int i = 0; i < input.length(); i++)
					{
						// Print any empty groups
						for (int j = 1; j <= g; j++)
							if (i == matcher.start(j) && i == matcher.end(j))
								System.out.print("()");

						// Print ( for non-empty groups starting here
						for (int j = 1; j <= g; j++)
							if (i == matcher.start(j) && i != matcher.end(j))
								System.out.print('(');
						
						System.out.print(input.charAt(i));
						
						//Print ) for non-empty groups ending here
						for(int j=1;j<=g;j++)
							if(i+1!=matcher.start(j)&&i+1==matcher.end(j))
								System.out.print(')');
					}
					System.out.println();
				}
			}
			else
				System.out.println("No match");
		}
	}

}
