package com.drag.and.drop.helper;

public class StringHelper {

	public static boolean isIn(String value, String[] array) {
		for (String in : array) {
			if (value.equals(in)) {
				return true;
			}
		}
		return false;
	}
}
