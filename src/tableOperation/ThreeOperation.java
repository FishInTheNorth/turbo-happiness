package tableOperation;

import util.DBUtil;
import util.DateUtil;
import util.JudgeUtil;

import java.sql.*;
import java.util.HashMap;

public class ThreeOperation {
    private String TABLE_NAME = "";

    public ThreeOperation(String name) {
        this.TABLE_NAME = JudgeUtil.judgeTable(name);
    }

    public int addShixi(String teacherId, String trainId, Date beginTime, Date endTime) throws SQLException {
        //添加实训信息
        Connection conn = DBUtil.getConnection();
        int result = 0;

        if (conn != null) {
            String sql = "INSERT INTO " + TABLE_NAME + "(teacherId, train_id, begin_time, end_time, is_user) VALUES (?,?,?,?,1)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, teacherId);
            pstmt.setString(2, trainId);
            pstmt.setDate(3, beginTime);
            pstmt.setDate(4, endTime);
            result = pstmt.executeUpdate();
            System.out.println(sql);
            System.out.println();
        }
        DBUtil.freeConnection(conn);
        return result;
    }

    public HashMap selectShixi(String teacherId, int trainId, Date beginTime, Date endTime) throws SQLException {
        //查询信息
        Connection conn = DBUtil.getConnection();
        ResultSet set = null;
        HashMap<String, Object> map = new HashMap<>();
        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "select * from  shixi where is_use = 1";
            if (teacherId != null && !"".equals(teacherId)) {
                sql += " and teacherId ='" + teacherId + "'";
            }
            if (trainId != 0) {
                sql += " and train_id =" + trainId;
            }
            if (beginTime != null && !"".equals(DateUtil.GetStr(beginTime))) {
                sql += " and begin_time >'" + beginTime + "'";
            }
            if (endTime != null && !"".equals(DateUtil.GetStr(endTime))) {
                sql += " and end_time < '" + endTime + "'";
            }
            System.out.println(sql);
            set = stmt.executeQuery(sql);

            System.out.println();
        }
        map.put("rs", set);
        map.put("conn", conn);
        return map;
    }
    public HashMap selectShijian(String teacherId, int trainId, Date beginTime, Date endTime) throws SQLException {
        //查询信息
        Connection conn = DBUtil.getConnection();
        ResultSet set = null;
        HashMap<String, Object> map = new HashMap<>();
        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "select * from  shijian where is_use = 1";
            if (teacherId != null && !"".equals(teacherId)) {
                sql += " and teacherId ='" + teacherId + "'";
            }
            if (trainId != 0) {
                sql += " and train_id =" + trainId;
            }
            if (beginTime != null && !"".equals(DateUtil.GetStr(beginTime))) {
                sql += " and begin_time > '" + beginTime + "'";
            }
            if (endTime != null && !"".equals(DateUtil.GetStr(endTime))) {
                sql += " and end_time < '" + endTime + "'";
            }
            System.out.println(sql);
            set = stmt.executeQuery(sql);

            System.out.println();
        }
        map.put("rs", set);
        map.put("conn", conn);
        return map;
    }
    public HashMap selectShixun(String teacherId, int trainId, Date beginTime, Date endTime) throws SQLException {
        //查询信息
        Connection conn = DBUtil.getConnection();
        ResultSet set = null;
        HashMap<String, Object> map = new HashMap<>();
        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "select * from  shixun where is_use = 1";
            if (teacherId != null && !"".equals(teacherId)) {
                sql += " and teacherId ='" + teacherId + "'";
            }
            if (trainId != 0) {
                sql += " and train_id =" + trainId;
            }
            if (beginTime != null && !"".equals(DateUtil.GetStr(beginTime))) {
                sql += " and begin_time >'" + beginTime + "'";
            }
            if (endTime != null && !"".equals(DateUtil.GetStr(endTime))) {
                sql += " and end_time < '" + endTime + "'";
            }
            System.out.println(sql);
            set = stmt.executeQuery(sql);

            System.out.println();
        }
        map.put("rs", set);
        map.put("conn", conn);
        return map;
    }

    public int delete(String trainId) throws SQLException {
        //删除信息
        Connection conn = DBUtil.getConnection();
        int result = 0;
        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE " + TABLE_NAME + " set is_use = 0 where train_id = '" + trainId + "'";
            result = stmt.executeUpdate(sql);
            System.out.println(sql);
            System.out.println();
        }

        DBUtil.freeConnection(conn);
        return result;
    }

}
