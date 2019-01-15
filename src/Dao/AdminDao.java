package Dao;

import bean.*;
import extraBean.AddTrain;
import tableOperation.*;
import util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class AdminDao {
    public AdminBean adminInfo(String id) throws SQLException { //加载个人信息
        AdminBean bean = new AdminBean();
        AdminOperation adminOperation = new AdminOperation();  //获取管理员表的操作
        HashMap<String, Object> map = new HashMap<>();

        map = adminOperation.select(id, "");  //

        ResultSet rs = (ResultSet) map.get("rs");
        rs.next();
        bean.setAdminId(id);
        bean.setAdminName(rs.getString("admin_name"));
        bean.setSex(rs.getInt("sex"));
        bean.setAdminPhone(rs.getString("admin_phone"));
        bean.setAdminQq(rs.getString("admin_qq"));
        rs.close();
        DBUtil.freeConnection((Connection) map.get("conn"));
        return bean;
    }

    public int adminEdit(AdminBean bean) throws SQLException {
        int result = 0;
        AdminOperation adm = new AdminOperation();
        result = adm.update(bean.getAdminId(), bean.getAdminName(), bean.getSex(), bean.getAdminPhone(), bean.getAdminQq());
        return result;
    }

    public int adminChangePassword(String id, String password, String password1) throws SQLException {
        AdminOperation adm = new AdminOperation();
        HashMap<String, Object> map = adm.select(id, password);
        ResultSet rs = (ResultSet) map.get("rs");
        if (!rs.next()) {
            return 0;
        } else {
            adm.updatePassword(id, password1);
        }
        DBUtil.freeConnection((Connection) map.get("conn"));
        return 1;
    }

    public int adminAddTrain(AddTrain addTrain) throws SQLException {
        int result = 0;
        int lastTrainId = 0;
        TrainOperation to = new TrainOperation(); //获得实训表的操作
        if (to.addTrain(new Date(addTrain.getShixiBeginTime().getTime()), new Date(addTrain.getShijianEndTime().getTime()), addTrain.getSchoolYear()) == 1) {
            //如果成功添加实训
            HashMap<String, Object> map = to.select(0, null, null, "");
            ResultSet rs = (ResultSet) map.get("rs");
            rs.last();
            lastTrainId = rs.getInt("train_id"); //获得添加实训生成的实训号
            DBUtil.freeConnection((Connection) map.get("conn"));
        }
        return result;
    }

    private boolean checkTeacher(String teacherId) throws SQLException {
        boolean isTure = false;
        TeacherOperation operation = new TeacherOperation();
        HashMap<String, Object> map = operation.select(teacherId, "", "", "");
        ResultSet rs = (ResultSet) map.get("rs");
        if (rs.next())
            isTure = true;
        DBUtil.freeConnection((Connection) map.get("conn"));
        return isTure;
    }

    private boolean checkStudent(String studentId) throws SQLException {
        boolean isTure = false;
        StudentOperation operation = new StudentOperation();
        HashMap<String, Object> map = operation.select(studentId, "", "", "");
        ResultSet rs = (ResultSet) map.get("rs");
        if (rs.next())
            isTure = true;
        DBUtil.freeConnection((Connection) map.get("conn"));
        return isTure;
    }
}
