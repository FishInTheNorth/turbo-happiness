package Dao;
import bean.studentTrainBean;
import bean.teacherBean;
import bean.teacherPtListBean;
import tableOperation.stduentTrainOperation;
import tableOperation.teacherOperation;
import tableOperation.threeOperation;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
        pstmt.setString(4, teacherBean.getTeacherQq());
        pstmt.setInt(5, teacherBean.getSex1());
        pstmt.setString(6, teacherBean.getTeacherId());
        int rs = pstmt.executeUpdate();
        return rs;
    }

    public teacherBean teacherInfo(String userName) throws SQLException {
        teacherBean bean = new teacherBean();
        teacherOperation teacherOperation = new teacherOperation();  //获取管理员表的操作
        HashMap<String,Object> map = new HashMap<>();

        map = teacherOperation.select(userName,"","","");  //

        ResultSet rs = (ResultSet)map.get("rs");
        rs.next();
        bean.setTeacherId(userName);
        bean.setTeacherName(rs.getString("teacher_name"));
        bean.setSex1(rs.getInt("sex"));
        bean.setTeacherPhone(rs.getString("teacher_phone"));
        bean.setTeacherQq(rs.getString("teacher_qq"));
        bean.setMajor1(rs.getString("major"));
        rs.close();
        DBUtil.freeConnection((Connection)map.get("conn"));
        return bean;

    }

    public List<teacherPtListBean> teacherPtList(String teacherId, String trianNumber, Date beginTime, Date endTime) throws SQLException {
        List<teacherPtListBean> list = new ArrayList<>();
        teacherPtListBean tea;
        threeOperation tho1 = new threeOperation("");
        HashMap map;
        int trainId = 0;
        if(trianNumber != null && "".equals(trianNumber) == false){
            trainId = Integer.parseInt(trianNumber);
        }

        map = tho1.selectShixi(teacherId,trainId,beginTime,endTime);
        ResultSet rs = (ResultSet)map.get("rs");
        while(rs.next()){
            tea = new teacherPtListBean();
            tea.setTrainId(rs.getString("trian_id"));
            tea.setStage("实习阶段");
            tea.setBeginTime(rs.getDate("begin_time"));
            tea.setEndTime(rs.getDate("end_time"));
            list.add(tea);
            if(rs.next()) rs.close();
        }
        map = tho1.selectShixun(teacherId,trainId,beginTime,endTime);
        rs = (ResultSet)map.get("rs");
        while(rs.next()){
            tea = new teacherPtListBean();
            tea.setTrainId(rs.getString("trian_id"));
            tea.setStage("实训阶段");
            tea.setBeginTime(rs.getDate("begin_time"));
            tea.setEndTime(rs.getDate("end_time"));
            list.add(tea);
            if(rs.next()) rs.close();
        }
        map = tho1.selectShijian(teacherId,trainId,beginTime,endTime);
        rs = (ResultSet)map.get("rs");
        while(rs.next()){
            tea = new teacherPtListBean();
            tea.setTrainId(rs.getString("trian_id"));
            tea.setStage("实践阶段");
            tea.setBeginTime(rs.getDate("begin_time"));
            tea.setEndTime(rs.getDate("end_time"));
            list.add(tea);
            if(rs.next()) rs.close();
        }
        tea = new teacherPtListBean();
        tea.setTrainId("16666");
        tea.setStage("实践阶段");
        tea.setBeginTime(null);
        tea.setEndTime(null);
        list.add(tea);
        return list;
    }

    public List<studentTrainBean> teacherPtAllStudent(String trainId) throws SQLException {
        if(trainId == null || "".equals(trainId))
            return null;
        studentTrainBean bean;
        List<studentTrainBean> list = new ArrayList<>();
        stduentTrainOperation st = new stduentTrainOperation();
        HashMap map = st.select(Integer.parseInt(trainId),"");
        ResultSet rs = (ResultSet) map.get("rs");
        while(rs.next()){
            bean = new studentTrainBean();
            bean.setTrainId(rs.getInt("trian_id"));
            bean.setStudentId(rs.getString("student_Id"));
            bean.setTrainId(rs.getInt("trian_id"));
            bean.setTrainId(rs.getInt("trian_id"));
            bean.setTrainId(rs.getInt("trian_id"));
            bean.setTrainId(rs.getInt("trian_id"));
            list.add(bean);
            if(rs.next()) rs.close();
        }
    }
}
