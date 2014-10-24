package com.stang.game.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.stang.game.common.GameConstants;

/**
 * @author fei_wei
 * @company 上海三唐信息科技有限公司
 * @description 时间处理
 */
public class DateUtil {

	/**
	 * @method getDaysBetween
	 * @param date1
	 *            {java.util.Date}
	 * @param date2
	 *            {java.util.Date}
	 * @return {int}
	 * @description 获得两个时间的相隔天数
	 */
	public static int getDaysBetween(java.util.Date date1, java.util.Date date2) {
		long days = 0;
		long l1 = date1.getTime();
		long l2 = date2.getTime();
		if (l1 == l2) {
			days = 0;
		} else if (l1 > l2) {
			long _l = l2 - l1;
			days = _l / (1000 * 60 * 60 * 24);
		} else {
			long _l = l1 - l2;
			days = _l / (1000 * 60 * 60 * 24);
		}
		if (days < 0) {
			days = days * -1;
		}
		return (int) Math.ceil((double) days);
	}

	/**
	 * @method getDateBySeconds
	 * @param days
	 *            {int} 秒钟数(必须为整数，可以为正数也可为负数)
	 * @return {java.util.Date}
	 * @description 根据秒钟数获得之前多少秒钟的相应时间
	 */
	public static java.util.Date getDateBySeconds(java.util.Date date,
			int seconds) {
		java.util.Date destDate = null;

		try {
			if (seconds != 0) {
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				c.add(Calendar.SECOND, seconds);
				destDate = c.getTime();
			} else {
				destDate = date;
			}
		} catch (Exception e) {
		}
		return destDate;
	}

	/**
	 * @method getDateByMinutes
	 * @param days
	 *            {int} 分钟数(必须为整数，可以为正数也可为负数)
	 * @return {java.util.Date}
	 * @description 根据分钟数获得之前多少分钟的相应时间
	 */
	public static java.util.Date getDateByMinutes(java.util.Date date,
			int minutes) {
		java.util.Date destDate = null;
		try {
			if (minutes != 0) {
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				c.add(Calendar.MINUTE, minutes);
				destDate = c.getTime();
			} else {
				destDate = date;
			}
		} catch (Exception e) {
		}
		return destDate;
	}

	/**
	 * @method getDateByHours
	 * @param hours
	 *            {int} 小时数(必须为整数，可以为正数也可为负数)
	 * @return {java.util.Date}
	 * @description 根据分钟数获得之前多少小时的相应时间
	 */
	public static java.util.Date getDateByHours(java.util.Date date, int hours) {
		java.util.Date destDate = null;

		try {
			if (hours != 0) {
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				c.add(Calendar.HOUR, hours);
				destDate = c.getTime();
			} else {
				destDate = date;
			}
		} catch (Exception e) {
		}
		return destDate;
	}

	/**
	 * @method getDateByDays
	 * @param days
	 *            {int} 天数(必须为整数，可以为正数也可为负数)
	 * @return {java.util.Date}
	 * @description 根据天数获得之前多少天的相应时间
	 */
	public static java.util.Date getDateByDays(java.util.Date date, int days) {
		java.util.Date destDate = null;

		try {
			if (days != 0) {
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				c.add(Calendar.DATE, days);
				destDate = c.getTime();
			} else {
				destDate = date;
			}
		} catch (Exception e) {
		}
		return destDate;
	}

	/**
	 * @method getDateByDays
	 * @param months
	 *            {int} 月数(必须为整数，可以为正数也可为负数)
	 * @return {java.util.Date}
	 * @description 根据月数获得之前多少月的相应时间
	 */
	public static java.util.Date getDateByMonths(java.util.Date date, int months) {
		java.util.Date destDate = null;

		try {
			if (months != 0) {
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				c.add(Calendar.MONTH, months);
				destDate = c.getTime();
			} else {
				destDate = date;
			}
		} catch (Exception e) {
		}
		return destDate;
	}

	/**
	 * @method getDateByYears
	 * @param months
	 *            {int} 年数(必须为整数，可以为正数也可为负数)
	 * @return {java.util.Date}
	 * @description 根据年数获得之前多少年的相应时间
	 */
	public static java.util.Date getDateByYears(java.util.Date date, int years) {
		java.util.Date destDate = null;
		try {
			if (years != 0) {
				Calendar c = Calendar.getInstance();
				c.setTime(date);
				c.add(Calendar.YEAR, years);
				destDate = c.getTime();
			} else {
				destDate = date;
			}
		} catch (Exception e) {
		}
		return destDate;
	}

	/**
	 * @method javaDateToSqlDate
	 * @param jDate
	 *            {java.util.Date}
	 * @return {java.sql.Date}
	 * @description Java的时间转换成数据库时间
	 */
	public static java.sql.Date javaDateToSqlDate(java.util.Date jDate) {
		return new java.sql.Date(jDate.getTime());
	}

