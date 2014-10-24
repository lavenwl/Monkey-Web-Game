package com.stang.game.util;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringEscapeUtils;

import com.stang.game.common.GameConstants;

public class StangUtil {
	/**
	 * 数据库表记录主键值
	 */
	public static String getTablePK() {
		return RandomStringUtils.randomAlphanumeric(10);
	}

	/**
	 * 生成制定位随机数字
	 */
	public static String randomNumeric(int i) {
		return RandomStringUtils.randomNumeric(i);
	}

	/**
	 * 生成制定位随机字母和数字
	 */
	public static String randomAlphanumeric(int i) {
		return RandomStringUtils.randomAlphanumeric(i);
	}

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
				GameConstants.log.warn("", e);
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
				GameConstants.log.warn("", e);
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
	public static List<String> sarrToList(String[] strings) {
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
	public static String listToSarr(List<String> list) {
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
	public static String listToArr(List<String> list) {
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
	 * html特殊字符处理写入
	 * 
	 * @param str
	 *            需要处理的字符串
	 */
	public static String escapeHtml(String str) {
		if (str == null || "".equals(str)) {
			return "";
		}
		return StringEscapeUtils.escapeHtml3(str);
	}

	/**
	 * html特殊字符处理后显示在html
	 * 
	 * @param str
	 *            需要处理的字符串
	 */
	public static String unescapeHtml(String str) {
		if (str == null || "".equals(str)) {
			return "";
		}
		return StringEscapeUtils.unescapeHtml3(str);

	}
}
