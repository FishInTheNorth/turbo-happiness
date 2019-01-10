package util;

import java.io.UnsupportedEncodingException;

public class StringUtil {

	// 将字符串转换为中文utf-8格式
		public static String toCN(String str) {
			if 	(str != null && !"".equals(str)) {
				try {
					return new String(str.getBytes("iso8859-1"), "utf-8");
				} catch (UnsupportedEncodingException ex) {
					return str;
				}
			} else {
				return str;
			}
		}
//判断字符串是否为空
	public static boolean isNull(String str){
			if (str!=null && !str.equals("")){
				return true;
			}
			else
				return  false;
	}
}
