<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
    <%@ page import="java.io.*" %>
        <%@ page import="java.util.*" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta charset="UTF-8">
                <title>文件未找到处理页面</title>
                <style>
                    body {
                        width: 100%;
                        height: 100%;
                        background-image: url(image/index.jpg);
                        background-repeat: no-repeat center center fixed;
                        background-size: cover;
                        background-attachment: fixed;
                    }
                    
                    span {
                        width: auto;
                        height: 10%;
                        font-size: 20px;
                        letter-spacing: 5px;
                        display: block;
                        text-align: left;
                        font-family: "楷体";
                        padding: 200px;
                        text-color: red;
                        margin-left: 200px;
                    }
                </style>
            </head>
            <%response.setStatus(HttpServletResponse.SC_OK);%>

                <body>
                    <span>
<%
  	Enumeration<String> attributeNames = request.getAttributeNames();
	out.println("页面请求URL："+request.getAttribute("javax.servlet.forward.request_uri")+"<br>");
	out.println("错误信息："+request.getAttribute("javax.servlet.error.message")+"<br>");
	out.println("错误代码："+request.getAttribute("javax.servlet.error.status_code")+"<br>");
%>
	</span>
                    <center>
                        <p>计算机1705-173401010517-王跃霖</p>
                    </center>
                    </pre>
                </body>

            </html>