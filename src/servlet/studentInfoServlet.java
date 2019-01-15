package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.StudentDao;
import bean.StudentBean;

import java.io.IOException;
import java.sql.SQLException;

public class studentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	HttpSession user = request.getSession();
    	String userId = (String) user.getAttribute("id");
    	StudentDao studentDao = new StudentDao();
    	StudentBean studentBean = new StudentBean();
    	try {
			studentBean = studentDao.QueryInfo(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	request.setAttribute("StudentBean", studentBean);
    	System.out.println(userId);
		request.getRequestDispatcher("student_index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);
    }
}
