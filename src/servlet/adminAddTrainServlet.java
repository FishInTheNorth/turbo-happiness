package servlet;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "adminAddTrainServlet")
public class adminAddTrainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 处理上传
        SmartUpload su = new SmartUpload();
        su.initialize(this.getServletConfig(), request, response);
        su.setAllowedFilesList("xls");
        su.setCharset("utf-8");

        try {
            su.upload();
        } catch (SmartUploadException e) {
            e.printStackTrace();
        }
        String schoolYear = su.getRequest().getParameter("schoolYear");
        String shixiBeginTime = su.getRequest().getParameter("shixiBeginTime");
        String shixiEndTime = su.getRequest().getParameter("shixiEndTime");
        String shixunBeginTime = su.getRequest().getParameter("shixunBeginTime");
        String shixunEndTime = su.getRequest().getParameter("shixunEndTime");
        String shijianBeginTime = su.getRequest().getParameter("shijianBeginTime");
        String shijianEndTime = su.getRequest().getParameter("shijianEndTime");
        if (!StringUtil.isNull(schoolYear)){
            response.sendRedirect("admin_register_pt.jsp?f=1");
            return;
        }
        if (!StringUtil.isNull(shixiBeginTime)){
            response.sendRedirect("admin_register_pt.jsp?f=2");
            return;
        }
        if (!StringUtil.isNull(shixiEndTime)){
            response.sendRedirect("admin_register_pt.jsp?f=3");
            return;
        }
        if (!StringUtil.isNull(shixunBeginTime)){
            response.sendRedirect("admin_register_pt.jsp?f=4");
            return;
        }
        if (!StringUtil.isNull(shixunEndTime)){
            response.sendRedirect("admin_register_pt.jsp?f=5");
            return;
        }
        if (!StringUtil.isNull(shijianBeginTime)){
            response.sendRedirect("admin_register_pt.jsp?f=6");
            return;
        }
        if (!StringUtil.isNull(shijianEndTime)){
            response.sendRedirect("admin_register_pt.jsp?f=7");
            return;
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
