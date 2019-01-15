package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.StudentDao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class studentPasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setCharacterEncoding("GB2312"); 
    	
    	String oldPassword = request.getParameter("password1");
    	String newPassword = request.getParameter("password2");
    	String newPassword1 = request.getParameter("password3");
    	HttpSession user = request.getSession();
    	String userId = (String) user.getAttribute("id");
    	PrintWriter out = response.getWriter();
    	
    	StudentDao studentDao = new StudentDao();
    	int i = 0,j = 0 ,k = -1;
    	try {
			i = studentDao.Inquire(userId, oldPassword);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if (!newPassword.equals(newPassword1)) {
			j = -1;
		}
    	if (i == -1) {
    		out.println("<script type='text/javascript'>");
			out.println("window.alert(\"原密码不正确！\");");
			out.println("window.location.href='student_changePassword.jsp'");
			out.println("</script>");
		}else if (j == -1) {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"两次密码不一致！\");");
			out.println("window.location.href='student_changePassword.jsp'");
			out.println("</script>");
		}else {
			try {
				k = studentDao.updatePassword(userId, newPassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (k == -1) {
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"密码修改失败！\");");
				out.println("window.location.href='student_changePassword.jsp'");
				out.println("</script>");
			} else {
				out.println("<script type='text/javascript'>");
				out.println("window.alert(\"密码修改成功！\");");
				out.println("window.location.href='studentInfo'");
				out.println("</script>");
			}
		}
    	
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
}
