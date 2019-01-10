package servlet;

import Dao.teacherDao;
import bean.teacherBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "teacherEditServlet")
public class teacherEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("GB2312");

        String teacherName = request.getParameter("teacherName");
        String major = request.getParameter("major");
        String teacherPhone = request.getParameter("teacherPhone");
        String qq = request.getParameter("qq");
        String sex = request.getParameter("sex");
        int sex1 = 0;
        if(sex.equals('女')){
            sex1 = 0;
        }else{
            sex1 = 1;
        }
        HttpSession user = request.getSession();
        String userId = (String) user.getAttribute("id");
        PrintWriter out = response.getWriter();

        teacherDao teacherDao = new teacherDao();
        teacherBean teacherBean = new teacherBean();
        teacherBean.setTeacherId(userId);
        teacherBean.setTeacherName(teacherName);
        teacherBean.setMajor1(major);
        teacherBean.setTeacherPhone(teacherPhone);
        teacherBean.setTeaherQq(qq);
        teacherBean.setSex1(sex1);
        int i = -1;
        try {
            i = teacherDao.Edit(teacherBean);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (i == -1) {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"信息修改失败！\");");
            out.println("window.location.href='student_changePassword.jsp'");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"信息修改成功！\");");
            out.println("window.location.href='student_changePassword.jsp'");
            out.println("</script>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
