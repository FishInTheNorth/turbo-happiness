package servlet;

import Dao.teacherDao;
import bean.studentBean;
import bean.teacherPtAllStudentBean;
import bean.teacherPtListBean;
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

@WebServlet(name = "teacherMarkingDoServlet")
public class teacherMarkingDoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String trainId = StringUtil.toCN(request.getParameter("trainId"));   //��ȡ��һ��ҳ�洫����ʵϰ���
        String stage = request.getParameter("stage");
        teacherDao dao = new teacherDao();
        List<studentBean> list = new ArrayList<>();
        List<teacherPtAllStudentBean> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        try {
            list1 = dao.teacherPtAllStudent(trainId); //����list
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*�����е�ѧ��ȡ��*/
        for(int i = 0;i<list1.size();i ++){
            list2.add(list1.get(i).getStudentId());
        }
        /*����ѧ��ȡ������ѧ����Ϣ*/
        try {
            list = dao.selectAllTrainStudents(list2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // ��list��ת��teacher_pt_list.jspҳ��
        request.setAttribute("list", list);
        request.setAttribute("trainId", trainId);
        request.setAttribute("stage", stage);


        // ��������ת��teacher_index.jsp
        request.getRequestDispatcher("teacher_studentsHand.jsp").forward(request, response);



    }
}
