package tableOperation;

import util.DBUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class mapOperation {
    private final String TABLE_NAME = "map";

    public HashMap select(String province, String city) throws SQLException {
        //查询地图信息，获取经纬度
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
}
