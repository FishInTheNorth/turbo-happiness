package Dao;
import bean.*;
import tableOperation.*;
import util.DBUtil;
import util.StringUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static util.DBUtil.getConnection;

public class teacherDao {
    public int Inquire(String userId, String oldPassword) throws SQLException {

        Connection conn;
        conn = getConnection();
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
        conn = getConnection();
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
        conn = getConnection();
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

    public List<teacherPtListBean> teacherPtList(String teacherId, String trainNumber, Date beginTime, Date endTime,String stage) throws SQLException {
        List<teacherPtListBean> list = new ArrayList<>();
        teacherPtListBean tea;
        threeOperation tho1 = new threeOperation("");
        HashMap map;
        int trainId = 0;
        ResultSet rs;
        if(trainNumber != null && "".equals(trainNumber) == false){
            trainId = Integer.parseInt(trainNumber);
        }

        if(stage == null || stage.equals("") || stage.equals("实习阶段")) {
            map = tho1.selectShixi(teacherId, trainId, beginTime, endTime);
            rs = (ResultSet) map.get("rs");
            while (rs.next()) {
                tea = new teacherPtListBean();
                tea.setTrainId(rs.getString("train_id"));
                tea.setStage("实习阶段");
                tea.setBeginTime(rs.getDate("begin_time"));
                tea.setEndTime(rs.getDate("end_time"));
                list.add(tea);
            }
        }
        if(stage == null || stage.equals("") || stage.equals("实训阶段")) {
            map = tho1.selectShixun(teacherId, trainId, beginTime, endTime);
            rs = (ResultSet) map.get("rs");
            while (rs.next()) {
                tea = new teacherPtListBean();
                tea.setTrainId(rs.getString("train_id"));
                tea.setStage("实训阶段");
                tea.setBeginTime(rs.getDate("begin_time"));
                tea.setEndTime(rs.getDate("end_time"));
                list.add(tea);
            }
        }
        if(stage == null || stage.equals("") || stage.equals("实践阶段")) {
            map = tho1.selectShijian(teacherId, trainId, beginTime, endTime);
            rs = (ResultSet) map.get("rs");
            while (rs.next()) {
                tea = new teacherPtListBean();
                tea.setTrainId(rs.getString("train_id"));
                tea.setStage("实践阶段");
                tea.setBeginTime(rs.getDate("begin_time"));
                tea.setEndTime(rs.getDate("end_time"));
                list.add(tea);
            }
        }
        return list;
    }

    public List<teacherPtAllStudentBean> teacherPtAllStudent(String trainId) throws SQLException {  //用于教师查询所有学生信息
        if(trainId == null || "".equals(trainId))
            return null;
        teacherPtAllStudentBean bean;
        List<teacherPtAllStudentBean> list = new ArrayList<>();
        stduentTrainOperation st = new stduentTrainOperation();
        studentOperation st1 = new studentOperation();
        HashMap map = st.selectAll(Integer.parseInt(trainId));   //在student_train表中搜索
        ResultSet rs = (ResultSet) map.get("rs");
        HashMap map1;
        ResultSet rs1;
        while(rs.next()){
            bean = new teacherPtAllStudentBean();
            map1 = st1.select(rs.getString("student_Id"),"","","");  //在student表中搜索
            rs1 = (ResultSet) map1.get("rs");
            if(!rs1.next()) continue;                                       //如果当前搜索集为空则进行下一轮搜索
            bean.setStudentId(rs1.getString("student_id"));  //从student表获取信息
            bean.setStudentsName(rs1.getString("student_name"));
            bean.setMajor(rs1.getString("major"));
            bean.setStudentPhone(rs1.getString("student_phone"));
            bean.setStudentQq(rs1.getString("student_qq"));
            bean.setSex(rs1.getInt("sex"));

            bean.setProvince(rs.getString("province"));    //从student_train表获取信息
            bean.setCity(rs.getString("city"));
            bean.setCompany(rs.getString("company"));
            bean.setContactName(rs.getString("contact_name"));
            bean.setContactPhone(rs.getString("contact_phone"));
            bean.setTrainId(Integer.parseInt(rs.getString("train_id")));
            list.add(bean);
        }
        return list;
    }

    public int StudentEdit(teacherPtAllStudentBean bean) throws SQLException {  //用于教师修改学生信息
        Connection conn;
        conn = getConnection();
        studentOperation stu = new studentOperation();
        stduentTrainOperation stutr = new stduentTrainOperation();

        int r1 = stu.update(bean.getStudentId(),bean.getStudentsName(),bean.getMajor(),bean.getStudentPhone(),bean.getStudentQq(),bean.getSex());
        int r2 = stutr.addDetails(bean.getStudentId(),bean.getTrainId(),bean.getProvince(),bean.getCity(),bean.getCompany(),bean.getContactName(),bean.getContactPhone());
        if(r1 == -1 || r2 == -1)
          return -1;
        return 1;
    }

    public int deleteStudent(String id) throws SQLException {
        studentOperation stu = new studentOperation();
        int i = stu.delete(id);
        return i;
    }

    public List<String> findwayMap(String trainId) throws SQLException {  //两个参数：要查的实训编号 和 起始城市
        List<String> list = new ArrayList<>();
        stduentTrainOperation sto = new stduentTrainOperation();
        HashMap map = sto.selectAll(Integer.parseInt(trainId));
        ResultSet rs = (ResultSet) map.get("rs");
        while(rs.next()){
            list.add(rs.getString("city"));
        }
        return list;
    }

    public List<studentBean> selectAllTrainStudents(List<String> list) throws SQLException {
        List<studentBean> list1 = new ArrayList<>();
        studentOperation stu = new studentOperation();
        studentBean bean = new studentBean();
        ResultSet rs;
        for(int i = 0;i < list.size();i ++) {  //遍历所有学生学号
            HashMap map = stu.select(list.get(i),"","","");
            rs = (ResultSet) map.get("rs");
            while(rs.next()) {  //遍历所有根据学生学号搜索到的学生信息
                bean = new studentBean();
                bean.setStudentId(rs.getString("student_id"));
                bean.setStudentsName(rs.getString("student_name"));
                bean.setMajor(rs.getString("major"));
                list1.add(bean);
            }
        }
        return list1;
    }

    public List<teacherPHomeworkStudentGradeBean> teacherPHomework(String teacherId,String trainId, String studentID,String stage) throws SQLException {
        List<teacherPHomeworkStudentGradeBean> list = new ArrayList<>();
        teacherPHomeworkStudentGradeBean bean;
        threeRerportOperation tho = new threeRerportOperation("");
        threeOperation tho1 = new threeOperation("");
        HashMap map = null;
        HashMap map1 = null;
        ResultSet rs1;
        if(stage.equals("实习阶段")){
            map = tho1.selectShixi(teacherId, Integer.parseInt(trainId),null,null);
            rs1 = (ResultSet) map.get("rs");
            rs1.next();
            trainId = rs1.getString("shixi_id");
        }else if(stage.equals("实训阶段")){
            map = tho1.selectShixun(teacherId, Integer.parseInt(trainId),null,null);
            rs1 = (ResultSet) map.get("rs");
            rs1.next();
            trainId = rs1.getString("shixun_id");
        }
        else if(stage.equals("实践阶段")){
            map = tho1.selectShijian(teacherId, Integer.parseInt(trainId),null,null);
            rs1 = (ResultSet) map.get("rs");
            rs1.next();
            trainId = rs1.getString("shixjian_id");
        }

        if(stage.equals("实习阶段")){
            map1 = tho.selectReport(studentID,trainId,"shixi");
        }else if(stage.equals("实训阶段")){
            map1 = tho.selectReport(studentID,trainId,"shixun");
        }
        else if(stage.equals("实践阶段")){
            map1 = tho.selectReport(studentID,trainId,"shijian");
        }
        if(map1.get("rs") != null) {
            ResultSet rs = (ResultSet) map1.get("rs");
            while (rs.next()) {
                bean = new teacherPHomeworkStudentGradeBean();
                bean.setStudentId(studentID);
                bean.setTrainId(trainId);
                bean.setWeek(rs.getInt("week"));
                bean.setGrade(rs.getFloat("grade"));
                bean.setOpinion(rs.getString("opinion"));
                bean.setAddress(rs.getString("address"));
                bean.setBeginTime(rs.getDate("begin_time"));
                bean.setEndTime(rs.getDate("end_time"));
                list.add(bean);
            }
        }
        return list;
    }

    public int teacherPHomeworkDo(String trainId, String studentId, String stage, String week, String grade, String opinion) throws SQLException {
        threeRerportOperation tho = new threeRerportOperation("");
        int i = -1;
        if(stage.equals("实习阶段")){
            i = tho.PHomework(trainId,studentId,"shixi",week,grade,opinion);
        }else if(stage.equals("实训阶段")){
            i = tho.PHomework(trainId,studentId,"shixun",week,grade,opinion);
        }else if(stage.equals("实践阶段")){
            i = tho.PHomework(trainId,studentId,"shixjian",week,grade,opinion);
        }
        return i;
    }
}
