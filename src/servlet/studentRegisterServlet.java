package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.studentDao;
import util.StringUtil;

/**
 * Servlet implementation class studentRegister
 */
public class studentRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GB2312");
		
		String company = StringUtil.toCN(request.getParameter("company"));
		String contacts = StringUtil.toCN(request.getParameter("contacts"));
		String contactsPhone = StringUtil.toCN(request.getParameter("contactsPhone"));
		String province = StringUtil.toCN(request.getParameter("province"));
		String city = StringUtil.toCN(request.getParameter("city"));	
		HttpSession user = request.getSession();
    	String userId = (String) user.getAttribute("id");
    	studentDao studentDao = new studentDao();
    	PrintWriter out = response.getWriter();
    	
    	int trainId = 0;
		try {
			trainId = studentDao.trainId();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	int i = 0;
    	try {
			i = studentDao.addDetails(userId, trainId, province, city, company, contacts, contactsPhone);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	if (i == 0) {
    		out.println("<script type='text/javascript'>");
			out.println("window.alert(\"登记失败！\");");
			out.println("window.location.href='student_registerInformation.jsp'");
			out.println("</script>");
		}else {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"登记成功！\");");
			out.println("window.location.href='studentInfo'");
			out.println("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
