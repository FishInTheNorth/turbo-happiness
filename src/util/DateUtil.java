package util;

import java.util.Date;

public class DateUtil {

	public static String GetStr(Date date) {
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	public static Date StrToDate(String s){
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		try {
			date = sdf.parse(s);

		}catch (Exception e){
			e.printStackTrace();
		}
		return date;
	}
}
