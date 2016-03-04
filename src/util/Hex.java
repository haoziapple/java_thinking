/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:util.Hex
 * @description:TODO
 * @date:2016-2-5 下午2:51:52
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
package util;
public class Hex
{
	public static String format(byte[] data) {
		StringBuilder result = new StringBuilder();
		int n = 0;
		for(byte b : data) {
			if(n % 16 == 0)
				result.append(String.format("%05X: ", n));
			result.append(String.format("%02X ", b));
			n++;
			if(n % 16 == 0) 
				result.append("\n");
		}
		result.append("\n");
		return result.toString();
	}
	
	public static void main(String args[]) throws Exception {
	}

}
