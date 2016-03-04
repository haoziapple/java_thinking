/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:strings.ThreatAnalyzer
 * @description:TODO
 * @date:2016-2-14 下午3:14:53
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

import java.util.Scanner;
import java.util.regex.MatchResult;

public class ThreatAnalyzer
{
	static String threatData =
			"58.27.82.163@02/10/2005\n" +
			"204.45.234.40@02/11/2005\n" +
			"46.25.82.161@02/11/2005\n";
	public static void main(String[] args) {
		Scanner scanner = new Scanner(threatData);
		String pattern = "(\\d+[.]\\d+[.]\\d+[.]\\d+)@" +
				"(\\d{2}/\\d{2}/\\d{4})";
		while(scanner.hasNext(pattern)) {
			String s = scanner.next(pattern);
			System.out.println(s);
			
			MatchResult match = scanner.match();
			String ip = match.group(1);
			String date = match.group(2);
			System.out.format("Threat on %s from %s\n", date, ip);
		}
	}

}
