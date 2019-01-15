package servlet;

import Dao.TeacherDao;
import bean.TeacherPtAllStudentBean;

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
        TeacherDao dao = new TeacherDao();
        List<TeacherPtAllStudentBean> list = new ArrayList<>();
        try {
            list = dao.teacherPtAllStudent(trainId); //��ȡlist
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ��list��Ϊ��������teacher_pt_student.jspҳ��
        request.setAttribute("list", list);
        // ��ת��teacher_pt_student.jsp
        request.getRequestDispatcher("teacher_pt_students.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
