package servlet;

import Dao.TeacherDao;
import bean.TeacherPHomeworkStudentGradeBean;
import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "teacherPHomeworkServlet")
public class teacherPHomeworkServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String teacherId = (String) request.getSession().getAttribute("id"); //从session获取id
        String trainId = StringUtil.toCN(request.getParameter("trainId"));   //获取上一个页面传来的实习编号
        String studentID = StringUtil.toCN(request.getParameter("studentID"));   //获取上一个页面传来的学号
        String stage = request.getParameter("stage");    //获取阶段
        TeacherDao dao = new TeacherDao();
        List<TeacherPHomeworkStudentGradeBean> list = new ArrayList<>();
        try {
            list = dao.teacherPHomework(teacherId,trainId,studentID,stage); //传入list
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 带list跳转到teacher_pt_list.jsp页面
        request.setAttribute("list", list);
        request.setAttribute("stage", stage);


        // 带参数跳转到teacher_pt_list.jsp
        request.getRequestDispatcher("teacher_studentHomework.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
