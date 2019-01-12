package Dao;

import tableOperation.*;
import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class loginDao {
    HashMap<String,Object> map = null; //���ڽ��մ����ݿ��ѯ����HashMap
    ResultSet rs = null;  // ���ڽ��մӵõ���HashMap�еĽ����
    HashMap<String,Object> map1 = new HashMap<>(); //������Ľ�����û�id�ȴ��ݸ�loginServlet
    int result = 0;

    public HashMap check(String username, String password, String type) throws SQLException {
        if (type.equals("student")){ //��Ϊѧ��
            studntLogin(username,password);
        }
        else if (type.equals("teacher")){ //��Ϊ��ʦ
            teacherLogin(username, password);
        }
        else if (type.equals("admin")){  //��Ϊ����Ա
            adminLogin(username, password);
        }

        map1.put("result",result);  //����ѯ�������map1��
        DBUtil.freeConnection((Connection)map.get("conn"));
        return map1;
    }
    public void studntLogin(String username,String password) throws  SQLException{
        studentOperation student = new studentOperation();  //����ѧ����Ĳ���
        map = student.select(username,"",password,"");  //��ѯ��ѧ��
        rs = (ResultSet) map.get("rs");  //�ӷ��ص�map�еõ������

        resultNum(rs);
        if (result== 0) return;  //��δ�鵽ֱ���˳�

        map1.put("userName",rs.getString("student_name")); //��ѧ���������뵽Ҫ���ݵ�map��
        map1.put("id",rs.getString("student_id")); //��ѧ��ID���뵽Ҫ���ݵ�map��

//        stduentTrainOperation st = new stduentTrainOperation();  //���ѧ��ʵѵ��Ĳ�������
////
////        ResultSet str = (ResultSet)st.select(0,rs.getString("student_id")).get("rs");  //��ò�ѯ��ʵѵ�����
////        if (!str.next()) return; //��δ�鵽ֱ���˳�
////        rs.last();
//        map1.put("trainId",rs.getInt("train_id")); //��ʵѵ�Ŵ��ݷ���Ҫ���ݵ�map��
    }
    public void teacherLogin(String username,String password) throws  SQLException{
        teacherOperation teacher = new teacherOperation(); //������ʦ�����
        map = teacher.select(username,"",password,"");  //��ѯ�ý�ʦ

        rs = (ResultSet)map.get("rs");  //�ӷ��ص�map�еõ������
        resultNum(rs);
        if (result== 0) return; //��δ�鵽ֱ���˳�

        map1.put("userName",rs.getString("teacher_name")); //����ʦ�������뵽Ҫ���ݵ�map��
        map1.put("id",rs.getString("teacher_id"));//����ʦID���뵽Ҫ���ݵ�map��
    }
    public void adminLogin(String username,String password) throws  SQLException{
        adminOperation admin = new adminOperation(); //��������Ա�����
        map = admin.select(username,password); //��ѯ�ù���Ա

        rs = (ResultSet)map.get("rs");  //�ӷ��ص�map�еõ������
        resultNum(rs);
        if (result== 0) return; //��δ�鵽ֱ���˳�

        map1.put("userName",rs.getString("admin_name")); //������Ա�������뵽Ҫ���ݵ�map��
        map1.put("id",rs.getString("admin_id"));//������ԱID���뵽Ҫ���ݵ�map��
    }
    public void resultNum(ResultSet set){ //��ò�ѯ���
        result = 0;
        try {
            if(set.next()){
                result = 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
