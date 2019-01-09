package servlet;

import Dao.adminDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "adminPasswordServlet")
public class adminPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = (String) request.getSession().getAttribute("id");
        String password = request.getParameter("password1");
        String password1 = request.getParameter("password2");
        String password2 = request.getParameter("password3");

        if (password.equals(password1)){
            response.sendRedirect("admin_changePassword.jsp?f=1");
            return;
        }
        if (!password1.equals(password2)){
            response.sendRedirect("admin_changePassword.jsp?f=2");
            return;
        }
        adminDao dao = new adminDao();
        int result = 0;
        try {
            result = dao.adminChangePassword(id,password,password1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (result > 0) {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"ÐÞ¸Ä³É¹¦£¡\");");
            out.println("window.location.href='/adminInfo';");
            out.println("</script>");
        } else {
            response.sendRedirect("admin_changePassword.jsp?f=3");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
