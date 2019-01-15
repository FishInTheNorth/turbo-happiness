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
			out.println("window.alert(\"���ʴ���\");");
			out.println("window.location.href='studentSubmit'");
			out.println("</script>");
		}else {
			if (stage.equals("ʵϰ�׶�")) {
				table = "shixireport";
			}else if (stage.equals("ʵѵ�׶�")) {
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
			out.println("window.alert(\"δ��⵽��ҵ��\");");
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
//			// ����response�ı��뷽ʽ
//			response.setContentType("application/x-msdownload");
//			// д��Ҫ���ص��ļ��Ĵ�С
//			response.setContentLength((int) file.length());
//			response.setHeader("Content-Disposition", "attachment;filename="
//					+ new String(address.getBytes("utf-8"), "iso-8859-1"));
//			// �����ļ���i/o��
//			FileInputStream fis = new FileInputStream(file);
//			BufferedInputStream buff = new BufferedInputStream(fis);
//	 
//			byte[] b = new byte[1024];// �൱�����ǵĻ���
//			int k = 0;// ��ֵ���ڼ��㵱ǰʵ�������˶����ֽ�
//	 
//			// ��response�����еõ������,׼������
//			OutputStream myout = response.getOutputStream();
//	 
//			// ��ʼѭ������
//			while (-1 != (k = fis.read(b, 0, b.length))) {
//				// ��b�е�����д���ͻ��˵��ڴ�
//				myout.write(b, 0, k);
//			}
//			// ��д�뵽�ͻ��˵��ڴ������,ˢ�µ�����
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
