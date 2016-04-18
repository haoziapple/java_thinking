/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.safe.hash.Digest
 * @description:TODO
 * @date:2016-4-18 下午3:31:49
 * @version:v1.0.0 
 * @author:WangHao
 * 
 * Modification History:
 * Date         Author      Version     Description
 * -----------------------------------------------------------------
 * 2016-4-18     WangHao       v1.0.0        create
 *
 *
 */
package corejava.safe.hash;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;

/**
 * This program computes the message digest of a file.
 * 
 * Run the program:
 * java hash.Digest hash/input.txt MD5
 */
public class Digest
{
	public static void main(String[] args) throws IOException, GeneralSecurityException
	{
		String algname = args.length >= 2 ? args[1] : "SHA-1";
		MessageDigest alg = MessageDigest.getInstance(algname);
		byte[] input = Files.readAllBytes(Paths.get(args[0]));
		byte[] hash = alg.digest(input);
		String d = "";
		for (int i = 0; i < hash.length; i++)
		{
			int v = hash[i] & 0xFF;
			if (v < 16)
				d += "0";
			d += Integer.toString(v, 16).toUpperCase() + " ";
		}
		System.out.println(d);
	}
}
