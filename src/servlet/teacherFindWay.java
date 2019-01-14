package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.teacherDao;
import map.MapNavUtil;
import map.TSP;
import tableOperation.mapOperation;
import util.StringUtil;

/**
 * Servlet implementation class teacherFindWay
 */
public class teacherFindWay extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teacherFindWay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String city = StringUtil.toCN(request.getParameter("city"));
		System.out.println(city);
		teacherDao teacherDao = new teacherDao();
		mapOperation mapOperation = new mapOperation();
		MapNavUtil mapResult = null;
		String trainId = request.getParameter("trainId");
		String string1 = "";
		String string2 = "";
		String string = "";
		
//写一个dao求所带学生的城市，返回一个list
		
		List<String> list=new ArrayList<String>();
		List<String> listNumber=new ArrayList<String>();
		List<String> distance=new ArrayList<String>();//距离
		
		 int cityNum = 0;
		try {
			list = teacherDao.findwayMap(trainId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 list.add(0, city);//将老师城市放在第一位

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
			try {
				maplatitude.put("latitude["+i+"]", mapOperation.selectLatitude("'"+list.get(i)+"'"));//用Hashmap存放经度
				maplongitude.put("longitude["+i+"]", mapOperation.selectLongitude("'"+list.get(i)+"'"));//用Hashmap存放纬度
				//System.out.println(maplatitude.get("latitude["+i+"]"));
				//System.out.println(maplongitude.get("longitude["+i+"]"));
				string1 =maplatitude.get("latitude["+i+"]").toString();
				string2 =maplongitude.get("longitude["+i+"]").toString();
				string = string2+","+string1;
				distance.add(string);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 for(int i=0;i<list.size();i++){				//查看数字对应的经纬度
			 System.out.println(i+":"+distance.get(i));
		 }
	     double[][] tsp = new double[cityNum][cityNum];
	     
	     for (int i = 0; i < tsp.length; i++) {
			for (int j = 0; j < tsp.length; j++) {
				mapResult=new MapNavUtil(distance.get(i), distance.get(j), "4f27a87d4d354045ab5003f89f42deb2");		
				tsp[i][j] = Integer.valueOf(mapResult.getResults().toString())-1;
				System.out.print(tsp[i][j]+"     ");
			}
			System.out.println();
		}
	         TSP ff = new TSP(tsp);
	         System.out.println("路径是：" + ff.getFirnalRoad());
	         System.out.println("城市顺序：" + ff.getFirnalCityFlow());
	         System.out.println("最小值：" + ff.getMin());
	         System.out.println("生成所有合法城市流用时：" + ff.getAllFlowTime());
	         System.out.println("动态规划求解过程用时：" + ff.getGuihuaTime());
	         
	         String route = "访问城市顺序：" + ff.getFirnalCityFlow();
	         for(int i=0;i<list.size();i++){				//做数字与城市的匹配
	        	 listNumber.add(i + ":" + list.get(i));
			 }
	         
	         request.setAttribute("route", route);
	         request.setAttribute("listNumber", listNumber);
	 		 request.getRequestDispatcher("teacher_ptWay.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
