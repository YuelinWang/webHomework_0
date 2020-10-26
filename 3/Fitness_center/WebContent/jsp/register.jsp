<%@page import="java.sql.*,java.util.*"%>

<%
	String sname=request.getParameter("rname").toString();
%>
<input type="text" name="myname" value="<%=sname%>">