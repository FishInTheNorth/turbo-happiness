package tableOperation;

import util.DBUtil;

import java.sql.*;
import java.util.HashMap;

public class TrainOperation {
    private final String TABLE_NAME = "train";

    public HashMap select(int trainId, Date beginTime, Date endTime, String schoolYear) throws SQLException {
        //查询实训信息
        Connection conn = DBUtil.getConnection();
        ResultSet set = null;
        HashMap<String,Object> map = new HashMap<>();
        if (conn != null) {
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            String sql = "select * from " + TABLE_NAME + " where is_use=1";
            if (beginTime != null && !"".equals(beginTime)) {
                sql += " and begin_time '" + beginTime + "";
            }
            if (endTime != null && !"".equals(endTime)) {
                sql += " and end_time ='" + endTime + "'";
            }
            if (schoolYear != null && !"".equals(schoolYear)) {
                sql += " and school_year like '%" + schoolYear + "%'";
            }
            if (trainId !=0){
                sql += " and train_id =" + trainId + "";
            }
            set = stmt.executeQuery(sql);
            System.out.println(sql);
            System.out.println();
        }
        map.put("rs",set);
        map.put("conn",conn);
        return map;
    }

    public int addTrain(Date beginTime, Date endTime, String schoolYear) throws SQLException {
        //添加实训信息
        Connection conn = DBUtil.getConnection();
        int result = 0;

        if (conn != null) {
            String sql = "INSERT INTO " + TABLE_NAME + "(begin_time, end_time, school_year, is_user) VALUES (?,?,?,1)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1,beginTime);
            pstmt.setDate(2,endTime);
            pstmt.setString(3,schoolYear);
            result = pstmt.executeUpdate();
            System.out.println(sql);
            System.out.println();
        }
        DBUtil.freeConnection(conn);
        return result;
    }
    public int delete(String trianId) throws SQLException {
        //删除实训信息
        Connection conn = DBUtil.getConnection();
        int result = 0;

        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE " + TABLE_NAME + " set is_use = " + 0 + " where teacher_id = '" + trianId + "'";
            result = stmt.executeUpdate(sql);
            System.out.println(sql);
            System.out.println();
        }

        DBUtil.freeConnection(conn);
        return result;
    }
}
