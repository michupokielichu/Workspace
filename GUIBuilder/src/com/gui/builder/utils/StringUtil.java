package com.gui.builder.utils;

public class StringUtil {
	public static boolean isEmpty(String str) {
		return str.trim().isEmpty();
	}
	
	public static boolean isNull(String str) {
		return str == null;
	}
	
	public static boolean isNullOrEmpty(String str) {
		return isNull(str) || isEmpty(str);
	}
}
