/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.safe.AESTest
 * @description:TODO
 * @date:2016-4-18 下午3:54:16
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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * This program tests the AES cipher.Usage:<br>
 * java aes.AESTest -genkey keyfile<br>
 * java aes.AESTest -encrypt plaintext encrypted keyfile<br>
 * java aes.AESTest -decrypt encrypted decrypted keyfile<br>
 */
public class AESTest
{
	public static void main(String[] args) throws GeneralSecurityException, IOException, ClassNotFoundException
	{
		if(args[0].equals("-genkey"))
		{
			KeyGenerator keygen=KeyGenerator.getInstance("AES");
			SecureRandom random = new SecureRandom();
			//random.setSeed(seed);
			keygen.init(random);
			SecretKey key=keygen.generateKey();
			
			ObjectOutputStream out=new ObjectOutputStream(new FileOutputStream(args[1]));
			out.writeObject(key);
		}
		else
		{
			int mode;
			if(args[0].equals("-encrypt"))
				mode=Cipher.ENCRYPT_MODE;
			else
				mode=Cipher.DECRYPT_MODE;
			ObjectInputStream keyIn=new ObjectInputStream(new FileInputStream(args[3]));
			InputStream in=new FileInputStream(args[1]);
			OutputStream out=new FileOutputStream(args[2]);
			
			Key key=(Key)keyIn.readObject();
			Cipher cipher=Cipher.getInstance("AES");
			cipher.init(mode, key);
			Util.crypt(in, out, cipher);
		}
	}
}
