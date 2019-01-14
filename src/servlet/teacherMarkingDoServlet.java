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
        String trainId = StringUtil.toCN(request.getParameter("trainId"));   //获取上一个页面传来的实习编号
        String stage = request.getParameter("stage");
        teacherDao dao = new teacherDao();
        List<studentBean> list = new ArrayList<>();
        List<teacherPtAllStudentBean> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        try {
            list1 = dao.teacherPtAllStudent(trainId); //传入list
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*把所有的学号取出*/
        for(int i = 0;i<list1.size();i ++){
            list2.add(list1.get(i).getStudentId());
        }
        /*根据学号取出所有学生信息*/
        try {
            list = dao.selectAllTrainStudents(list2);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 带list跳转到teacher_pt_list.jsp页面
        request.setAttribute("list", list);
        request.setAttribute("trainId", trainId);
        request.setAttribute("stage", stage);


        // 带参数跳转到teacher_index.jsp
        request.getRequestDispatcher("teacher_studentsHand.jsp").forward(request, response);



    }
}
