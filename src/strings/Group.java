/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:strings.Group
 * @description:TODO
 * @date:2016-2-14 下午12:16:12
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-2-14     WangHao       v1.0.0        create
 *
 *
 */
package strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Group
{
	static public final String POEM =
			"Twas brilig, and the slithy toves\n" +
			"Did gyre and gimble in the wabe.\n" +
			"All mimsy were the borogoves.\n" +
			"And the mome raths outgrabe.\n\n" +
			"Beware the Jabberwock, my son.\n" +
			"The jaws that bite, the claws that catch.\n" +
			"Beware the Jubjub bird, and shun\n" +
			"The frumious Bandersnatch.";
	public static void main(String[] args) {
		Matcher m = 
				Pattern.compile("(?m)(\\S+)\\s+((\\S+)\\s+(\\S+))$").matcher(POEM);
		while(m.find()) {
			for(int j = 0; j <= m.groupCount(); j++)
				System.out.print("[" + m.group(j) + "]");
			System.out.print("\n");
		}
	}
}
