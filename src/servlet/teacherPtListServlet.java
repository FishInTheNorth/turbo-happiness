package servlet;

import Dao.teacherDao;
import bean.teacherBean;
import bean.teacherPtListBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "teacherPtListServlet")
public class teacherPtListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = (String) request.getSession().getAttribute("id"); //从session获取id

        String trainNumber = request.getParameter("trainNumber");  //获取表单传过来的数据
        Date beginTime = null,endTime = null;
        if(request.getParameter("beginTime") != null && "".equals(request.getParameter("beginTime")) == false) {
            beginTime = Date.valueOf(request.getParameter("beginTime"));
        }
        if(request.getParameter("endTime") != null && "".equals(request.getParameter("endTime")) == false) {
            endTime = Date.valueOf(request.getParameter("endTime"));
        }
        String stage = request.getParameter("stage");

        teacherDao dao = new teacherDao();
        List<teacherPtListBean> list = new ArrayList<>();
        try {
            list = dao.teacherPtList(userName,trainNumber,beginTime,endTime); //传入list
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 带list跳转到teacher_pt_list.jsp页面
        request.setAttribute("data", list);
        request.setAttribute("trainNumber", trainNumber);
        request.setAttribute("beginTime", beginTime);
        request.setAttribute("endTime", endTime);
        request.setAttribute("stage", stage);


        // 带参数跳转到teacher_index.jsp
        request.getRequestDispatcher("teacher_pt_list.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
