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
        String teacherId = (String) request.getSession().getAttribute("id"); //从session获取id

        /*从上一个页面获取参数*/
        String trainId = StringUtil.toCN(request.getParameter("trainId"));   //获取上一个页面传来的实习编号
        String studentId = StringUtil.toCN(request.getParameter("studentId"));   //获取上一个页面传来的学号
        String stage = StringUtil.toCN(request.getParameter("stage"));    //获取阶段
        String week = request.getParameter("week");    //获取周数
        String grade = request.getParameter("grade");    //获取分数
        String opinion = StringUtil.toCN(request.getParameter("opinion"));    //获取评价
        PrintWriter out = response.getWriter();

        teacherDao dao = new teacherDao();
        int i = -1;
        try {
            i = dao.teacherPHomeworkDo(trainId,studentId,stage,week,grade,opinion); //执行修改
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (i == -1) {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"批阅失败，点击退出页面！\");");
            out.println("window.location.href='teacherMarking'");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"批阅已完成！\");");
            out.println("window.location.href='teacherMarking'");
            out.println("</script>");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
