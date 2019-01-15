package Dao;

import tableOperation.MapOperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapDao {
    public List map(String privonce)throws SQLException{
        List<String> list = new ArrayList<>();
        MapOperation mapOperation = new MapOperation();
        HashMap<String,Object> map = mapOperation.select(privonce,"");  //获取省份对应市

        ResultSet rs = (ResultSet)map.get("rs"); //获取查询结果集
        while (rs.next()){
            list.add(rs.getString("city"));
        }
        return list;
    }
}
