package servlet;

import Dao.AdminDao;
import bean.AdminBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "adminInfoServlet")
public class adminInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = (String) request.getSession().getAttribute("id"); //从session获取id
        AdminDao dao = new AdminDao();
        AdminBean bean = null;
        try {
            bean = dao.adminInfo(userName); //获取bean
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 将bean作为参数传到admin_index.jsp页面
        request.setAttribute("bean", bean);

        // 带参数跳转到admin_index.jsp
        request.getRequestDispatcher("admin_index.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
