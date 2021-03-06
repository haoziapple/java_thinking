/**
 * Copyright (C) 2016 FuZhong
 *
 *
 * @className:corejava.safe.RSATest
 * @description:TODO
 * @date:2016-4-18 下午4:41:17
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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 * This program tests the RSA cipher.Usage:<br>
 * java rsa.RSATest -genkey public private<br>
 * java rsa.RSATest -encrypt plaintext encrypted public<br>
 * java rsa.RSATest -decrypt encrypted decrypted private<br>
 */
public class RSATest
{
	private static final int KEYSIZE = 512;

	public static void main(String[] args) throws GeneralSecurityException, IOException, ClassNotFoundException
	{
		if (args[0].equals("-genkey"))
		{
			KeyPairGenerator pairgen = KeyPairGenerator.getInstance("RSA");
			SecureRandom random = new SecureRandom();
			pairgen.initialize(KEYSIZE, random);
			KeyPair keyPair = pairgen.generateKeyPair();

			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(args[1]));
			out.writeObject(keyPair.getPublic());

			out = new ObjectOutputStream(new FileOutputStream(args[2]));

			out.writeObject(keyPair.getPrivate());

		}
		else if (args[0].equals("-encrypt"))
		{
			KeyGenerator keygen = KeyGenerator.getInstance("AES");
			SecureRandom random = new SecureRandom();
			keygen.init(random);
			SecretKey key = keygen.generateKey();

			// wrap with RSA public key
			ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(args[3]));
			DataOutputStream out = new DataOutputStream(new FileOutputStream(args[2]));
			InputStream in = new FileInputStream(args[1]);

			Key publicKey = (Key) keyIn.readObject();
			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.WRAP_MODE, publicKey);
			byte[] wrappedKey = cipher.wrap(key);
			out.writeInt(wrappedKey.length);
			out.write(wrappedKey);

			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			Util.crypt(in, out, cipher);
		}
		else
		{
			DataInputStream in = new DataInputStream(new FileInputStream(args[1]));
			ObjectInputStream keyIn = new ObjectInputStream(new FileInputStream(args[3]));
			OutputStream out = new FileOutputStream(args[2]);

			int length = in.readInt();
			byte[] wrappedKey = new byte[length];
			in.read(wrappedKey, 0, length);

			// unwrap with RSA private key
			Key privateKey = (Key) keyIn.readObject();

			Cipher cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.UNWRAP_MODE, privateKey);
			Key key = cipher.unwrap(wrappedKey, "AES", Cipher.SECRET_KEY);

			cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, key);

			Util.crypt(in, out, cipher);
		}
	}

}
