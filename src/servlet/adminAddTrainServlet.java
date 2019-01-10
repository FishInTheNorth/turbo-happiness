package servlet;

import Dao.adminDao;
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import extraBean.addTrain;
import util.DateUtil;
import util.StringUtil;
import util.uploadExcel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
        if (!StringUtil.isNull(schoolYear)) {
            response.sendRedirect("admin_register_pt.jsp?f=1");
            return;
        }
        if (!StringUtil.isNull(shixiBeginTime)) {
            response.sendRedirect("admin_register_pt.jsp?f=2");
            return;
        }
        if (!StringUtil.isNull(shixiEndTime)) {
            response.sendRedirect("admin_register_pt.jsp?f=3");
            return;
        }
        if (!StringUtil.isNull(shixunBeginTime)) {
            response.sendRedirect("admin_register_pt.jsp?f=4");
            return;
        }
        if (!StringUtil.isNull(shixunEndTime)) {
            response.sendRedirect("admin_register_pt.jsp?f=5");
            return;
        }
        if (!StringUtil.isNull(shijianBeginTime)) {
            response.sendRedirect("admin_register_pt.jsp?f=6");
            return;
        }
        if (!StringUtil.isNull(shijianEndTime)) {
            response.sendRedirect("admin_register_pt.jsp?f=7");
            return;
        }
        addTrain addTrain = new addTrain();
        addTrain.setSchoolYear(schoolYear);
        addTrain.setShixiBeginTime(DateUtil.StrToDate(shixiBeginTime));
        addTrain.setShixiEndTime(DateUtil.StrToDate(shixiEndTime));
        addTrain.setShixunBeginTime(DateUtil.StrToDate(shixunBeginTime));
        addTrain.setShixunEndTime(DateUtil.StrToDate(shixunEndTime));
        addTrain.setShijianBeginTime(DateUtil.StrToDate(shijianBeginTime));
        addTrain.setShijianEndTime(DateUtil.StrToDate(shijianEndTime));
        if (addTrain.comperTo()){
            response.sendRedirect("admin_register_pt.jsp?f=8");
            return;
        }
        File[] file = new File[4];
        uploadExcel[] uploadExcels = new uploadExcel[4];
        ArrayList<String>[] lists = new ArrayList[4];
        for (int i = 0; i < file.length; i++) {
            file[i] = su.getFiles().getFile(i);
            if (file[i].getFileName().length()==0){
                response.sendRedirect("admin_register_pt.jsp?f=9");
                return;
            }
            else {
                try {
                    file[i].saveAs("train/" + file[i].getFileName());
                    lists[i] = uploadExcels[i].getAll(file[i].getFileName());
                } catch (SmartUploadException e) {
                    e.printStackTrace();
                }
            }
        }
        addTrain.setShixiTeacherId(lists[0]);
        addTrain.setShixunTeacherId(lists[1]);
        addTrain.setShijianTeacherId(lists[2]);
        addTrain.setStudntId(lists[3]);
        adminDao dao = new adminDao();
        try {
            if(dao.adminAddTrain(addTrain)!=1){
                response.sendRedirect("admin_register_pt.jsp?f=10");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

}
