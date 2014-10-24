package com.stang.game.ffd.common;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * <p>
 * Description: 密码加密
 * </p>
 * <p>
 * </p>
 * @version 1.0
 */
public class Password {

	public static void main(String[] args) throws Exception {
		//System.out.println(digestPassword("kenshin"));
		//System.out.println(digestPassword("wangh"));
		//System.out.println(digestPassword("admin"));
		//System.out.println(digestPassword("123456"));
		System.out.println(digestPassword("123","66"));
		
	}

	private static final int SALT_ORIGINAL_LEN = 8;

	private static final int SALT_ENCODED_LEN = 12;

	/**
	 * @method digestPassword
	 * @param password 需要加密的字符串
	 * @description 加密
	 */
	public static String digestPassword(String password,String roleInfo) {
		try {
			SecureRandom random = new SecureRandom();
			byte[] salt = new byte[SALT_ORIGINAL_LEN];
			random.nextBytes(salt);
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(salt);
			md.update(password.getBytes());
			byte[] digest = md.digest();
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(roleInfo.getBytes())+"santang="+encoder.encode(salt) + encoder.encode(digest);
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
	 * @param password 用户输入的明文密码，如：123456
	 * @param digest 密文密码
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
	 * @param cryptograph 密文密码，如：iGgs9Ly5pOc=KWfGFcfCV94iZetG31SskQ==
	 * @param digest 目标密文密码，如：iGgs9Ly5pOc=KWf3l33V94iZetG31a33df==
	 * @return true:密码相同 false:密码不同
	 * @description 验证两个同为密文的密码是否相等ͬ
	 */
	public static boolean validateCryptograph(String cryptograph, String digest) {
		return true;
	}
	
	/**
	 * @method getRandomPassword
	 * @param length 生成密码的长度
	 * @return String 生成的密码
	 * @description 生成指定长度的密码ͬ
	 */
	public static String getRandomPassword(int length){
		String base = "abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuffer result = new StringBuffer();
		Random r = new Random();
		for (int i = 0; i < length; ++i){
			int pos = r.nextInt(base.length());
			String item = base.substring(pos, pos + 1);
			result.append(item);
		}
		return result.toString();
	}
	
	public static String MD5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}
   /*字符串加密*/
   public static String conversionASCII(String str,char charStr){
         
       char[]chars=str.toCharArray(); 
	   byte cs= (byte) charStr;
	   for(int i=0;i<chars.length;i++){
		   chars[i]=(char)((int)chars[i]+cs);
	   }
	   return null;
   }
	
   public static String conversionStr(String str,char charStr){
	   char[]chars=str.toCharArray(); 
	   byte cs= (byte) charStr;
	   StringBuffer bf=new StringBuffer();
	   for(int i=0;i<chars.length;i++){
		   chars[i]=(char)((int)chars[i]-cs);
		   bf.append(chars[i]);
	    }
	   return bf.toString().trim();
   }
   /*字符串加密*/
	public static byte[] conversionAscii(Object message) {
		char ch[]={'@','?','>','<',':',';','/','.','-','+','*','(',')','!','#','$','&',';','a','b','e','y','g'};
		char key=ch[(int)(Math.random()*ch.length)];
		StringBuffer str=new StringBuffer();
		str.append("\n");
		str.append(key);
		str.append(message.toString());
		str.append("\n");
		byte[] bt=str.toString().getBytes();
		for(int i=0;i<bt.length;i++){
			if(i>2){
				bt[i]=(byte) ((bt[i]+(byte)key)%128);
			}else{
				bt[i]=(byte) (bt[i]);
			}
	    }
		String s=new String(bt);
		return bt;
	}
	
	public static byte[] conversionStr(byte[] bt, char key) {
		  for(int i=0;i<bt.length;i++){
			  if(i>2){
				  bt[i]=(byte)((bt[i]+(byte)key)%128);
				}else{
					bt[i]=(byte) (bt[i]);
				}
	      }
		return bt;
	}
	
	
	public static byte[] byteConversionAscii(byte[] bytes) {
		char ch[]={'@','?','>','<',':',';','/','.','-','+','*','(',')','!','#','$','&',';','a','b','e','y','g','z','x','c','v','b','n','m','q','w','e','r'};
		char key=ch[(int)(Math.random()*ch.length)];
	    byte bt[]=new byte[bytes.length+1];
		bt[0]=(byte) key;
		for(int i=0;i<bytes.length;i++){
			bt[i+1]=(byte)(bytes[i]^(byte)key);
	    }
		String s=new String(bt);
		return bt;
	}
   
}
