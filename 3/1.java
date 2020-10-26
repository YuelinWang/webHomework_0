package cn.edu.sau.web.dao;

import cn.edu.sau.web.UserInfo.UserInfo;

public interface SQLDAO {
	public String select();
    public String selectWay(String way,String input);
    public String insert(UserInfo userInfo);
    public String update(String id,UserInfo UserInfo);
    public String delete(int id);
    
}








package cn.edu.sau.web.dao;

import java.sql.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.edu.sau.web.UserInfo.UserInfo;

public class SQLDAOImpl implements SQLDAO{
	private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/business?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC" +
            "&useUnicode=true&characterEncoding=UTF-8";
    private static final String username = "tfuser";
    private static final String password = "sau123";
    private String dbTableName = "bus";
    private Connection conn = null;
    private Statement stmt = null;
    @Override
    public String select() {
        connection();
        String sql = "select * from "+dbTableName;
        try {
            ResultSet resultSet = stmt.executeQuery(sql);
            resultSet.close();
            stmt.close();
            conn.close();
            return getData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    } 
    @Override
    public String selectWay(String way, String input) {
        connection();
        String sql = "select * from " + dbTableName + " where " + way + "='" + input + "'";
        try {
            ResultSet resultSet = stmt.executeQuery(sql);
            resultSet.close();
            stmt.close();
            conn.close();
            return getData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String insert(UserInfo userInfo) {
        String sql = "insert into "+dbTableName+"(name,email,key,business,sex,telphone,start,end) values('"+userInfo.getName()+"','"+userInfo.getEmail()+"','"+userInfo.getKey()+"','"+userInfo.getBusiness()+"','"+userInfo.getSex()+"','"+userInfo.getTelphone()+"','"+userInfo.getStart()+"','"+userInfo.getEnd()+"')";
        try {
            Class.forName(JDBC_DRIVER);
            try {
                conn = DriverManager.getConnection(DB_URL,username,password);
                stmt = conn.createStatement();
                System.out.println(sql);
                stmt.execute(sql);
                stmt.close();
                conn.close();
                return "1";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "0";
    }

    @Override
    public String update(String id,UserInfo UserInfo) {
        String sql = "update "+dbTableName+" set name = '"+UserInfo.getName()+"',sex = '"+UserInfo.getSex()+               
        		",email='"+UserInfo.getEmail()+"',business="+UserInfo.getBusiness()+",telphone='"+UserInfo.getTelphone()
                +"',start='"+UserInfo.getStart()+"',End='"+UserInfo.getEnd()+"' where id = "+id;
        try {
            Class.forName(JDBC_DRIVER);
            try {
                conn = DriverManager.getConnection(DB_URL,username,password);
                stmt = conn.createStatement();
                stmt.executeUpdate(sql);
                stmt.close();
                conn.close();
                return "1";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return "0";
    }

    @Override
    public String delete(int id) {
        String sql = "delete from "+dbTableName+" where id= "+id;
        try {
            Class.forName(JDBC_DRIVER);
            try {
                conn = DriverManager.getConnection(DB_URL,username,password);
                stmt = conn.createStatement();
                stmt.execute(sql);
                stmt.close();
                conn.close();
                return "1";
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "0";
    }
    private void connection(){
        try {
            Class.forName(JDBC_DRIVER);
            try {
                conn = DriverManager.getConnection(DB_URL,username,password);
                stmt = conn.createStatement();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    private String getData(ResultSet resultSet) throws SQLException {
        JSONArray jsonArray = new JSONArray();
        while(resultSet.next()){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name",resultSet.getString("name"));
            jsonObject.put("key",resultSet.getString("key"));
            jsonObject.put("email",resultSet.getString("email"));
            jsonObject.put("sex",resultSet.getString("sex"));
            jsonObject.put("business",resultSet.getString("business"));
            jsonObject.put("telphone",resultSet.getString("telphone"));
            jsonObject.put("start",resultSet.getInt("start"));
            jsonObject.put("end",resultSet.getString("end"));
            jsonArray.add(jsonObject);
        }
        return jsonArray.toString();
    }
}









package cn.edu.sau.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.sau.web.UserInfo.UserInfo;
import cn.edu.sau.web.dao.SQLDAO;
import cn.edu.sau.web.dao.SQLDAOImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
        String operation = request.getParameter("operation");
        SQLDAO sqldao = new SQLDAOImpl();
        UserInfo userInfo = new UserInfo();
        String name;
        String email;
        String key;
        String sex;
        String telphone;
        String hobby;
        String result = null;
        System.out.println("success");
        switch(operation){
            case "select":result = sqldao.select();break;
            case "update":
                name = request.getParameter("name");
                email = request.getParameter("email");
                key = request.getParameter("key");
                sex = request.getParameter("sex");
                telphone = request.getParameter("telphone");
                hobby = request.getParameter("hobby");

                userInfo.setName(name);
                userInfo.setEmail(email);
                userInfo.setKey(key);
                userInfo.setSex(sex);
                userInfo.setTelphone(telphone);
                userInfo.setHobby(hobby);

                result = sqldao.insert(userInfo);
                break;
                
            name = request.getParameter("name");
            email = request.getParameter("email");
            key = request.getParameter("key");
            sex = request.getParameter("sex");
            telphone = request.getParameter("telphone");
            hobby = request.getParameter("hobby");

            userInfo.setName(name);
            userInfo.setEmail(email);
            userInfo.setKey(key);
            userInfo.setSex(sex);
            userInfo.setTelphone(telphone);
            userInfo.setHobby(hobby);
            case "delete":
                name = request.getParameter("name");
                result = sqldao.delete(Integer.parseInt(name));
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}






package cn.edu.sau.web.UserInfo;

public class UserInfo {
	private String name;
	private String key;
	private String telephone;
	private String email;
	private String sex;
	private String hobby;

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}
	
	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public String getkey() {
		return key;
	}

	public void setkey(String key) {
		this.key = key;
	}

	public void setrename(String rename) {
		this.name = rename;
	}
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String gethobby() {
		return hobby;
	}

	public void sethobby(String hobby) {
		this.hobby = hobby;
	}

}













