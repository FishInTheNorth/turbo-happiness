package servlet;

import Dao.mapDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProvinceCityServlet")
public class ProvinceCityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prov = request.getParameter("prov");
        System.out.println("prov=" + prov);
        String cityList = "";
        /*if ("½­Î÷".equals(prov)) {
            cityList = "[{\"city\":\"ÄÏ²ý\"},{\"city\":\"¾Å½­\"},{\"city\":\"ÒË´º\"}]";
        } else if ("ºþ±±".equals(prov)) {
            cityList = "[{\"city\":\"Îäºº\"},{\"city\":\"»Æ¸Ô\"},{\"city\":\"¾£ÖÝ\"}]";*/
        mapDao dao = new mapDao();
        List<String> list = null;
        try {
            list = dao.map(prov);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        cityList = "[";
        for (int i = 0; i < list.size(); i++) {
            cityList += "{\"city\":\"" +  list.get(i) + "\"},";
        }
        cityList = cityList.substring(0,cityList.length()-1);
        cityList +="]";
        response.setContentType("text/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(cityList);
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
