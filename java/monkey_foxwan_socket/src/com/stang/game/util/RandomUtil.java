package com.stang.game.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author fei_wei
 * @company 上海源傲实业有限公司
 * @description 随机码产生函数
 */
public class RandomUtil {

	public static final String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String letterChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String numberChar = "0123456789";

	/**
	 * @method RandomArray
	 * @param count
	 *            {int} 随机数个数
	 * @param digit
	 *            {int} 随机数位数
	 * @param separator
	 *            {String} 生成的随机数中数字之间的分隔符
	 * @return {List<String>}
	 * @description 按照随机数个数、位数、分隔符生成随机数列表
	 */
	public static List<String> RandomArray(int count, int digit,
			String separator) {
		List<String> list = new ArrayList<String>();

		if (count > 0 && digit > 0) {
			Random random = new Random();
			for (int i = 0; i < count; i++) {
				String no = "";
				for (int j = 0; j < digit; j++) {
					no = no + random.nextInt(9) + separator;
				}
				list.add(no);
			}
		}

		return list;
	}

	/**
	 * @method RandomArray2
	 * @param count
	 *            {int} 随机数个数
	 * @param digit
	 *            {int} 随机数位数
	 * @param separator
	 *            {String} 生成的随机数中数字之间的分隔符
	 * @return {List<String>}
	 * @description 按照随机数个数、位数、分隔符生成随机数列表【每个随机字符串的前三位为三个字母组成的字符串】
	 */
	public static List<String> RandomArray2(int count, int digit,
			String separator) {
		List<String> list = new ArrayList<String>();

		if (count > 0 && digit > 0) {
			Random random = new Random();
			for (int i = 0; i < count; i++) {
				String no = "";
				for (int j = 0; j < digit; j++) {
					no = no + random.nextInt(9) + separator;
				}
				list.add(generateUpperString(3) + no);
			}
		}

		return list;
	}

	/**
	 * @method RandomArray3
	 * @param count
	 *            {int} 随机数个数
	 * @param num_digit
	 *            {int} 随机数数字位数
	 * @param char_digit
	 *            {int} 随机数字符位数
	 * @param sort
	 *            {int} 排列顺序【0,字符串在前;1,数字在前】
	 * @param separator
	 *            {String} 生成的随机数中数字之间的分隔符
	 * @return {List<String>}
	 * @description 按照随机数个数、位数、分隔符生成随机数列表【每个随机字符串的前三位为三个字母组成的字符串】
	 */
	public static List<String> RandomArray3(int count, int num_digit,
			int char_digit, int sort, String separator) {
		List<String> list = new ArrayList<String>();
		if (count > 0 && (num_digit > 0 || char_digit > 0)) {
			Random random = new Random();
			for (int i = 0; i < count; i++) {
				String no = "";
				for (int j = 0; j < num_digit; j++) {
					no = no + random.nextInt(9) + separator;
				}

				if (sort == 0) {
					no = generateOnlyString(char_digit).toUpperCase()
							+ separator + no;
				} else {
					no = no + separator
							+ generateOnlyString(char_digit).toUpperCase();
				}

				list.add(no);
			}
		}
		return list;
	}

	/**
	 * 返回一个定长的随机纯字母字符串(只包含大小写字母)
	 * 
	 * @param length
	 *            随机字符串长度
	 * @return 随机字符串
	 */
	public static String generateMixString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(allChar.charAt(random.nextInt(letterChar.length())));
		}
		return sb.toString();
	}

	/**
	 * @method generateLowerString
	 * @param length
	 *            随机字符串长度
	 * @return 随机字符串
	 * @description 返回一个定长的随机纯小写字母字符串(只包含大小写字母)
	 */
	public static String generateLowerString(int length) {
		return generateMixString(length).toLowerCase();
	}

	/**
	 * @method generateUpperString
	 * @param length
	 *            随机字符串长度
	 * @return 随机字符串
	 * @description 返回一个定长的随机纯大写字母字符串(只包含大小写字母)
	 */
	public static String generateUpperString(int length) {
		return generateMixString(length).toUpperCase();
	}

	/**
	 * @method generateOnlyString
	 * @param length
	 *            随机字符串长度
	 * @return 随机字符串
	 * @description 只返回一个定长的随机字母字符串
	 */
	public static String generateOnlyString(int length) {
		StringBuffer sb = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			sb.append(letterChar.charAt(random.nextInt(letterChar.length())));
		}
		return sb.toString();
	}
}
