package map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;


public class test {
	 public static void main(String[] args) {
	String city = "�ϲ�";
	List<String> list=new ArrayList<String>();
	List<String> distance=new ArrayList<String>();//����
	MapNavUtil mapResult = null;
	
	float[] test1 = {(float) 117.17,(float) 117.01,(float) 113.14,(float) 110.2};
	float[] test2 = {(float) 31.52,(float) 25.06,(float) 23.08,(float) 20.02};
	
	String string1 = "";
	String string2 = "";
	String string = "";
	
	
//дһ��dao������ѧ���ĳ��У�����һ��list
	
	 int cityNum = 0;
	 //list = teacherDao.listcity();
	 list.add(0, city);//����ʦ���з��ڵ�һλ
	 list.add("����");
	 list.add("����");
	 list.add("����");
	 list.add("���");
	 LinkedHashSet<String> set = new LinkedHashSet<String>(list.size());
	 set.addAll(list);
	 list.clear();
	 list.addAll(set);//ȥ�غ��list
	 cityNum = list.size();//�󳤶�
	 System.out.println("ȥ�غ�ĳ��ȣ�"+cityNum);
	 
	 for(int i=0;i<list.size();i++){				//�鿴���ֶ�Ӧ�ĳ���
		 System.out.println(i+":"+list.get(i));
	 }
	 
	 HashMap<String, Float> maplatitude=new HashMap<>();//�ݴ澭��
	 HashMap<String, Float> maplongitude=new HashMap<>();//�ݴ�γ��
	 
	 for (int i = 0; i < cityNum; i++) { //�����澭γ��
			maplatitude.put("latitude["+i+"]", test1[i]);//��Hashmap��ž���
			maplongitude.put("longitude["+i+"]", test2[i]);//��Hashmap���γ��
			//System.out.println(maplatitude.get("latitude["+i+"]"));
			//System.out.println(maplongitude.get("longitude["+i+"]"));
			string1 =maplatitude.get("latitude["+i+"]").toString();
			string2 =maplongitude.get("longitude["+i+"]").toString();
			string = string1+","+string2;
			distance.add(string);
	}
	 for(int i=0;i<list.size();i++){				//�鿴���ֶ�Ӧ�ľ�γ��
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
         System.out.println("·���ǣ�" + ff.getFirnalRoad());
         System.out.println("����˳��" + ff.getFirnalCityFlow());
         System.out.println("��Сֵ��" + ff.getMin());
         System.out.println("�������кϷ���������ʱ��" + ff.getAllFlowTime());
         System.out.println("��̬�滮��������ʱ��" + ff.getGuihuaTime());
}
}
