package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.StudentDao;
import extraBean.StudentsubmitBean;

/**
 * Servlet implementation class studentSubmit
 */
public class studentSubmitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentSubmitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession user = request.getSession();
    	response.setCharacterEncoding("GB2312"); 
    	
    	
    	
    	String userId = (String) user.getAttribute("id");
    	StudentDao studentDao = new StudentDao();
    	List<StudentsubmitBean> list = null;
    	
    	try {
			list = studentDao.listSubmit(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd"); //这个是设置时间的格式;
    	java.util.Date currentTime = new java.util.Date();//得到当前系统时间
    	String str_date = formatter.format(currentTime); //将日期时间格式化
    	request.setAttribute("data", str_date);
    	request.setAttribute("list", list);
		request.getRequestDispatcher("student_Submit.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
