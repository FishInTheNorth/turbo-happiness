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
        HashMap<String,Object> map = mapOperation.select(privonce,"");  //��ȡʡ�ݶ�Ӧ��

        ResultSet rs = (ResultSet)map.get("rs"); //��ȡ��ѯ�����
        while (rs.next()){
            list.add(rs.getString("city"));
        }
        return list;
    }
}
