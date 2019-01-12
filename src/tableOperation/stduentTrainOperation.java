package tableOperation;

import util.DBUtil;

import java.sql.*;
import java.util.HashMap;

public class stduentTrainOperation {
    private final String TABLE_NAME = "student_train";
    public HashMap select(int trainId, String studentId) throws SQLException{ //no use
        //ͨ��ʵѵ�ź�ѧ��ȷ��ѧ��ʵѵ��Ϣ
        Connection conn = DBUtil.getConnection();
        ResultSet set = null;
        HashMap<String,Object> map =  new HashMap<>();
        if (conn!=null){
            Statement stmt = conn.createStatement();
            String sql = "select * from " + TABLE_NAME +
                    " where is_use=1 "+ " AND student_Id ='"+ studentId + "'";
            if (trainId != 0){
                sql +=" AND train_id="+ trainId;
            }

            System.out.println(sql);
            set = stmt.executeQuery(sql);
            System.out.println();
        }
        map.put("rs",set);
        map.put("conn",conn);
        return map;
    }
    public int add(String studentId,int trainId)throws SQLException{
        //ע���ʼʵѵ��Ϣ
        Connection conn = DBUtil.getConnection();
        int result = 0;

        if (conn != null) {
            String sql = "INSERT INTO " + TABLE_NAME + "(student_Id, train_id, is_user) VALUES (?,?,1)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,studentId);
            pstmt.setInt(2,trainId);
            result = pstmt.executeUpdate();
            System.out.println(sql);
            System.out.println();
        }
        DBUtil.freeConnection(conn);
        return result;
    }
    public int addDetails(String studentId,int trainId,String province,String city,String company,String contactName,String contactPhone)throws SQLException{
        //ѧ��ע��ʵѵ��Ϣ
        Connection conn = DBUtil.getConnection();
        int result = 0;

        if (conn != null) {
            String sql = "UPDATE " + TABLE_NAME
                    + " set province=?, city=?, company=?,contact_name=?, contact_phone=? where student_Id=? and train_id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,province);
            pstmt.setString(2,city);
            pstmt.setString(3,company);
            pstmt.setString(4,contactName);
            pstmt.setString(5,contactPhone);
            pstmt.setString(6,studentId);
            pstmt.setInt(7,trainId);

            result = pstmt.executeUpdate();
            System.out.println(sql);
            System.out.println();
        }
        DBUtil.freeConnection(conn);
        return result;
    }
    public int delete(int trainId,String studentId) throws SQLException {
        //ɾ��ѧ��ʵѵ��Ϣ
        Connection conn = DBUtil.getConnection();
        int result = 0;
        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "UPDATE " + TABLE_NAME +
                    " set is_use = 0  where train_id="+ trainId+ " AND student_id = '" + studentId + "'";
            result = stmt.executeUpdate(sql);
            System.out.println(sql);
            System.out.println();
        }

        DBUtil.freeConnection(conn);
        return result;
    }
    public HashMap selectAll(int trainId) throws SQLException{
        //ͨ��ʵѵ�ź�ѧ��ȷ��ѧ��ʵѵ��Ϣ
        Connection conn = DBUtil.getConnection();
        ResultSet set = null;
        HashMap<String,Object> map =  new HashMap<>();
        if (conn!=null){
            Statement stmt = conn.createStatement();
            String sql = "select * from " + TABLE_NAME +
                    " where is_use=1 ";
            if (trainId != 0){
                sql +=" AND train_id="+ trainId;
            }

            System.out.println(sql);
            set = stmt.executeQuery(sql);
            System.out.println();
        }
        map.put("rs",set);
        map.put("conn",conn);
        return map;
    }
    public int selectTrainId() throws SQLException{            //zzzzzzzz
        //������ʵѵ��
        Connection conn = DBUtil.getConnection();
        ResultSet set = null;
        int trainId = 0;
        if (conn!=null){
            Statement stmt = conn.createStatement();
            String sql = "select * from " + TABLE_NAME +
                    " where is_use=1 ";
            set = stmt.executeQuery(sql);
            if (!set.next()) return 0; //��δ�鵽ֱ���˳�
            else {
                trainId = set.getInt("train_id");
            }
            System.out.println(sql);
            System.out.println(trainId);
        }
        return trainId;
    }


}
