<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 table,th,tr,td{
 	margin:30px auto;text-align:center;
	border:1px solid;cellspacing:0;
	padding:10px;
 	border-collapse:collapse;}
</style>
</head>
<body>
	<table>
    	<caption style="font-size:26px;font-family:'楷体';">用户列表</caption>
        <tr>
        	<th>用户账号</th><th>性别</th><th>生日</th><th>邮箱</th><th>电 话</th><th>角  色</th><th>爱  好</th>
        </tr>
        <c:forEach var="user" items="${userList.listData}">
        <tr>
        	<td>${user.rname}</td>
            <td>${user.sex}</td>
            <td>2020-01-01</td>
            <td>${user.email}</td>
            <td>${user.tel}</td>
            <td>vbsbvsd</td>
            <td>${user.hobby}</td>
        </tr>
        </c:forEach>
		
	</table>
	<center>
	<tr>
		<td colspan="5">总人数：${userList.count} &nbsp;&nbsp; <a
			href="./IframServlet?beginIndex=${userList.preIndex}">上一页</a>
			&nbsp;&nbsp; <a
			href="./IframServlet?beginIndex=${userList.nextIndex}">下一页</a>
		</td>
	</tr>
	</center>

</body>
</html>