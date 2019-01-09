package tableOperation;

import util.DBUtil;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class adminOperation {
    private final String TABLE_NAME = "admin";

    public HashMap select(String adminId,String password) throws SQLException {
        //查询管理员信息
        Connection conn = DBUtil.getConnection();
        ResultSet set = null;
        HashMap<String,Object> map =  new HashMap<>();
        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "select * from " + TABLE_NAME + " where admin_id = '" +adminId + "'";
            if(password!=null && !"".equals(password)){
                sql += " and password= '" + password + "'";
            }
            set = stmt.executeQuery(sql);
            System.out.println(sql);
            System.out.println();
        }
        map.put("rs",set);
        map.put("conn",conn);
        return map;
    }
    public int update(String adminId, String adminName, int sex, String adminPhone, String adminQq) throws SQLException {
        //修改管理员信息
        Connection conn = DBUtil.getConnection();
        int result = 0;

        if (conn != null) {
            String sql = "UPDATE " + TABLE_NAME + " set admin_name=?, sex=?, admin_phone=?,admin_qq=?  where admin_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, adminName);
            pstmt.setInt(2, sex);
            pstmt.setString(3, adminPhone);
            pstmt.setString(4, adminQq);
            pstmt.setString(5, adminId);
            result = pstmt.executeUpdate();

            System.out.println(sql);
            System.out.println();
        }
        DBUtil.freeConnection(conn);
        return result;
    }
    public int updatePassword(String adminId, String password) throws SQLException {
        //修改密码
        Connection conn = DBUtil.getConnection();
        int result = 0;

        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE " + TABLE_NAME + " set password = '" + password + "' where admin_id = '" + adminId + "'";
            result = stmt.executeUpdate(sql);

            System.out.println(sql);
            System.out.println();
        }
        DBUtil.freeConnection(conn);
        return result;

    }
}
