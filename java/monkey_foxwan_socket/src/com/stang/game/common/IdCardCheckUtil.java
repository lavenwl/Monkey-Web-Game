package com.stang.game.common;

public class IdCardCheckUtil {
	public static String fixPersonIDCode(String personIDCode) {
		// String retIDCode = "";
		if (personIDCode == null || personIDCode.trim().length() != 15) {
			return personIDCode;
		}
		String id17 = personIDCode.substring(0, 6) + "19"
				+ personIDCode.substring(6, 15); // 15为身份证补\'19\'

		char[] code = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' }; // 11个
		int[] factor = { 0, 2, 4, 8, 5, 10, 9, 7, 3, 6, 1, 2, 4, 8, 5, 10, 9, 7 }; // 18个;
		int[] idcd = new int[18];
		int i;
		int j;
		int sum;
		int remainder;

		for (i = 1; i < 18; i++) {
			j = 17 - i;
			idcd[i] = Integer.parseInt(id17.substring(j, j + 1));
		}

		sum = 0;
		for (i = 1; i < 18; i++) {
			sum = sum + idcd[i] * factor[i];
		}
		remainder = sum % 11;
		String lastCheckBit = String.valueOf(code[remainder]);
		return id17 + lastCheckBit;
	}

	/**
	 * 判断是否是有效的18位居民身份证号码
	 * 
	 * @param identityId：18位居民身份证号码
	 * @return：true： 有效的18位居民身份证号码
	 */
	public static boolean isIdentityId(String identityId) {
		if (isEmpty(identityId))
			return false;
		try {
			if (identityId.length() == 18) {
				String identityId15 = identityId.substring(0, 6)
						+ identityId.substring(8, 17);
				// System.out.println("the identityId15 is : "+identityId15);
				if (fixPersonIDCode(identityId15).equalsIgnoreCase(identityId)) {
					return true;
				} else {
					return false;
				}
			} else if (identityId.length() == 15) {
				try {
					Long.parseLong(identityId);
					return true;
				} catch (Exception ex) {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}
	}

	/**
	 * 判断是否为空串""
	 */
	public static boolean isEmpty(String sValue) {
		if (sValue == null)
			return true;
		return sValue.trim().equals("") ? true : false;
	}
}
