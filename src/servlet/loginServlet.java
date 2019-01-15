package servlet;

import Dao.LoginDao;
import util.JudgeUtil;
import util.StringUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = StringUtil.toCN(request.getParameter("account")); //获取账号并转码
        String password = StringUtil.toCN(request.getParameter("password")); //获取密码并转码
        String type = request.getParameter("userType"); //获取用户类型

        if(userName == null || "".equals(userName)){
            response.sendRedirect("login.jsp?f=1");  //用户名为空
            return;
        }
        if(password == null || "".equals(password)){
            response.sendRedirect("login.jsp?f=2");  //密码为空
            return;
        }
        if(type == null || "".equals(type)){
            response.sendRedirect("login.jsp?f=3"); //未选择类型
            return;
        }
        String type1 = JudgeUtil.judgeUser(type);  //类型对应转换
        LoginDao login = new LoginDao();
        HashMap<String,Object> map = null; //获取检查用户密码返回HashMap对象
        try {
            map = login.check(userName,password,type1);
            if((int)(map.get("result")) == 1){  //用户密码正确
                request.setCharacterEncoding("UTF-8");
                request.getSession().setAttribute("userName",map.get("userName"));//将自身姓名放入session
                request.getSession().setAttribute("id",map.get("id")); //将自身id放入session
                //if(map.size() == 4){
                 //   request.getSession().setAttribute("train_id",map.get("train_id")); //若为学生再将其实训id放入其中
                //}
                request.getRequestDispatcher(type1+"Info").forward(request,response); //跳转到相应界面
            }
            else
                response.sendRedirect("login.jsp?f=4");  //账号密码错误
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
