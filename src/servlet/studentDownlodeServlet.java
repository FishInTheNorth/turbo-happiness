package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Dao.StudentDao;

/**
 * Servlet implementation class studentDownlode
 */
public class studentDownlodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentDownlodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("GB2312"); 
		String stage = request.getParameter("s");
		System.out.println(stage);
		String week = request.getParameter("w");
		System.out.println(week);
		HttpSession user = request.getSession();
    	String userId = (String) user.getAttribute("Id");
    	String table = "";
    	String address = "";
    	PrintWriter out = response.getWriter();
		StudentDao studentDao = new StudentDao();
		
		if (stage.equals("")||week.equals("")) {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"访问错误！\");");
			out.println("window.location.href='studentSubmit'");
			out.println("</script>");
		}else {
			if (stage.equals("实习阶段")) {
				table = "shixireport";
			}else if (stage.equals("实训阶段")) {
				table = "shixunreport";
			}else {
				table = "shijianreport";
			}
			try {
				address = studentDao.address(table, week, userId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		if (address.equals("")) {
			out.println("<script type='text/javascript'>");
			out.println("window.alert(\"未检测到作业！\");");
			out.println("window.location.href='studentSubmit'");
			out.println("</script>");
		}else {
			request.setAttribute("address", address);
			request.getRequestDispatcher("student_Reading.jsp").forward(request, response);
		}
//			else {
//			String path = "C:\\Users\\17795\\workspace\\PT\\WebContent\\resources\\plugins\\pdfjs\\web\\";
//			File file = new File(path + address);
//			System.out.print(path+address);
//			// 设置response的编码方式
//			response.setContentType("application/x-msdownload");
//			// 写明要下载的文件的大小
//			response.setContentLength((int) file.length());
//			response.setHeader("Content-Disposition", "attachment;filename="
//					+ new String(address.getBytes("utf-8"), "iso-8859-1"));
//			// 读出文件到i/o流
//			FileInputStream fis = new FileInputStream(file);
//			BufferedInputStream buff = new BufferedInputStream(fis);
//	 
//			byte[] b = new byte[1024];// 相当于我们的缓存
//			int k = 0;// 该值用于计算当前实际下载了多少字节
//	 
//			// 从response对象中得到输出流,准备下载
//			OutputStream myout = response.getOutputStream();
//	 
//			// 开始循环下载
//			while (-1 != (k = fis.read(b, 0, b.length))) {
//				// 将b中的数据写到客户端的内存
//				myout.write(b, 0, k);
//			}
//			// 将写入到客户端的内存的数据,刷新到磁盘
//			myout.flush();
//		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
