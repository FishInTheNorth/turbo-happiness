package servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import Dao.studentDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class studentUplodeServlet
 */
public class studentUplodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentUplodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setCharacterEncoding("GB2312");
         String[] allowTypes ={"pdf"};

         PrintWriter out = response.getWriter();
    	 studentDao studentDao = new studentDao();
    	 HttpSession user = request.getSession();

    	 String userId = (String) user.getAttribute("Id");
    	 java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd"); //���������ʱ��ĸ�ʽ;
     	 java.util.Date currentTime = new java.util.Date();//�õ���ǰϵͳʱ��
     	 String str_date = formatter.format(currentTime); //������ʱ���ʽ��

    	 String message = "";
    	 String filename = "";
    	 String tableName = "";
    	 int i = 0,j = 0;

    	 try {
			i = studentDao.selectStage(str_date, userId);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
   	if ( i != 0) {

   		if (i == 1) {
			tableName="shixiReport";
		}else if (i == 2) {
			tableName = "shixunReport";
		}else{
			tableName = "shijianReport";
		}
   	 DiskFileItemFactory factory;
		factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);

     String path = "C:/Users/17795/workspace/PT/WebContent/resources/plugins/pdfjs/web";

         List<FileItem> items = null;
			try {
				items = (List<FileItem>) upload.parseRequest(request);
			} catch (FileUploadException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
         Iterator itr = items.iterator();
         while (itr.hasNext()) {
              FileItem item = (FileItem) itr.next();
              if(item.isFormField()){
                  System.out.println("�ı���Ϣ");
              }
              else{
                   if (item.getName() != null && !item.getName().equals("")) {
                       String name = item.getName();
                       String type = name.substring(name.lastIndexOf('.')+1);
                       boolean flag = false;
                       for(String at:allowTypes){
                           if(at.equals(type)){
                               flag = true;
                           }
                       }
                       if(flag==false){
                        System.out.println("�ļ���ʽ��֧��");
                        message = message + "�ļ���ʽ��֧��";
                       }else{
                           int start = name.lastIndexOf("\\");
                           filename = name.substring(start+1);
                           System.out.print(filename);
                           System.out.println();
                           File file = new File(path+"/"+filename);
                           try {
								item.write(file);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                           try {
							i = studentDao.storage(userId, tableName, str_date, filename);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                           System.out.print(file);
                           message = message +"�ļ��ϴ��ɹ�";
                       }
                   }else{
                       System.out.println("��ѡ����ϴ��ļ�");
                       message = message +"��ѡ����ϴ��ļ�";
              }
     }
	}
}else {
		message =message + "�Ƿ��ύ";
	}
   	if (j == 1) {
		message = message + "�ļ��洢�ɹ�";
	}
    request.setAttribute("message", message);
    request.getRequestDispatcher("studentSubmit").forward(request, response);
	}
}
