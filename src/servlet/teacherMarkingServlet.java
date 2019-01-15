package servlet;

import Dao.TeacherDao;
import bean.TeacherPtListBean;
import util.StringUtil;

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

@WebServlet(name = "teacherMarkingServlet")
public class teacherMarkingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = (String) request.getSession().getAttribute("id"); //��session��ȡid

        String trainNumber = request.getParameter("trainNumber");  //��ȡ��������������
        Date beginTime = null,endTime = null;
        if(request.getParameter("beginTime") != null && "".equals(request.getParameter("beginTime")) == false) {
            beginTime = Date.valueOf(request.getParameter("beginTime"));
        }
        if(request.getParameter("endTime") != null && "".equals(request.getParameter("endTime")) == false) {
            endTime = Date.valueOf(request.getParameter("endTime"));
        }
        String stage = StringUtil.toCN(request.getParameter("stage"));
        TeacherDao dao = new TeacherDao();
        List<TeacherPtListBean> list = new ArrayList<>();
        try {
            list = dao.teacherPtList(userName,trainNumber,beginTime,endTime,stage); //����list
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ��list��ת��teacher_pt_list.jspҳ��
        request.setAttribute("data", list);
        request.setAttribute("trainNumber", trainNumber);
        request.setAttribute("beginTime", beginTime);
        request.setAttribute("endTime", endTime);
        request.setAttribute("stage", stage);


        // ��������ת��teacher_index.jsp
        request.getRequestDispatcher("teacher_Marking.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
