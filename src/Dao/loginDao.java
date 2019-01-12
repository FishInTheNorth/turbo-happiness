package Dao;

import tableOperation.*;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class loginDao {
    HashMap<String,Object> map = null; //用于接收从数据库查询到的HashMap
    ResultSet rs = null;  // 用于接收从得到的HashMap中的结果集
    HashMap<String,Object> map1 = new HashMap<>(); //将处理的结果、用户id等传递给loginServlet
    int result = 0;

    public HashMap check(String username, String password, String type) throws SQLException {
        if (type.equals("student")){ //若为学生
            studntLogin(username,password);
        }
        else if (type.equals("teacher")){ //若为教师
            teacherLogin(username, password);
        }
        else if (type.equals("admin")){  //若为管理员
            adminLogin(username, password);
        }

        map1.put("result",result);  //将查询结果放入map1中
        DBUtil.freeConnection((Connection)map.get("conn"));
        return map1;
    }
    public void studntLogin(String username,String password) throws  SQLException{
        studentOperation student = new studentOperation();  //创建学生表的操作
        map = student.select(username,"",password,"");  //查询该学生
        rs = (ResultSet) map.get("rs");  //从返回的map中得到结果集

        resultNum(rs);
        if (result== 0) return;  //若未查到直接退出

        map1.put("userName",rs.getString("student_name")); //将学生姓名加入到要传递的map中
        map1.put("id",rs.getString("student_id")); //将学生ID加入到要传递的map中

//        stduentTrainOperation st = new stduentTrainOperation();  //获得学生实训表的操作对象
////
////        ResultSet str = (ResultSet)st.select(0,rs.getString("student_id")).get("rs");  //获得查询的实训结果集
////        if (!str.next()) return; //若未查到直接退出
////        rs.last();
//        map1.put("trainId",rs.getInt("train_id")); //将实训号传递放入要传递的map中
    }
    public void teacherLogin(String username,String password) throws  SQLException{
        teacherOperation teacher = new teacherOperation(); //创建教师表操作
        map = teacher.select(username,"",password,"");  //查询该教师

        rs = (ResultSet)map.get("rs");  //从返回的map中得到结果集
        resultNum(rs);
        if (result== 0) return; //若未查到直接退出

        map1.put("userName",rs.getString("teacher_name")); //将教师姓名加入到要传递的map中
        map1.put("id",rs.getString("teacher_id"));//将教师ID加入到要传递的map中
    }
    public void adminLogin(String username,String password) throws  SQLException{
        adminOperation admin = new adminOperation(); //创建管理员表操作
        map = admin.select(username,password); //查询该管理员

        rs = (ResultSet)map.get("rs");  //从返回的map中得到结果集
        resultNum(rs);
        if (result== 0) return; //若未查到直接退出

        map1.put("userName",rs.getString("admin_name")); //将管理员姓名加入到要传递的map中
        map1.put("id",rs.getString("admin_id"));//将管理员ID加入到要传递的map中
    }
    public void resultNum(ResultSet set){ //获得查询结果
        result = 0;
        try {
            if(set.next()){
                result = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
