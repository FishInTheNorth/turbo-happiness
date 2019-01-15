package servlet;

import Dao.TeacherDao;
import bean.TeacherBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "teacherEditServlet")
public class teacherEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = (String) request.getSession().getAttribute("id"); //��session��ȡid
        TeacherDao dao = new TeacherDao();
        TeacherBean bean;
        bean = null;
        try {
            bean = dao.teacherInfo(userName); //��ȡbean
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ��bean��Ϊ��������teacher_index.jspҳ��
        request.setAttribute("bean", bean);

        // ��������ת��teacher_index.jsp
        request.getRequestDispatcher("teacher_edit.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
