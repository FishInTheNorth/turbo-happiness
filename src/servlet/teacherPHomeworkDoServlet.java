package servlet;

import Dao.teacherDao;
import bean.teacherPHomeworkStudentGradeBean;
import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "teacherPHomeworkDoServlet")
public class teacherPHomeworkDoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("GB2312");
        String teacherId = (String) request.getSession().getAttribute("id"); //��session��ȡid

        /*����һ��ҳ���ȡ����*/
        String trainId = StringUtil.toCN(request.getParameter("trainId"));   //��ȡ��һ��ҳ�洫����ʵϰ���
        String studentId = StringUtil.toCN(request.getParameter("studentId"));   //��ȡ��һ��ҳ�洫����ѧ��
        String stage = StringUtil.toCN(request.getParameter("stage"));    //��ȡ�׶�
        String week = request.getParameter("week");    //��ȡ����
        String grade = request.getParameter("grade");    //��ȡ����
        String opinion = StringUtil.toCN(request.getParameter("opinion"));    //��ȡ����
        PrintWriter out = response.getWriter();

        teacherDao dao = new teacherDao();
        int i = -1;
        try {
            i = dao.teacherPHomeworkDo(trainId,studentId,stage,week,grade,opinion); //ִ���޸�
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (i == -1) {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"����ʧ�ܣ�����˳�ҳ�棡\");");
            out.println("window.location.href='teacherMarking'");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"��������ɣ�\");");
            out.println("window.location.href='teacherMarking'");
            out.println("</script>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
