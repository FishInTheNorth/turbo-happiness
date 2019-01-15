package tableOperation;

import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class MapOperation {
    private final String TABLE_NAME = "map";

    public HashMap select(String province, String city) throws SQLException {
        //��ѯ��ͼ��Ϣ����ȡ��γ��
        Connection conn = DBUtil.getConnection();
        ResultSet set = null;
        HashMap<String,Object> map =  new HashMap<>();
        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "select * from " + TABLE_NAME + " where 1=1";
            if (province != null && !"".equals(province)) {
                sql += " and province ='" + province + "'";
            }
            if (city != null && !"".equals(city)) {
                sql += " and city ='" + city + "'";
            }
            set = stmt.executeQuery(sql);
            System.out.println(sql);
            System.out.println();
        }
        map.put("rs",set);
        map.put("conn",conn);
        return map;
    }
    public float selectLatitude(String city) throws SQLException {        //��ѯ��ͼ��Ϣ����ȡ����

        Connection conn = DBUtil.getConnection();
        float latitude =0;
        ResultSet set = null;
        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "select latitude from map where city = "+ city +"";
            set = stmt.executeQuery(sql);
            System.out.println(sql);
            System.out.println();
            if (!set.next()) return 0; //��δ�鵽ֱ���˳�
            else {
                latitude = set.getFloat("latitude");
            }
        }
        return latitude;
    }

    public float selectLongitude(String city) throws SQLException {        //��ѯ��ͼ��Ϣ����ȡγ��

        Connection conn = DBUtil.getConnection();
        float longitude =0;
        ResultSet set = null;
        if (conn != null) {
            Statement stmt = conn.createStatement();
            String sql = "select longitude from map where city = "+ city +"";
            set = stmt.executeQuery(sql);
            System.out.println(sql);
            System.out.println();
            if (!set.next()) return 0; //��δ�鵽ֱ���˳�
            else {
                longitude = set.getFloat("longitude");
            }
        }
        return longitude;
    }

}
