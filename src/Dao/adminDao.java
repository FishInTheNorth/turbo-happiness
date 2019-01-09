package Dao;

import bean.*;
import tableOperation.*;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class adminDao {
    public adminBean adminInfo(String id)throws SQLException{ //加载个人信息
        adminBean bean = new adminBean();
        adminOperation adminOperation = new adminOperation();  //获取管理员表的操作
        HashMap<String,Object> map = new HashMap<>();

        map = adminOperation.select(id,"");

        ResultSet rs = (ResultSet)map.get("rs");
        rs.next();
        bean.setAdminId(id);
        bean.setAdminName(rs.getString("admin_name"));
        bean.setSex(rs.getInt("sex"));
        bean.setAdminPhone(rs.getString("admin_phone"));
        bean.setAdminQq(rs.getString("admin_qq"));
        rs.close();
        DBUtil.freeConnection((Connection)map.get("conn"));
        return bean;
    }
    public int adminEdit(adminBean bean)throws SQLException{
        int result = 0;
        adminOperation adm = new adminOperation();
        result = adm.update(bean.getAdminId(),bean.getAdminName(),bean.getSex(),bean.getAdminPhone(),bean.getAdminQq());
        return result;
    }
    public int adminChangePassword(String id,String password,String password1)throws SQLException{
        adminOperation adm = new adminOperation();
        HashMap<String,Object> map  = adm.select(id,password);
        ResultSet rs = (ResultSet) map.get("rs");
        if (!rs.next()){
            return 0;
        }
        else {
            adm.updatePassword(id,password1);
        }
        DBUtil.freeConnection((Connection) map.get("conn"));
        return 1;
    }
}
