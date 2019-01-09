package tableOperation;

import util.DBUtil;
import util.DateUtil;
import util.JudgeUtil;

import java.sql.*;
import java.util.HashMap;

public class threeRerportOperation {
    private String TABLE_NAME = "";
    private String TYPE = "";

    public threeRerportOperation(String name){
        this.TABLE_NAME = JudgeUtil.judgeTable(name) + "Report";
        this.TYPE = JudgeUtil.judgeTable(name);
    }
    public int addShixiRerport(String stuentId, String Id, int week,Date beginTime, Date endTime) throws SQLException {
        //添加实训报告信息
        Connection conn = DBUtil.getConnection();
        int result = 0;

        if (conn != null) {
            String sql = "INSERT INTO " + TABLE_NAME +
                    "(student_id, "+ TYPE+"_id, week, begin_time, end_time) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,stuentId);
            pstmt.setString(2,Id);
            pstmt.setInt(3,week);
            pstmt.setDate(4,beginTime);
            pstmt.setDate(5,endTime);
            result = pstmt.executeUpdate();
            System.out.println(sql);
            System.out.println();
        }
        DBUtil.freeConnection(conn);
        return result;
    }
    public int addGrade(float grade,String opinion,int RerportId) throws SQLException {
        //用于老师批改信息
        Connection conn = DBUtil.getConnection();
        int result = 0;

        if (conn != null) {
            String sql = "UPDATE " + TABLE_NAME
                    + " set grade=?, opinion=? where " + TABLE_NAME+"_id = ?" ;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setFloat(1,grade);
            pstmt.setString(2,opinion);
            pstmt.setInt(3,RerportId);
            result = pstmt.executeUpdate();
            System.out.println(sql);
            System.out.println();
        }
        DBUtil.freeConnection(conn);
        return result;
    }
    public int uploadFile(int RerportId,String address)throws SQLException{
        //用于上传学生 汇报
        Connection conn = DBUtil.getConnection();
        int result = 0;

        if (conn != null) {
            String sql = "UPDATE " + TABLE_NAME
                    + " adress=? where " + TABLE_NAME+"_id = ?" ;
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,address);
            pstmt.setInt(2,RerportId);
            result = pstmt.executeUpdate();
            System.out.println(sql);
            System.out.println();
        }
        DBUtil.freeConnection(conn);
        return result;
    }
    public HashMap select(String Id)throws SQLException{
        //查询信息
        Connection conn = DBUtil.getConnection();
        ResultSet set = null;
        HashMap<String,Object> map =  new HashMap<>();
        if (conn!=null){
            Statement stmt = conn.createStatement();
            String sql = "select * from " + TABLE_NAME + " where is_use=1";
            if (Id != null && !"".equals(Id)) {
                sql += " and "+ TABLE_NAME+"_id ='" + Id + "'";
            }

            set = stmt.executeQuery(sql);
            System.out.println(sql);
            System.out.println();
        }
        map.put("rs",set);
        map.put("conn",conn);
        return map;
    }
}
