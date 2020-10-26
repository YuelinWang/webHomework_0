<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Fitness_center.dao.*,Fitness_center.vo.*"%>
<%@page import="Fitness_center.daofactory.*,Fitness_center.utils.*"%>
<%@page import="Fitness_center.servlet.*,java.util.*"%>
<%@page import="java.util.ArrayList,Fitness_center.daofactory.impl.*"%>
<!doctype html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>用户列表</title>
        <style>
            body{font-size:16px;}
            table{margin:30px auto;text-align:center;border-right:1px solid red;border-bottom:1px solid red;}
            td,th{border-left:1px solid red;border-top:1px solid red;padding:5px;}
            caption{font-weight:bold;font-size:18px;}
        </style>
    </head>
    <body>
        <table>
            <caption>用户列表</caption>
            <tr>
                <th>用户名</th><th>手机</th><th>电子邮件</th>
                <th>业务爱好</th><th>允许推送邮件</th><th>操作</th>
            </tr>	  
        <c:forEach var="user" items="${requestScope.listPage.listData}">
            <tr>
                <td>${user.uname}</td><td>${user.uphone}</td><td>${user.umail}</td>  
                <td>${user.strHobby}</td> <td>${user.unews}</td>   
            </tr>
        </c:forEach>     
        <tr>
                <td colspan="5">
                    总人数：${requestScope.listPage.count} &nbsp;&nbsp;
                    <a href="admin?page=user&beginIndex=${requestScope.listPage.preIndex}">上一页</a> 
                    &nbsp;&nbsp;
                    <a href="admin?page=user&beginIndex=${requestScope.listPage.nextIndex}">下一页</a> 
                </td>
            </tr> 
        </table>
    </body>
</html>