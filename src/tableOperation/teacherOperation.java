package tableOperation;

import util.DBUtil;

import java.sql.*;
import java.util.HashMap;

public class teacherOperation {
    private final String TABLE_NAME = "teacher";

    public HashMap select(String teacherId, String teacherName,String password, String major) throws SQLException {
        //查询教师信息
        Connection conn = DBUtil.getConnection();
        ResultSet set = null;
        HashMap<String,Object> map =  new HashMap<>();
        if (conn!=null){
            Statement stmt = conn.createStatement();
            String sql = "select * from " + TABLE_NAME + " where is_use=1";
            if (teacherId != null && !"".equals(teacherId)) {
                sql += " and teacher_id='" + teacherId + "'";
            }
            if (teacherName != null && !"".equals(teacherName)) {
                sql += " and teacher_name like '%" + teacherName + "%'";
            }
            if (major != null && !"".equals(major)) {
                sql += " and major like '%" + major + "%'";
            }
            if(password !=null && !"".equals(password)){
                sql += " and password ='" + password + "'";
            }
            set = stmt.executeQuery(sql);
            System.out.println(sql);
            System.out.println();
        }
        map.put("rs",set);
        map.put("conn",conn);
        return map;
    }
    public int update(String teacherId, String teacherName, String major, String teacherPhone, String teacherQq,int sex) throws SQLException {
        Connection conn = DBUtil.getConnection();
        //修改教师信息
        int result = 0;

        if (conn != null) {
            String sql = "UPDATE " + TABLE_NAME
                    + " set student_name=?, major=?, sex=?,teacer_phone=?,teacher_qq=?  where teacher_id=?";
            PreparedStatement pstmt1 = conn.prepareStatement(sql);
            pstmt1.setString(1, teacherName);
            pstmt1.setString(2, major);
            pstmt1.setInt(3,sex);
            pstmt1.setString(4, teacherPhone);
            pstmt1.setString(5, teacherQq);
            pstmt1.setString(6, teacherId);
            result = pstmt1.executeUpdate();
            System.out.println(sql);
            System.out.println();
        }
        DBUtil.freeConnection(conn);
        return result;
    }

    public int updatePassword(String teacherId, String password) throws SQLException {
        //修改密码
        Connection conn = DBUtil.getConnection();
        int result = 0;

        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE " + TABLE_NAME + " set password = '" + password + "' where teacher_id = '" + teacherId + "'";
            result = stmt.executeUpdate(sql);
            System.out.println(sql);
            System.out.println();
        }
        DBUtil.freeConnection(conn);
        return result;

    }

    public int delete(String teacherId) throws SQLException {
        //删除教师信息
        Connection conn = DBUtil.getConnection();
        int result = 0;
        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE " + TABLE_NAME + " set is_use = 0  where teacher_id = '" + teacherId + "'";
            result = stmt.executeUpdate(sql);
            System.out.println(sql);
            System.out.println();
        }

        DBUtil.freeConnection(conn);
        return result;
    }

}
