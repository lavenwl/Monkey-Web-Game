package com.stang.game.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.stang.game.common.GameConstants;

/**
 * @author fei_wei
 * @company 上海三唐信息科技有限公司
 * @description 资源文件处理
 */
public class PropertiesUtil {

	/**
	 * @method readValue
	 * @param filePath
	 *            {String} 配置文件路径
	 * @param key
	 *            {String} 键值
	 * @return {String}
	 * @description 根据key读取value
	 */
	public static String readValue(String filePath, String key) {
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			props.load(in);
			String value = props.getProperty(key);
			System.out.println(key + value);
			return value;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
			return null;
		}
	}

	/**
	 * @method readProperties
	 * @param filePath
	 *            {String} 配置文件路径
	 * @return {Properties}
	 * @description 根据配置文件路径和键名称数组获取配置信息
	 */
	public static Properties readProperties(String filePath) {
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			props.load(in);
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		}
		return props;
	}

	/**
	 * @method writeProperties
	 * @param filePath
	 *            {String} 配置文件路径
	 * @param parameterName
	 *            {String} 键名称
	 * @param parameterValue
	 *            {String} 键所对应的值
	 * @return {boolean}
	 * @description 写入properties信息
	 */
	public static boolean writeProperties(String filePath,
			String parameterName, String parameterValue) {

		boolean res = false;

		Properties prop = new Properties();
		try {
			InputStream fis = new FileInputStream(filePath);
			// 从输入流中读取属性列表（键和元素对）
			prop.load(fis);
			// 调用 Hashtable 的方法 put。使用 getProperty 方法提供并行性。
			// 强制要求为属性的键和值使用字符串。返回值是 Hashtable 调用 put 的结果。
			OutputStream fos = new FileOutputStream(filePath);
			prop.setProperty(parameterName, parameterValue);
			// 以适合使用 load 方法加载到 Properties 表中的格式，
			// 将此 Properties 表中的属性列表（键和元素对）写入输出流
			prop.store(fos, "Update '" + parameterName + "' value");
		} catch (IOException e) {
			System.err.println("Visit " + filePath + " for updating "
					+ parameterName + " value error");
		}
		return res;
	}
}
