package cn.edu.sau.web.servlet;

//import cn.edu.sau.web.;
import cn.edu.sau.web.dao.SQLDAOImpl;
import cn.edu.sau.web.dao.SQLDAO;
import cn.edu.sau.web.UserInfo.UserInfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class UserServlet extends HttpServlet{
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String operation = request.getParameter("operation");
        SQLDAO sqldao = new SQLDAOImpl();
        UserInfo userInfo = new UserInfo();
        String name,email,key,sex,telephone,hobby,result;
        result = "";
        switch(operation){
            case "select":result = sqldao.select();break;
            case "insert":
                name = request.getParameter("name");
                email = request.getParameter("email");
                key = request.getParameter("key");
                sex = request.getParameter("sex");
                telephone = request.getParameter("telephone");
                hobby = request.getParameter("hobby");
                userInfo.setname(name);
                userInfo.setemail(email);
                userInfo.setkey(key);
                if("true".equals(sex)){
                    userInfo.setSex("男");
                }else{
                    userInfo.setSex("女");
                }
                userInfo.setTelephone(telephone);
                userInfo.sethobby(hobby);
                result = sqldao.insert(userInfo);
                break;
            case "selectWay":
                String way = request.getParameter("way");
                String input = request.getParameter("input");
                result = sqldao.selectWay(way,input);
                break;
        }
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Set-Cookie","HttpOnly;Secure;SameSite=None");
        PrintWriter out = response.getWriter();
        out.write(result);
	}
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            super.doPost(req, resp);
        }
}
