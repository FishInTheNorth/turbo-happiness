package servlet;

import Dao.teacherDao;
import bean.studentTrainBean;
import bean.teacherBean;
import bean.teacherPtAllStudentBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "teacherPtStudentServlet")
public class teacherPtAllStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trainId = request.getParameter("trainId");
        teacherDao dao = new teacherDao();
        List<teacherPtAllStudentBean> list = new ArrayList<>();
        try {
            list = dao.teacherPtAllStudent(trainId); //获取list
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 将list作为参数传到teacher_pt_student.jsp页面
        request.setAttribute("list", list);
System.out.println("到这啦！");
        // 跳转到teacher_pt_student.jsp
        request.getRequestDispatcher("teacher_pt_student.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
