package Dao;

import tableOperation.mapOperation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class mapDao {
    public List map(String privonce)throws SQLException{
        List<String> list = new ArrayList<>();
        mapOperation mapOperation = new mapOperation();
        HashMap<String,Object> map = mapOperation.select(privonce,"");  //获取省份对应市

        ResultSet rs = (ResultSet)map.get("rs"); //获取查询结果集
        while (rs.next()){
            list.add(rs.getString("city"));
        }
        return list;
    }
}
