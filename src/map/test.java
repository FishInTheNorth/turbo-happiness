package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;


public class test {
	 public static void main(String[] args) {
	String city = "南昌";
	List<String> list=new ArrayList<String>();
	List<String> distance=new ArrayList<String>();//距离
	MapNavUtil mapResult = null;
	
	float[] test1 = {(float) 117.17,(float) 117.01,(float) 113.14,(float) 110.2};
	float[] test2 = {(float) 31.52,(float) 25.06,(float) 23.08,(float) 20.02};
	
	String string1 = "";
	String string2 = "";
	String string = "";
	
	
//写一个dao求所带学生的城市，返回一个list
	
	 int cityNum = 0;
	 //list = teacherDao.listcity();
	 list.add(0, city);//将老师城市放在第一位
	 list.add("广州");
	 list.add("广州");
	 list.add("福州");
	 list.add("瑞金");
	 LinkedHashSet<String> set = new LinkedHashSet<String>(list.size());
	 set.addAll(list);
	 list.clear();
	 list.addAll(set);//去重后的list
	 cityNum = list.size();//求长度
	 System.out.println("去重后的长度："+cityNum);
	 
	 for(int i=0;i<list.size();i++){				//查看数字对应的城市
		 System.out.println(i+":"+list.get(i));
	 }
	 
	 HashMap<String, Float> maplatitude=new HashMap<>();//暂存经度
	 HashMap<String, Float> maplongitude=new HashMap<>();//暂存纬度
	 
	 for (int i = 0; i < cityNum; i++) { //遍历存经纬度
			maplatitude.put("latitude["+i+"]", test1[i]);//用Hashmap存放经度
			maplongitude.put("longitude["+i+"]", test2[i]);//用Hashmap存放纬度
			//System.out.println(maplatitude.get("latitude["+i+"]"));
			//System.out.println(maplongitude.get("longitude["+i+"]"));
			string1 =maplatitude.get("latitude["+i+"]").toString();
			string2 =maplongitude.get("longitude["+i+"]").toString();
			string = string1+","+string2;
			distance.add(string);
	}
	 for(int i=0;i<list.size();i++){				//查看数字对应的经纬度
		 System.out.println(i+":"+distance.get(i));
	 }
     double[][] tsp = new double[cityNum][cityNum];
     
     for (int i = 0; i < tsp.length; i++) {
		for (int j = 0; j < tsp.length; j++) {
			mapResult=new MapNavUtil(distance.get(i), distance.get(j), "4f27a87d4d354045ab5003f89f42deb2");		
			tsp[i][j] = Integer.valueOf(mapResult.getResults().toString())-1;
			System.out.println(tsp[i][j]+" ");
		}
	}
         TSP ff = new TSP(tsp);
         System.out.println("路径是：" + ff.getFirnalRoad());
         System.out.println("城市顺序：" + ff.getFirnalCityFlow());
         System.out.println("最小值：" + ff.getMin());
         System.out.println("生成所有合法城市流用时：" + ff.getAllFlowTime());
         System.out.println("动态规划求解过程用时：" + ff.getGuihuaTime());
}
}
