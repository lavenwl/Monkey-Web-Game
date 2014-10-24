package com.stang.game.util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import com.stang.game.common.GameConstants;

/**
 * @author fei_wei
 * @company 上海三唐信息科技有限公司
 * @description Properties文件操作工具类
 */
public class PropertyUtil {

	/**
	 * @method readValueByKey
	 * @param filePath
	 *            {String} 文件路径
	 * @param key
	 *            {String} 键值
	 * @return {String}
	 * @description 根据键读取对应值
	 */
	public static String readValueByKey(String filePath, String key) {
		String value = "";
		try {
			Properties props = new Properties();
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			props.load(in);
			value = props.getProperty(key);
			in.close();
			props = null;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		}
		return StangUtil.trimStr(value);
	}

	/**
	 * @method readProperties
	 * @param filePath
	 *            {String} 文件路径
	 * @return {List<String[]>}
	 * @description 根据文件路径读取所有键-值，并返回列表
	 */
	public static List<String[]> readProperties(String filePath) {

		List<String[]> list = new ArrayList<String[]>();

		try {
			Properties props = new Properties();
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			props.load(in);
			Enumeration<?> en = props.propertyNames();
			while (en.hasMoreElements()) {
				list.add(new String[] {
						(String) en.nextElement(),
						StangUtil.trimStr(props.getProperty((String) en
								.nextElement())) });
			}
			en = null;
			in.close();
			props = null;
		} catch (Exception e) {
			GameConstants.log.warn("", e);
		}
		return list;
	}

	/**
	 * @method writeProperty
	 * @param filePath
	 *            {String} 文件路径
	 * @param key
	 *            {String} 键
	 * @param value
	 *            {String} 值
	 * @return {boolean}
	 * @description 向文件中写入键值对(内容)
	 */
	public static boolean writeProperty(String filePath, String key,
			String value) {
		boolean _res = false;
		try {
			Properties prop = new Properties();
			InputStream fis = new FileInputStream(filePath);
			prop.load(fis);
			OutputStream fos = new FileOutputStream(filePath);
			prop.setProperty(key, value);
			prop.store(fos, "Update '" + key + "' value");
			_res = true;
		} catch (IOException e) {
			GameConstants.log.warn("", e);
		}
		return _res;
	}
}
