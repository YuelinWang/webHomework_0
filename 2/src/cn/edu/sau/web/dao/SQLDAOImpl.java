package cn.edu.sau.web.dao;

import java.sql.*;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import cn.edu.sau.web.UserInfo.UserInfo;

public class SQLDAOImpl implements SQLDAO{
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/shopmanagement?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String username = "ftuser";
    private static final String password = "sau123";
    private String dbTableName = "shop";
    private Connection conn = null;
    private Statement stmt = null;
    @Override
    public String select() {
        connection();
        String sql = "select * from "+dbTableName;
        try {
            ResultSet resultSet = stmt.executeQuery(sql);
            JSONArray jsonArray = new JSONArray();
            while(resultSet.next()){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("name",resultSet.getString("name"));
                jsonObject.put("key",resultSet.getString("key"));
                jsonObject.put("telephone",resultSet.getString("telephone"));
                jsonObject.put("email",resultSet.getString("email"));
                jsonObject.put("sex",resultSet.getString("sex"));
                jsonObject.put("hobby",resultSet.getString("hobby"));
                jsonArray.add(jsonObject);
            }
            return jsonArray.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String selectWay(String way, String input) {
        connection();
        String sql = "select * from " + dbTableName + " where name" + "='" + input + "'";
        try {
            ResultSet resultSet = stmt.executeQuery(sql);
            JSONArray jsonArray = new JSONArray();
            while(resultSet.next()){
            	 JSONObject jsonObject = new JSONObject();
                 jsonObject.put("name",resultSet.getString("name"));
                 jsonObject.put("key",resultSet.getString("key"));
                 jsonObject.put("telephone",resultSet.getString("telephone"));
                 jsonObject.put("email",resultSet.getString("email"));
                 jsonObject.put("sex",resultSet.getString("sex"));
                 jsonObject.put("hobby",resultSet.getString("hobby"));
                 jsonArray.add(jsonObject);
            }
            return jsonArray.toString();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String insert(UserInfo userInfo) {
        String sql = "insert into "+dbTableName+"(name,email,key,sex" +
                "telephone,hobby,kind) values('"+userInfo.getname()+"','"+userInfo.getemail()+"','" +
                userInfo.getkey()+"','"+userInfo.getSex()+"','"+userInfo.gettelephone()+"','"+userInfo.gethobby()+"')";
        try {
            Class.forName(JDBC_DRIVER);
            try {
                conn = DriverManager.getConnection(DB_URL,username,password);
                stmt = conn.createStatement();
                System.out.println(sql);
                stmt.execute(sql);
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

}
