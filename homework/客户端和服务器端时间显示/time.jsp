<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <%@ page import="java.text.SimpleDateFormat"%/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
	<title>服务器时间与客户端时间</title>
</head>
<style>
	body {
		width: 100%;
		height: 100%;
		background-image: url(image/index.jpg);
		background-repeat: no-repeat center center fixed;
		background-size: cover;
		background-attachment: fixed;
	}
	
	#server {
		width: auto;
		height: 10%;
		font-size: 20px;
		letter-spacing: 5px;
		display: block;
		text-align: center;
		font-family: "楷体";
		margin-top: 200px;
		margin-bottom: 50px;
	}
	
	#client {
		width: auto;
		height: 20%;
		font-size: 20px;
		letter-spacing: 5px;
		display: block;
		text-align: center;
		font-family: "楷体";
	}
</style>
<script>
	function timer() {

		var time = new Date();
		document.getElementById("client").innerHTML = "客户端时间：" + time;
	}
	var now = new Date(
		<%=new java.util.Date().getTime()%>
        ); function run() { now.setSeconds(now.getSeconds() + 1); document.getElementById("server").innerHTML = "服务器时间：" + now; } setInterval("run();", 1000); setInterval("timer()", 1000);
        </script>

        <body>
            <center>
                <div id="server"></div>
                <div id="client"></div>
            </center>
        </body>

        </html>