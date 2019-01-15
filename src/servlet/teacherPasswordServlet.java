package servlet;

import Dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "teacherPasswordServlet")
public class teacherPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("GB2312");

        String oldPassword = request.getParameter("password1");
        String newPassword = request.getParameter("password2");
        String newPassword1 = request.getParameter("password3");
        HttpSession user = request.getSession();
        String userId = (String) user.getAttribute("id");
        PrintWriter out = response.getWriter();

        TeacherDao teacherDao = new TeacherDao();
        int i = 0,j = 0 ,k = -1;
        try {
            i = teacherDao.Inquire(userId, oldPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (!newPassword.equals(newPassword1)) {
            j = -1;
        }
        if (i == -1) {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"原密码不正确！\");");
            out.println("window.location.href='teacher_changePassword.jsp'");
            out.println("</script>");
        }else if (j == -1) {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"两次密码不一致！\");");
            out.println("window.location.href='teacher_changePassword.jsp'");
            out.println("</script>");
        }else {
            try {
                k = teacherDao.updatePassword(userId, newPassword);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (k == -1) {
                out.println("<script type='text/javascript'>");
                out.println("window.alert(\"数据修改失败！\");");
                out.println("window.location.href='teacher_changePassword.jsp'");
                out.println("</script>");
            } else {
                out.println("<script type='text/javascript'>");
                out.println("window.alert(\"数据修改成功！\");");
                out.println("window.location.href='teacherInfo'");
                out.println("</script>");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
