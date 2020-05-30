package com.dream.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChineseUtil {
	
	public static boolean isContainChinese(String str) {
		
        Pattern p = Pattern.compile("[\u4E00-\u9FA5|\\！|\\，|\\。|\\（|\\）|\\《|\\》|\\“|\\”|\\？|\\：|\\；|\\【|\\】]");
        
        Matcher m = p.matcher(str);
        
        if (m.find()) {
            return true;
        }
        return false;
    }
}
