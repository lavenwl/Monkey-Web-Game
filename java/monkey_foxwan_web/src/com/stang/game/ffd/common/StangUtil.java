package com.stang.game.ffd.common;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class StangUtil {
	/**
	 * 数据库表记录主键值
	 */

	/**
	 * 将字符串数字转化为int型数字
	 * 
	 * @param str被转化字符串
	 * @param defValue转化失败后的默认值
	 * @return int
	 */
	public static int parseInt(String str, int defValue) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return defValue;
		}
	}

	/**
	 * 将字符串数字转化为long型数字
	 * 
	 * @param str被转化字符串
	 * @param defValue转化失败后的默认值
	 * @return long
	 */
	public static long parseLong(String str, long defValue) {
		try {
			return Long.parseLong(str);
		} catch (Exception e) {
			return defValue;
		}
	}

	/**
	 * 将字符串数字转化为double型数字
	 * 
	 * @param str被转化字符串
	 * @param defValue转化失败后的默认值
	 * @return double
	 */
	public static double parseDouble(String str, double defValue) {
		try {
			return Double.parseDouble(str);
		} catch (Exception e) {
			return defValue;
		}
	}

	/**
	 * 检测字符串是否为空
	 */
	public static boolean strIsNull(String str) {
		return ((str == null) || "".equals(str.trim()));
	}

	/**
	 * 按ISO8859-1格式转码
	 */
	public static String unicode(String str) {
		if (str == null) {
			return "";
		} else {
			try {
				str = str.trim();
				str = new String(str.getBytes("ISO8859-1"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return str;
	}

	/**
	 * 去空格，如为null则转化为空字符串
	 */
	public static String trim(String str) {
		if (str == null) {
			return "";
		}
		return str.trim();
	}

	/**
	 * 去空格，如为null则转化为空字符串
	 */
	public static String trimStr(String str) {
		if (str == null || "null".equals(str)) {
			return "";
		}
		return str.trim();
	}

	/**
	 * 将字符串数组转化成中间用逗号分割的字符串 "'a','b','c'"
	 */
	public static String getRecordIds(String[] recordIds) {
		if (recordIds == null || recordIds.length == 0)
			return "";
		if (recordIds.length == 1)
			return recordIds[0];
		StringBuffer ids = new StringBuffer();
		for (int i = 0; i < recordIds.length; i++) {
			if (i == recordIds.length - 1) {
				ids.append("'" + recordIds[i] + "'");
			} else {
				ids.append("'" + recordIds[i] + "'" + ",");
			}
		}
		return ids.toString();
	}

	/**
	 * 将字符串数组转化成中间用逗号分割的字符串 "a,b,c"
	 */
	public static String getStrs(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		StringBuffer ids = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			if (i == strs.length - 1) {
				ids.append(strs[i]);
			} else {
				ids.append(strs[i] + ",");
			}
		}
		return ids.toString();
	}

	/**
	 * 将字符串数组转化成中间用逗号分割的字符串 "a,b,c" 如果为空则用null表示
	 */
	public static String getStrsValue(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		if (strs.length == 1)
			return strs[0];
		StringBuffer ids = new StringBuffer();
		for (int i = 0; i < strs.length; i++) {
			if ("".equals(strs[i])) {
				strs[i] = null;
			}
			if (i == strs.length - 1) {
				ids.append(strs[i]);
			} else {
				ids.append(strs[i] + ",");
			}
		}
		System.out.println("key =   " + ids.toString());
		return ids.toString();
	}

	/**
	 * 处理Url与其参数的组合
	 * 
	 * @param url页面Url
	 * @param param被加入到该Url后的参数
	 * @return 一个完整的Url,包括参数
	 */
	public static String dealUrl(String url, String param) {
		if (url == null || url.length() < 1)
			return "";
		url = url.trim();
		if (param == null || param.length() < 1)
			return url;
		param = param.trim();
		if (url.endsWith("?") || url.endsWith("&")) {
			url = url.substring(0, url.length() - 1);
		}
		if (url.indexOf("?") != -1) {
			if (param.startsWith("&") || param.startsWith("?")) {
				return url + param.substring(1);
			} else {
				return url + "&" + param;
			}
		} else {
			if (param.startsWith("&") || param.startsWith("?")) {
				return url + "?" + param.substring(1);
			} else {
				return url + "?" + param;
			}
		}
	}

	/**
	 * 验证EMAIL方法
	 * 
	 * @param str
	 *            被验证的email字符串
	 * @return 成功返回true 失败返回false
	 */
	public static boolean isEmail(String str) {
		if (str == null)
			return false;
		str = str.trim();
		if (str.length() < 6)
			return false;
		return true;
	}

	/**
	 * 在不足len位的字符串前面自动补零
	 */
	public static String getLimitLenStr(String str, int len) {
		if (str == null) {
			return "";
		}
		while (str.length() < len) {
			str = "0" + str;
		}
		return str;
	}

	/**
	 * 字符串GBK到UTF-8码的转化
	 * 
	 * @param inStr
	 *            GBK编码的字符串
	 * @return UTF-8编码的字符串
	 */
	public static String wapGbkToUtf(String inStr) {
		char temChr;
		int ascInt;
		int i;
		String result = new String("");
		if (inStr == null) {
			inStr = "";
		}
		for (i = 0; i < inStr.length(); i++) {
			temChr = inStr.charAt(i);
			ascInt = temChr + 0;
			if (ascInt > 255) {
				result = result + "&#x" + Integer.toHexString(ascInt) + ";";
			} else {
				if (temChr == '&' || temChr == '"') {
					result = result + "&#x" + Integer.toHexString(ascInt) + ";";
				} else {
					result = result + temChr;
				}
			}
		}
		return result;
	}

	/**
	 * UTF-8编码
	 */
	public static String encodeUTF8(String str) {
		if (str == null || str.equals("")) {
			return null;
		} else {
			String reStr = "";
			try {
				reStr = java.net.URLEncoder.encode(str, "utf-8");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return reStr;
		}
	}

	// 转码
	public static String toUTF(String inStr) {
		char temChr;
		int ascInt;
		int i;
		String result = new String("");
		if (inStr == null) {
			inStr = "";
		}
		for (i = 0; i < inStr.length(); i++) {
			temChr = inStr.charAt(i);
			ascInt = temChr + 0;
			if (ascInt > 255) {
				result = result + "&#x" + Integer.toHexString(ascInt) + ";";
			} else {
				if (temChr == '&') {
					result = result + "&#x" + Integer.toHexString(ascInt) + ";";
				} else {
					result = result + "&#x" + Integer.toHexString(ascInt) + ";";
				}
			}
		}
		return result;
	}

	// 转码
	public static String toUTFWap(String inStr) {
		char temChr;
		int ascInt;
		int i;
		String result = new String("");
		if (inStr == null) {
			inStr = "";
		}
		for (i = 0; i < inStr.length(); i++) {
			temChr = inStr.charAt(i);
			ascInt = temChr + 0;
			if (ascInt > 255) {
				result = result + "&#x" + Integer.toHexString(ascInt) + ";";
			} else {
				if (temChr == '&') {
					result = result + "&#x" + Integer.toHexString(ascInt) + ";";
				} else {
					result = result + temChr;
				}
			}
		}
		return result;
	}

	/**
	 * 特殊字符替换
	 */
	public static String replaceStrHtml(String inStr) {
		String result = inStr;
		if (result != null && "".equals(result)) {
			result = result.replaceAll("\r\n", "<br>");
			result = result.replaceAll(" ", "&nbsp;");
		}
		return result;
	}

	/**
	 * 特殊字符替换
	 */
	public static String replaceStrForWap(String inStr) {
		String result = inStr;
		if (!strIsNull(inStr)) {
			result = result.replaceAll("&amp;", "&");
			result = result.replaceAll("&", "&amp;");
		}
		return result;
	}

	/*
	 * public static void main(String[] args) {
	 * System.out.println(getTablePK()); }
	 */

	public static String HTMLEntityEncode(String s) {
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z' || c >= '0'
					&& c <= '9') {
				buf.append(c);
			} else {
				buf.append("&#" + (int) c + ";");
			}
		}
		return buf.toString();
	}

	/**
	 * 字符串数组转List
	 * 
	 * @param 字符串数组
	 */
	public static List sarrToList(String[] strings) {
		List<String> list = new ArrayList<String>();
		if (strings != null) {
			for (String string : strings) {
				list.add(string);
			}
		}
		return list;
	}

	/**
	 * 字符串数组转单个Long
	 * 
	 * @param 字符串数组
	 */
	public static Long sarrToLong(String[] strings) {
		Long id = null;
		if (strings != null) {
			for (String string : strings) {
				id = parseLong(string, 0);
			}
		}
		return id;
	}

	/**
	 * List转String "'a','b','c'"
	 */
	public static String listToSarr(List list) {
		String stringArr = "";
		for (int i = 0; i < list.size(); i++) {
			stringArr = stringArr + "'" + list.get(i) + "'" + ",";
		}

		if (stringArr.endsWith(",")) {
			stringArr = stringArr.substring(0, stringArr.length() - 1);
		}
		return stringArr;
	}

	/**
	 * List转String "a,b,c"
	 */
	public static String listToArr(List list) {
		String stringArr = "";
		for (int i = 0; i < list.size(); i++) {
			stringArr = stringArr + "" + list.get(i) + "" + ",";
		}

		if (stringArr.endsWith(",")) {
			stringArr = stringArr.substring(0, stringArr.length() - 1);
		}
		return stringArr;
	}

	/**
	 * byte数组转int.
	 * 
	 * @param b
	 *            要转换的byte数组
	 * @return 转换结果
	 */
	public static int byte2int(byte[] b) {
		return ByteBuffer.wrap(b).getInt();
	}

	/**
	 * int转byte数组
	 * 
	 * @param i
	 *            要转换的int值
	 * @return 转换的结果
	 */
	public static byte[] int2byte(int i) {
		// 用4个字节保存int
		ByteBuffer buff = ByteBuffer.allocate(4);
		buff.putInt(i);
		return buff.array();
	}
	
	/**
     * ip地址转成整数.
     * @param ip
     * @return
     */
    public static long ip2long(String ip) {
    	String[] ips = ip.split("[.]");
    	long num =  16777216L*Long.parseLong(ips[0]) + 65536L*Long.parseLong(ips[1]) + 256*Long.parseLong(ips[2]) + Long.parseLong(ips[3]);
    	return num;
    }
    
    /**
     * 整数转成ip地址.
     * @param ipLong
     * @return
     */
    public static String long2ip(long ipLong) {
    	//long ipLong = 1037591503;
    	long mask[] = {0x000000FF,0x0000FF00,0x00FF0000,0xFF000000};
    	long num = 0;
    	StringBuffer ipInfo = new StringBuffer();
    	for(int i=0;i<4;i++){
    		num = (ipLong & mask[i])>>(i*8);
    		if(i>0) ipInfo.insert(0,".");
    		ipInfo.insert(0,Long.toString(num,10));
    	}
    	return ipInfo.toString();
    }

    //HTML 敏感字符过滤
    public static String toHtml(String str){
    	final String[] htmlKeys1 = new String[5];
    	final String[] htmlKeys2 = new String[5];
    	htmlKeys1[0] = "&";
    	htmlKeys1[1] = "\"";
    	htmlKeys1[2] = "'";
    	htmlKeys1[3] = "<";
    	htmlKeys1[4] = ">";
    	htmlKeys2[0] = "&amp;";
    	htmlKeys2[1] = "&quot;";
    	htmlKeys2[2] = "&apos;";
    	htmlKeys2[3] = "&lt;";
    	htmlKeys2[4] = "&gt;";
    	
    	for(int i=0;i<htmlKeys1.length;i++){
    		str = str.replaceAll(htmlKeys1[i],htmlKeys2[i]);
		}
    	return str; 
    }
}
