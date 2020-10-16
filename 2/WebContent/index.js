'use strict'
var isSend = false;
window.onload=function(){
    var InputName = document.getElementById("name");
    var InputSex = document.getElementsByName("sex");
    var InputAge = document.getElementById("age");
    var InputTelphone = document.getElementById("tel");
    var InputEmail = document.getElementById("email");
    var InputUserName = document.getElementById("username");
    var InputPassword = document.getElementById("password");
    var InputHobby = document.getElementsByName("hobby");
    var Inputmusic = document.getElementById("music");
    var Check_agreement = document.getElementById("agreement");
   // var ReCheck_agreement = document.getElementById("agreement");
    Check_agreement.onchange=function(){
    	Checkagreement(Check_agreement);
    }
//  ReCheck_agreement.onchange=function(){
//  	Checkagreement(Check_agreement.value);
//  }
    InputAge.onchange=function(){
        checkedAge(InputAge.value);
    }
    InputTelphone.onchange=function(){
        checkedTel(InputTelphone.value)
    }
    InputEmail.onchange=function(){
        checkedEmail(InputEmail.value)
    }
    InputUserName.onchange=function(){
        checkedUserName(InputUserName.value)
    }
    InputPassword.onchange=function(){
        checkedPassword(InputPassword.value)
    }
    document.getElementById("submit").onclick=function(){
        if(isSend){
            alert("提交成功")
            $.ajax({
                url:'/test1/UserServlet',
                type:'GET',
                dataType:"text",
                contentType:"application/json;charset=utf-8",
                data:{operation:'insert',name:InputName.value,sex:InputSex[0].checked,age:InputAge.value,tel:InputTelphone.value,
                    email:InputEmail.value,username:InputUserName.value,password:InputPassword.value,hobby:InputHobby.value,
                    music:Inputmusic.value,agreement:Check_agreement[Check_agreement.selectedIndex].text},
                success:function(res,xml){
                    //请求成功后执行的代码
                    console.log("res"+res)
                },
                error:function(msg){
                    //失败后执行的代码
                    console.log("status:"+JSON.stringify(msg));
                }
            });
        }else{
            alert("提交失败")
        }
    }
}
function Checkagreement(agreement){
	console.log(agreement.check)
	if(agreement.checked){
		isSend=true;
		document.getElementById("agreementErr").innerText = ""
	}else{
		document.getElementById("agreementErr").innerText = "请阅读并勾选用户协议"
		isSend=false;
	}
}
function checkedAge(age){
    if(age != ""){
        if(!isNaN(age) && age > 0 && age <= 150){//！！！
            document.getElementById("ageErr").innerText = "输入正确";
            isSend = true;
        }else{
            document.getElementById("ageErr").innerText = "年龄不得超过150";
            isSend = false;
        }
    }else{
        document.getElementById("ageErr").innerText = "年龄不能为空";
        isSend = false;
    }
}
function checkedTel(telphone){
    var mobile = /^1[3456789]\d{9}$/.test(telphone)
    var tel = /^(\d{7,8})(-(\d{3,}))?$/.test(telphone)
    if(telphone != ""){
        if(!(mobile) && !(tel)){//！！！
            document.getElementById("telErr").innerText = "号码有误请重填";
            isSend = false;
        }else{
            document.getElementById("telErr").innerText = "输入正确";
            isSend = true;
        }
    }else{
        document.getElementById("telErr").innerText = "手机号码为空";
        isSend = false;
    }
}
function checkedEmail(email){
    var reg = /^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$/.test(email)
    if(email != ""){
        if(!reg){
            document.getElementById("mailErr").innerText = "邮件有误";
            isSend = false;
        }else{
            document.getElementById("mailErr").innerText = "输入正确";
            isSend = true;
        }
    }else{
        document.getElementById("mailErr").innerText = "邮件为空";
        isSend = false;
    }
}
function checkedUserName(username){
    if(username.length > 0 && username.length <= 15){
        document.getElementById("userErr").innerText = "输入正确";
        isSend = true;
    }else{
        document.getElementById("userErr").innerText = "用户名0-15位";
        isSend = false;
    }
}
function  checkedPassword(password) {
    if(password.length >= 4 && password.length <= 20){
        document.getElementById("pwdErr").innerText = "输入正确";
        isSend = true;
    }else{
        document.getElementById("pwdErr").innerText = "请输入4~20字符";
        isSend = false;
    }
}