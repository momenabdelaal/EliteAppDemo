package com.mobily.elite.appUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegexUtils {
	public static long onlyGetNum(String str) {
		String regEx="[^0-9]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		String num = m.replaceAll("").trim();
		return Integer.parseInt(num);
	}

	public static boolean isNumeric(String str){
		Pattern pattern = Pattern.compile("[0-9]*");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
			return false;
		}
		return true;
	}


	public static boolean isNumer(String str){
		Pattern pattern = Pattern.compile("^[-+]?\\d*\\.?\\d*$");
		Matcher isNum = pattern.matcher(str);
		if( !isNum.matches() ){
			return false;
		}
		return true;
	}

	 
	public static boolean isMobileNum(String mobiles) {
		String regex = "1[3|5|7|8|][0-9]{9}";
		return mobiles.matches(regex);
	}



}
