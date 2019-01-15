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
        String userName = StringUtil.toCN(request.getParameter("account")); //��ȡ�˺Ų�ת��
        String password = StringUtil.toCN(request.getParameter("password")); //��ȡ���벢ת��
        String type = request.getParameter("userType"); //��ȡ�û�����

        if(userName == null || "".equals(userName)){
            response.sendRedirect("login.jsp?f=1");  //�û���Ϊ��
            return;
        }
        if(password == null || "".equals(password)){
            response.sendRedirect("login.jsp?f=2");  //����Ϊ��
            return;
        }
        if(type == null || "".equals(type)){
            response.sendRedirect("login.jsp?f=3"); //δѡ������
            return;
        }
        String type1 = JudgeUtil.judgeUser(type);  //���Ͷ�Ӧת��
        LoginDao login = new LoginDao();
        HashMap<String,Object> map = null; //��ȡ����û����뷵��HashMap����
        try {
            map = login.check(userName,password,type1);
            if((int)(map.get("result")) == 1){  //�û�������ȷ
                request.setCharacterEncoding("UTF-8");
                request.getSession().setAttribute("userName",map.get("userName"));//��������������session
                request.getSession().setAttribute("id",map.get("id")); //������id����session
                //if(map.size() == 4){
                 //   request.getSession().setAttribute("train_id",map.get("train_id")); //��Ϊѧ���ٽ���ʵѵid��������
                //}
                request.getRequestDispatcher(type1+"Info").forward(request,response); //��ת����Ӧ����
            }
            else
                response.sendRedirect("login.jsp?f=4");  //�˺��������
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
