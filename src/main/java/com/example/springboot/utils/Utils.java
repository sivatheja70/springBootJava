package com.example.springboot.utils;

public class Utils {
	public static Boolean compareTwoValues(String old, String newVal) {
	
		
			if(old != null && !old.isEmpty() && newVal != null && !newVal.isEmpty()) {
				if(old.equalsIgnoreCase(newVal)) {
					return true;
				}else {
					return false;
				}
			}else {
				return false;
			}
	}
	
	public static Long getLongValueForObject(Object obj) {
		if(obj != null) {
			return Long.valueOf(obj.toString());
		}else {
			return (long) 0;
		}
		
	}
	public static String getStringValueForObject(Object obj) {
		if(obj != null && obj != "") {
			return obj.toString();
		}else {
			return "";
		}
	}
	public static Integer getIntegerValueForObject(Object obj) {
		if(obj != null) {
			return Integer.valueOf(obj.toString());
		}else {
			return 0;
		}
		
	}
}
