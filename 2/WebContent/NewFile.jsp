<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<title>sign in</title>
<script type="text/javascript" src="jquery-3.5.1.js"></script>
<script type="text/javascript" src="index.js"></script>
<style>
div{
    background:#ac00cc99;
    font-size:24px;
    padding:5px;
    color:white;
    text-align:center;
}
form{
    background: #F8F8FF ;
    border:#357FC4 solid 1px;
    color:#575454;  
    width:400px;
    margin:20px auto;
    font-size:15px;
}
table{
    margin:10px auto;
}
a{
    text-decoration:none;
}
input[type="button"]{
    background:#6eb6f3ba;
    color:white;
    font-size:15px;
    font-weight:bold;
    width:120px;
    height:40px;
}
td:first-child{
    text-align:right;
    padding:0 5px;
}
td:only-child{
    text-align:center;
    font-size:12px;
}
p1:before{
    content:"*";
    color:red;
}
input[type="text"]:read-only{
    border:#888484 solid 2px;
    background:#888484;
    font-weight:bold;   
}
input[type="text"]:hover{
    background:#EFD9AC;
}
</style>
</head>

<body>
<form>
<div>商城会员用户注册</div>
<table>
    <tr>
    	<td>
    		<p1>用户名</p1>
    	</td>
    	<td>
    		<input type="text" id="username" placeholder="请输入你的用户名"/>
    		<span id="usernameErr" class="err"></span>
    	</td>
    </tr>
    
    <tr>
    	<td>
    		<p1>email</p1>
    	</td>
    	<td>
    		<input type="text" id="email" placeholder="请输入你的邮箱" />
    		<span id="mailErr" class="err"></span>
    	</td>
    </tr>
    
    <tr>
    	<td>
    		<p1>密码</p1>
    	</td>
    	<td>
    		<input type="password" id="password" placeholder="请输入你的密码"/>
    		<span id="pwdErr" class="err"></span>
    	</td>
    </tr>
    
    <tr>
    	<td>
    		<p1>真实姓名</p1>
    	</td>
    	<td>
    		<input type="text" id="name" placeholder="请输入你的真实姓名"/>
    		<span id="nameErr" class="err"></span>
    	</td>
    </tr>
    
    <tr>
    	<td>性别</td>
    	<td>
    		<input type="radio" name="sex" value="man" checked />男
    		<input type="radio" name="sex" value="woman" />女
    	</td>
    </tr>
    
    <tr>
    	<td>
    		<p1>年龄</p1>
    	</td>
    	<td>
    		<input type="text" id="age" placeholder="请输入你的年龄" />
    		<span id="ageErr" class="err"></span>
    	</td>
    </tr>
    
    <tr>
    	<td>
    		<p1>手机号码</p1>
    	</td>
    	<td>
    		<input type="text" id="tel" placeholder="请输入你的手机号码"/>
    		<span id="telErr" class="err"></span>
    	</td>
    </tr>
    
    <tr>
    	<td>爱好</td>
    	<td>
    		<input type="checkbox" name="hobby" value="soccer"/>足球
    		<input type="checkbox" name="user_hobby" value="running"/>跑步
    		<input type="checkbox" name="user_hobby" value="swimming"/>游泳
    	</td>
    </tr>
    
    <tr>
    	<td>喜欢的音乐</td>
    	<td><select id="music" >
    		<option value="爵士">爵士</option>
    		<option value="民谣">民谣</option>
    		<option value="流行">流行</option>
   		</td>
    </tr>
    
    <tr><td colspan="2"><p><input type="checkbox" id="agreement" checked/>我已看过并接受<a href="#">《用户协议》</p><span id="agreementErr"></span></a></td></tr>
    <tr><td colspan="2"><input type="submit" id="submit" value="立即注册" /></td></tr>
</table>
</form>
</body>
</html>