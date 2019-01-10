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
            list = dao.teacherPtAllStudent(trainId); //获取list
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 将bean作为参数传到teacher_index.jsp页面
        request.setAttribute("list", list);

        // 带参数跳转到teacher_index.jsp
        request.getRequestDispatcher("teacher_pt_student.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
