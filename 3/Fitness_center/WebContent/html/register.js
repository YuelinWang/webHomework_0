window.onload=function(){
	var rname=document.getElementById("rname");
	var rpass=document.getElementById("rpass");
	var repass=document.getElementById("repass");
	var email=document.getElementById("email");
	var tel=document.getElementById("tel");
	var character=document.getElementById("character");
	var select=document.getElementById("grade");
	rname.onchange=function(){
		if(String(rname.value).length!==11){
			document.getElementById("rname-html").style.color="red";
			document.getElementById("rname-html").innerHTML="账号格式不正确";
		}else {
			document.getElementById("rname-html").innerHTML="OK";
			document.getElementById("rname-html").style.color="green";
		}
	}
	rpass.onchange=function(){
		if(String(rpass.value).length!==6){
			document.getElementById("rpass-html").style.color="red";
			document.getElementById("rpass-html").innerHTML="密码长度不正确";
		}else{
			document.getElementById("rpass-html").innerHTML="OK";
			document.getElementById("rpass-html").style.color="green";
		}
	}
	repass.onchange=function(){
		if(String(repass.value).length!==6){
			document.getElementById("repass-html").style.color="red";
			document.getElementById("repass-html").innerHTML="密码长度不正确";
		}else{
			document.getElementById("repass-html").innerHTML="OK";
			document.getElementById("repass-html").style.color="green";
		}
	}
	email.onchange=function(){
		if(!/\w+((-w+)|(\.\w+))*\@[\w]+((\.|-)[\w]+)*\.[\w]+/.test(email.value)){
			document.getElementById("email-html").innerHTML="电子邮件格式不合法！";
			document.getElementById("email-html").style.color="red";
		}else{
			document.getElementById("email-html").innerHTML="OK";
			document.getElementById("email-html").style.color="green";
		}
	}
	tel.onchange=function(){
		if(String(tel.value).length!==11){
			document.getElementById("tel-html").style.color="red";
			document.getElementById("tel-html").innerHTML="联系电话长度不正确";
		}else if(!/0?(13|14|15|17|18)[0-9]{9}/.test(tel.value)){
			document.getElementById("tel-html").style.color="red";
			document.getElementById("tel-html").innerHTML="联系电话格式不正确";
		}else{
			document.getElementById("tel-html").style.color="green";
			document.getElementById("tel-html").innerHTML="OK";
		}
	}
	character.onchange=function(){
		if(String(character.value)=="管理员"){
			document.getElementById("show").style.display="none";
		}
		else{
			document.getElementById("show").style.display="block";
		}
	}
};
