/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:strings.ScannerDelimiter
 * @description:TODO
 * @date:2016-2-14 下午3:10:47
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

public class ScannerDelimiter
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner("12,52, 78, 99, 42");
		scanner.useDelimiter("\\s*,\\s*");
		while(scanner.hasNextInt())
			System.out.println(scanner.nextInt());
	}

}
