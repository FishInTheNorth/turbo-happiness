package servlet;

import Dao.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "teacherDelStudentServlet")
public class teacherDelStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("GB2312");
        String id = request.getParameter("id");
        PrintWriter out = response.getWriter();
        TeacherDao dao = new TeacherDao();
        int i = -1;
        try {
            i = dao.deleteStudent(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i == -1) {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"É¾³ýÊ§°Ü£¡\");");
            out.println("window.location.href='teacherPtList'");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"É¾³ý³É¹¦£¡\");");
            out.println("window.location.href='teacherPtList'");
            out.println("</script>");
        }


    }
}
