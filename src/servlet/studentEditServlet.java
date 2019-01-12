package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.studentDao;
import util.StringUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class studentEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession user = request.getSession();
    	response.setCharacterEncoding("GB2312"); 
    	
    	String userId = (String) user.getAttribute("id");
    	String phone = StringUtil.toCN(request.getParameter("studentPhone"));
    	String qq = StringUtil.toCN(request.getParameter("qq"));
    	String company = StringUtil.toCN(request.getParameter("company"));
    	String province = StringUtil.toCN(request.getParameter("province"));
    	String city = StringUtil.toCN(request.getParameter("city"));
    	String contacts = StringUtil.toCN(request.getParameter("contacts"));
    	String contactsPhone = StringUtil.toCN(request.getParameter("contactsPhone"));
    	
    	int result = 0 , trainId = 0;
    	
    	PrintWriter out = response.getWriter();
    	studentDao studentDao = new studentDao();
    	
    	try {
			result = result + studentDao.updateStudent(userId, phone, qq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			trainId = studentDao.trainId();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	try {
			result = result + studentDao.addDetails(userId, trainId, province, city, company, contacts, contactsPhone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if (result == 2) {
    		out.println("<script type='text/javascript'>");
			out.println("window.alert(\"修改成功！\");");
			out.println("window.location.href='studentInfo'");
			out.println("</script>");
		}else {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"修改失败！\");");
			out.println("window.location.href='student_edit.jsp'");
			out.println("</script>");
		}
    	
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
}
