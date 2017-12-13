package com.yewei.utils;

public class YeweiStringUtils {

	public static boolean isTrimEmpty(String str) {
		return str == null || str.isEmpty() || str.trim().isEmpty();
	}

	public static boolean isNotTrimEmpty(String str) {
		return !isTrimEmpty(str);
	}

	public static boolean isEmpty(String str) {
		return str == null || str.isEmpty();
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
}
