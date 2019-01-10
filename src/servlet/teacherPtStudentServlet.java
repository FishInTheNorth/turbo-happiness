package servlet;

import Dao.teacherDao;
import bean.studentTrainBean;
import bean.teacherBean;

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
public class teacherPtStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trainId = request.getParameter("trainId");
        teacherDao dao = new teacherDao();
        List<studentTrainBean> list = new ArrayList<>();
        try {
            list = dao.teacherPtAllStudent(trainId); //��ȡlist
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ��bean��Ϊ��������teacher_index.jspҳ��
        request.setAttribute("list", list);

        // ��������ת��teacher_index.jsp
        request.getRequestDispatcher("teacher_pt_student.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
