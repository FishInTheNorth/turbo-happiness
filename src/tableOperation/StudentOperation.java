package tableOperation;

import util.DBUtil;

import java.sql.*;
import java.util.HashMap;

public class StudentOperation {
    private final String TABLE_NAME = "student";

    public HashMap select(String studentId, String studentName,String password, String major) throws SQLException {
        //查询学生信息
        Connection conn = DBUtil.getConnection();
        ResultSet set = null;
        HashMap<String,Object> map =  new HashMap<>();
        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "select * from " + TABLE_NAME + " where is_use=1";
            if (studentId != null && !"".equals(studentId)) {
                sql += " and student_id='" + studentId + "'";
            }
            if (studentName != null && !"".equals(studentName)) {
                sql += " and student_name like '%" + studentName + "%'";
            }
            if (major != null && !"".equals(major)) {
                sql += " and major like '%" + major + "%'";
            }
            if(password !=null && !"".equals(password)){
                sql += " and password ='" + password + "'";
            }
            System.out.println(sql);
            set = stmt.executeQuery(sql);
            System.out.println();
        }
        map.put("rs",set);
        map.put("conn",conn);
        return map;
    }

    public int update(String studentId, String studentName, String major, String studentPhone, String studentQq,int sex) throws SQLException {
        //更新学生信息
        Connection conn = DBUtil.getConnection();
        int result = 0;

        if (conn != null) {
            String sql = "UPDATE " + TABLE_NAME + " set student_name=?, major=?, sex=?,student_phone=?,student_qq=?  where student_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, studentName);
            pstmt.setString(2, major);
            pstmt.setInt(3,sex);
            pstmt.setString(4, studentPhone);
            pstmt.setString(5, studentQq);
            pstmt.setString(6, studentId);
            result = pstmt.executeUpdate();
            System.out.println(sql);
            System.out.println();
        }
        DBUtil.freeConnection(conn);
        return result;
    }

    public int updatePassword(String studentId, String password) throws SQLException {
        //修改密码
        Connection conn = DBUtil.getConnection();
        int result = 0;

        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE " + TABLE_NAME + " set password = '" + password + "' where student_id = '" + studentId + "'";
            result = stmt.executeUpdate(sql);
            System.out.println(sql);
            System.out.println();
        }
        DBUtil.freeConnection(conn);
        return result;

    }

    public int updateGrade(String studentId, float grade) throws SQLException {
        //添加成绩
        Connection conn = DBUtil.getConnection();
        int result = 0;

        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE " + TABLE_NAME + " set grade = " + grade + " where student_id = '" + studentId + "'";
            result = stmt.executeUpdate(sql);
            System.out.println(sql);
            System.out.println();
        }
        DBUtil.freeConnection(conn);
        return result;

    }

    public int delete(String studentId) throws SQLException {
        //删除学生信息
        Connection conn = DBUtil.getConnection();
        int result = 0;
        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE " + TABLE_NAME + " set is_use = 0 where student_id = '" + studentId + "'";
            result = stmt.executeUpdate(sql);
            System.out.println(sql);
            System.out.println();
        }

        DBUtil.freeConnection(conn);
        return result;
    }

}
