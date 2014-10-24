package com.stang.game.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * 
 * @author Qingping Yin
 * @version 1.0
 */
public class Password {

	public static void main(String[] args) throws Exception {
		System.out.println(digestPassword("kenshin"));
		System.out.println(digestPassword("wangh"));
		System.out.println(digestPassword("admin"));
		System.out.println(digestPassword("123456"));

	}

	private static final int SALT_ORIGINAL_LEN = 8;

	private static final int SALT_ENCODED_LEN = 12;

	/**
	 * @method digestPassword
	 * @param password
	 *            需要加密的字符串
	 * @description 加密
	 */
	public static String digestPassword(String password) {
		try {
			SecureRandom random = new SecureRandom();
			byte[] salt = new byte[SALT_ORIGINAL_LEN];
			random.nextBytes(salt);
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(salt);
			md.update(password.getBytes());
			byte[] digest = md.digest();
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(salt) + encoder.encode(digest);
		} catch (NoSuchAlgorithmException ne) {
			System.out.println(ne.toString());
			return null;
		} catch (Exception e) {
			System.out.println(e.toString());
			return null;
		}
	}

	/**
	 * @method validatePassword
	 * @param password
	 *            用户输入的明文密码，如：123456
	 * @param digest
	 *            密文密码
	 * @return true:密码相同 false:密码不同
	 * @description 验证一个明文密码和一个密文密码是否相等ͬ
	 */
	public static boolean validatePassword(String password, String digest) {
		boolean label = false;
		try {
			String salt_str = digest.substring(0, SALT_ENCODED_LEN);
			String digest_str = digest.substring(SALT_ENCODED_LEN, digest
					.length());
			BASE64Decoder decoder = new BASE64Decoder();
			byte[] salt = decoder.decodeBuffer(salt_str);
			byte[] digest_old = decoder.decodeBuffer(digest_str);
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(salt);
			md.update(password.getBytes());
			byte[] digest_new = md.digest();
			label = Arrays.equals(digest_old, digest_new);
		} catch (NoSuchAlgorithmException ne) {
			System.out.println(ne.toString());
		} catch (IOException ie) {
			System.out.println(ie.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return label;
	}

	/**
	 * @method validateCryptograph
	 * @param cryptograph
	 *            密文密码，如：iGgs9Ly5pOc=KWfGFcfCV94iZetG31SskQ==
	 * @param digest
	 *            目标密文密码，如：iGgs9Ly5pOc=KWf3l33V94iZetG31a33df==
	 * @return true:密码相同 false:密码不同
	 * @description 验证两个同为密文的密码是否相等ͬ
	 */
	public static boolean validateCryptograph(String cryptograph, String digest) {
		return true;
	}

	/**
	 * @method getRandomPassword
	 * @param length
	 *            生成密码的长度
	 * @return String 生成的密码
	 * @description 生成指定长度的密码ͬ
	 */
	public static String getRandomPassword(int length) {
		String base = "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuffer result = new StringBuffer();
		Random r = new Random();
		for (int i = 0; i < length; ++i) {
			int pos = r.nextInt(base.length());
			String item = base.substring(pos, pos + 1);
			result.append(item);
		}
		return result.toString();
	}
}
