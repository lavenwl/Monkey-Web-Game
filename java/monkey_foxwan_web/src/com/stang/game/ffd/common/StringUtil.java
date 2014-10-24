package com.stang.game.ffd.common;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author jianbo.feng
 * @company 上海三唐信息科技有限公司 
 * @description 字符串处理
 */
public class StringUtil {

	/**
	 * @method uriEncode
	 * @param src {String} 源字符串
	 * @param format {String} 编码格式
	 * @return {String}
	 * @description 根据编码格式进行URI编码
	 */
	public static String uriEncode(String src,String format) {
		try {
			if(src == null) {
				src = "";
			}
			else {
				src = URLEncoder.encode(src,format);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return src;
	}
	
	/**
	 * @method uriDecode
	 * @param src {String} 源字符串
	 * @param format {String} 编码格式
	 * @return {String}
	 * @description 根据编码格式进行URI解码
	 */
	public static String uriDecode(String src,String format) {
		try {
			if(src == null) {
				src = "";
			}
			else {
				src = URLDecoder.decode(src,format);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return src;
	}
	
	/**
	 * @method crypt
	 * @param str String to encode
	 * @return Encoded String
	 * @throws NoSuchAlgorithmException
	 * @description 字符串(MD5)加密
	 */
	public static String crypt(String str) {
		if (str == null || str.length() == 0) {
			throw new IllegalArgumentException("String to encript cannot be null or zero length");
		}
		
		StringBuffer hexString = new StringBuffer();
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] hash = md.digest();
			
			for (int i = 0; i < hash.length; i++) {
				if ((0xff & hash[i]) < 0x10) {
					hexString.append("0" + Integer.toHexString((0xFF & hash[i])));
				}				
				else {
					hexString.append(Integer.toHexString(0xFF & hash[i]));
				}				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return hexString.toString();
	}
	
}
