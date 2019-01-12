package servlet;

import Dao.teacherDao;
import bean.teacherBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "teacherInfoServlet")
public class teacherInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = (String) request.getSession().getAttribute("id"); //从session获取id
        teacherDao dao = new teacherDao();
        teacherBean bean;
        bean = null;
        try {
            bean = dao.teacherInfo(userName); //获取bean
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // 将bean作为参数传到teacher_index.jsp页面
        request.setAttribute("bean", bean);

        // 带参数跳转到teacher_index.jsp
        request.getRequestDispatcher("teacher_index.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
