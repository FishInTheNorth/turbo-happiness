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
        String teacherId = (String) request.getSession().getAttribute("id"); //��session��ȡid
        String trainId = StringUtil.toCN(request.getParameter("trainId"));   //��ȡ��һ��ҳ�洫����ʵϰ���
        String studentID = StringUtil.toCN(request.getParameter("studentID"));   //��ȡ��һ��ҳ�洫����ѧ��
        String stage = request.getParameter("stage");    //��ȡ�׶�
        TeacherDao dao = new TeacherDao();
        List<TeacherPHomeworkStudentGradeBean> list = new ArrayList<>();
        try {
            list = dao.teacherPHomework(teacherId,trainId,studentID,stage); //����list
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // ��list��ת��teacher_pt_list.jspҳ��
        request.setAttribute("list", list);
        request.setAttribute("stage", stage);


        // ��������ת��teacher_pt_list.jsp
        request.getRequestDispatcher("teacher_studentHomework.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