	/**
	 * @method javaDateToSqlTime
	 * @param jDate
	 *            {java.util.Date}
	 * @return {java.sql.Time}
	 * @description Java的时间转换成数据库Time
	 */
	public static java.sql.Time javaDateToSqlTime(java.util.Date jDate) {
		return new java.sql.Time(jDate.getTime());
	}

	/**
	 * @method javaDateToSqlTimestamp
	 * @param jDate
	 *            {java.util.Date}
	 * @return {java.sql.Timestamp}
	 * @description Java的时间转换成数据库Timestamp
	 */
	public static java.sql.Timestamp javaDateToSqlTimestamp(java.util.Date jDate) {
		return new java.sql.Timestamp(jDate.getTime());
	}

	/**
	 * @method sqlDateToJavaDate
	 * @param sDate
	 *            {java.sql.Date} 数据库时间
	 * @return {java.util.Date}
	 * @description 数据库时间转换成Java时间
	 */
	public static java.util.Date sqlDateToJavaDate(java.sql.Date sDate) {
		return new java.util.Date(sDate.getTime());
	}

	/**
	 * @method sqlTimeToJavaDate
	 * @param sTime
	 *            {java.sql.Time} 数据库时间
	 * @return {java.util.Date}
	 * @description 数据库时间转换成Java时间
	 */
	public static java.util.Date sqlTimeToJavaDate(java.sql.Time sTime) {
		return new java.util.Date(sTime.getTime());
	}

	/**
	 * @method sqlTimeToJavaDate
	 * @param sTimestamp
	 *            {java.sql.Timestamp} 数据库时间
	 * @return {java.util.Date}
	 * @description 数据库时间转换成Java时间
	 */
	public static java.util.Date sqlTimestampToJavaDate(
			java.sql.Timestamp sTimestamp) {
		return new java.util.Date(sTimestamp.getTime());
	}

	/**
	 * @method dateFormat
	 * @param jDate
	 *            {java.util.Date}
	 * @param format
	 *            {String} 解析格式(例如：format)
	 * @return {java.util.Date}
	 * @description 根据解析格式解析Java时间
	 */
	public static java.util.Date dateFormat(java.util.Date jDate, String format) {

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);
			jDate = dateFormat.parse(jDate.toString());
		} catch (ParseException e) {
			GameConstants.log.warn("", e);
		}

		return jDate;
	}

	/**
	 * @method dateFormat
	 * @param sDate
	 *            {java.sql.Date}
	 * @param format
	 *            {String} 解析格式(例如："yyyy-MM-dd HH:mm:ss")
	 * @return {java.util.Date}
	 * @description 根据解析格式解析数据库时间，并返回Java类型时间
	 */
	public static java.util.Date dateFormat(java.sql.Date sDate, String format) {
		java.util.Date tmpDate = new java.util.Date(sDate.getTime());
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(format);

			tmpDate = dateFormat.parse(tmpDate.toString());
		} catch (ParseException e) {
			GameConstants.log.warn("", e);
		}

		return tmpDate;
	}

	/**
	 * @method convertDateToString
	 * @param jDate
	 *            {java.util.Date}
	 * @param format
	 *            {String}
	 * @return {String}
	 * @description 根据解析格式转换java时间为字符串
	 */
	public static String convertDateToString(java.util.Date jDate, String format) {
		return new SimpleDateFormat(format).format(jDate);
	}

	/**
	 * @method convertDateToString
	 * @param sDate
	 *            {java.sql.Date}
	 * @param format
	 *            {String}
	 * @return {String}
	 * @description 根据解析格式转换数据库时间为字符串
	 */
	public static String convertDateToString(java.sql.Date sDate, String format) {
		return new SimpleDateFormat(format).format(sDate);
	}

	/**
	 * @method convertStringToJDate
	 * @param dateString
	 *            {String} 时间字符串(例如："2008-08-08 00:00:00")
	 * @param format
	 *            {String} 解析格式(例如："yyyy-MM-dd HH:mm:ss")
	 * @return {java.util.Date}
	 * @description 根据解析格式将时间字符串转换成java类型的时间
	 */
	public static java.util.Date convertStringToJDate(String dateString,
			String format) {
		java.util.Date jDate = null;
		try {
			jDate = new SimpleDateFormat(format).parse(dateString);
		} catch (ParseException e) {

		}
		return jDate;
	}

	/**
	 * @method convertStringToSDate
	 * @param dateString
	 *            {String} 时间字符串(例如："2008-08-08 00:00:00")
	 * @param format
	 *            {String} 解析格式(例如："yyyy-MM-dd HH:mm:ss")
	 * @return {java.sql.Date}
	 * @description 根据解析格式将时间字符串转换成数据库时间
	 */
	public static java.sql.Date convertStringToSDate(String dateString,
			String format) {
		java.sql.Date sDate = null;

		try {
			sDate = new java.sql.Date(new SimpleDateFormat(format).parse(
					dateString).getTime());
		} catch (ParseException e) {
			GameConstants.log.warn("", e);
		}

		return sDate;
	}
}
