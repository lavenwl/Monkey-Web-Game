package com.stang.game.common;

import java.io.InputStream;
import java.util.Properties;

public class Config {
	private static boolean isFrist = true;
	private static Properties keyProps = new Properties();

	public static String getConfig(String key) {
		if (isFrist) {
			InputStream is = new Config().getClass().getResourceAsStream(
					"conf.properties");
			try {
				keyProps.load(is);
			} catch (Exception e) {
				System.err.println("不能读取属性文件。请确保key.properties在你的CLASSPATH中");
				return "无法获知KEY，请联系运营商";
			}
		}
		return (String) keyProps.get(key);
	}

	public static void main(String a[]) {
		System.out.println(getConfig("serverip"));
		System.out.println(getConfig("chatip"));
	}
}
