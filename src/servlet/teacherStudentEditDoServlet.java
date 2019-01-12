package servlet;

import Dao.teacherDao;
import bean.teacherBean;
import bean.teacherPtAllStudentBean;
import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "teacherStudentEditDoServlet")
public class teacherStudentEditDoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("GB2312");

        String studentId = request.getParameter("studentId");
        String trainId = request.getParameter("trainId");
        String name = StringUtil.toCN(request.getParameter("studentName"));
        String major = StringUtil.toCN(request.getParameter("major"));
        String phone = request.getParameter("phone");
        String qq = request.getParameter("qq");
        String sex = request.getParameter("sex");
        String company = StringUtil.toCN(request.getParameter("company"));
        String province = StringUtil.toCN(request.getParameter("province"));
        String contacts = StringUtil.toCN(request.getParameter("contacts"));
        String contactsPhone = request.getParameter("contactsPhone");

        PrintWriter out = response.getWriter();
        //将获取的数据放入teacherPtAllStudentBean里
        teacherDao teacherDao = new teacherDao();
        teacherPtAllStudentBean teacherBean = new teacherPtAllStudentBean();
        teacherBean.setStudentId(studentId);
        teacherBean.setStudentsName(name);
        teacherBean.setTrainId(Integer.parseInt(trainId));
        teacherBean.setMajor(major);
        teacherBean.setStudentPhone(phone);
        teacherBean.setStudentQq(qq);
        teacherBean.setSex(Integer.parseInt(sex));
        teacherBean.setCompany(company);
        teacherBean.setProvince(province);
        teacherBean.setContactName(contacts);
        teacherBean.setContactPhone(contactsPhone);
        System.out.println("name:"+name);
        int i = -1;
        try {
            i = teacherDao.StudentEdit(teacherBean);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (i == -1) {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"信息修改失败！\");");
            out.println("window.location.href='teacher_index.jsp'");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"信息修改成功！\");");
            out.println("window.location.href='teacherPtList'");
            out.println("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
