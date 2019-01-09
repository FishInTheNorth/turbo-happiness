package util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class JudgeUtil {
    public static String judgeTable(String name){
        //判断为实习、实践、实训
        String m = "";
        if (name.equals("1")){
           m = "shixi";
        }
        if(name.equals("2")){
            m = "shixun";
        }
        if (name.equals("3")){
           m = "shijian";
        }
        return m;
    }
    public static String judgeUser(String name){
        //判断用户类型
        String m = "";

        if (name.equals("1")){
            m = "student";
        }
        if(name.equals("2")){
            m = "teacher";
        }
         if (name.equals("3")){
            m = "admin";
        }
        return m;
    }
}
