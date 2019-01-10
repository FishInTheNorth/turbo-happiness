package Dao;
import bean.teacherBean;
import util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class teacherDao {
    public int Inquire(String userId, String oldPassword) throws SQLException {

        Connection conn;
        conn = DBUtil.getConnection();
        String sql = "select * from teacher where teacher_id = ? and password = ?";
        int i = -1;
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pstmt.setString(1, userId);
        pstmt.setString(2, oldPassword);
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            i = 0;
        }
        return i;
    }

    public int updatePassword(String userId, String newPassword) throws SQLException {
        Connection conn;
        conn = DBUtil.getConnection();
        String sql = "update teacher set password = ? where teacher_id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pstmt.setString(1, newPassword);
        pstmt.setString(2, userId);
        int rs = pstmt.executeUpdate();
        return rs;
    }

    public int Edit(teacherBean teacherBean) throws SQLException {
        Connection conn;
        conn = DBUtil.getConnection();
        String sql = "update teacher set teacher_name = ?,major = ?,teacher_phone = ?,teacher_qq = ?,sex = ? where teacher_id = ?";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        pstmt.setString(1, teacherBean.getTeacherName());
        pstmt.setString(2, teacherBean.getMajor1());
        pstmt.setString(3, teacherBean.getTeacherPhone());
        pstmt.setString(4, teacherBean.getTeaherQq());
        pstmt.setInt(5, teacherBean.getSex1());
        pstmt.setString(6, teacherBean.getTeacherId());
        int rs = pstmt.executeUpdate();
        return rs;
    }
}
