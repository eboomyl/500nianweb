package com.ayovel.nian.utils;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexReplaceUtils {
	private final static Pattern pattern = Pattern.compile("\\$\\{(.+?)\\}");
	
	public static StringBuffer getReplaceToTarget(String str,Object temp) {
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			String tempKey = str.substring(matcher.start(1), matcher.end(1));
			String replaceStr = null;
			if(temp instanceof Map) {
				Map<String,String> tempValues = (Map<String, String>) temp;
				replaceStr = tempValues.get(tempKey) == null ? "" : tempValues.get(tempKey);
			}
			if(temp instanceof String) {
				replaceStr = temp == null ? "" : temp.toString();
			}
			matcher.appendReplacement(sb, replaceStr);
//			System.out.println(">>>>> replace sequence : " + matcher.group(1));
//			System.out.println(">>>>> index range : (" + matcher.start(1) + ", "+ matcher.end(1) + ")");
//			System.out.println(">>>>> sub : "+ tempKey);
//			System.out.println("-----------------");
		}
		matcher.appendTail(sb);
		return sb;
	}
}
