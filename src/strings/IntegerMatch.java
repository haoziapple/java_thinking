/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:strings.IntegerMatch
 * @description:TODO
 * @date:2016-2-5 下午3:18:22
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
public class IntegerMatch
{
	public static void main(String[] args) {
		System.out.println("-1234".matches("-?\\d+"));
		System.out.println("5678".matches("-?\\d+"));
		System.out.println("+911".matches("-?\\d+"));
		System.out.println("+911".matches("(-|\\+)?\\d+"));
	}

}
