package servlet;

import Dao.AdminDao;
import bean.AdminBean;
import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "adminEditDoServlet")
public class adminEditDoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adminName = StringUtil.toCN(request.getParameter("adminName")); //获取修改的姓名
        String adminPhone = request.getParameter("adminPhone"); //获取修改的电话
        String adminQq = request.getParameter("qq");
        String sex = request.getParameter("sex");
        if (adminQq == null || "".equals(adminQq)){
            adminQq = "";
        }
        AdminBean bean = new AdminBean();
        bean.setAdminId((String) request.getSession().getAttribute("id"));
        bean.setAdminName(adminName);
        bean.setAdminPhone(adminPhone);
        bean.setAdminQq(adminQq);
        bean.setSex(Integer.parseInt(sex));
        AdminDao dao = new AdminDao();

        int result = 0;
        try {
            result = dao.adminEdit(bean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (result > 0) {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"修改成功！\");");
            out.println("window.location.href='/adminInfo';");
            out.println("</script>");
        } else {
            out.println("<script type='text/javascript'>");
            out.println("window.alert(\"修改出错！\");");
            out.println("window.location.href='/adminEdit';");
            out.println("</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
