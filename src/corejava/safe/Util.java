/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.safe.Util
 * @description:TODO
 * @date:2016-4-18 下午3:56:04
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
package corejava.safe;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;

import javax.crypto.Cipher;

public class Util
{
	/**
	 * Uses a cipher to transform the bytes
	 */
	public static void crypt(InputStream in, OutputStream out, Cipher cipher) throws IOException,
			GeneralSecurityException
	{
		int blockSize = cipher.getBlockSize();
		int outputSize = cipher.getOutputSize(blockSize);
		byte[] inBytes = new byte[blockSize];
		byte[] outBytes = new byte[outputSize];
		int inLength = 0;

		boolean more = true;
		while (more)
		{
			inLength = in.read(inBytes);
			if (inLength == blockSize)
			{
				int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
				out.write(outBytes, 0, outLength);
			}
			else
				more = false;
		}
		if (inLength > 0)
			outBytes = cipher.doFinal(inBytes, 0, inLength);
		else
			outBytes = cipher.doFinal();
		out.write(outBytes);
	}

}
