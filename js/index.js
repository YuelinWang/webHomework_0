var ran;
/**********验证码生成**********/
function YZM() {
    ran = Math.floor(Math.random() * 9000 + 1000);
    var span = document.getElementById("yzm_span");
    span.innerText = ran;
}

/*********校验用户名方法**************/

function checkName() {
    //汉字
    var reg = /^[\u4e00-\u9fa5]{3,5}$/;
    return check("uname", reg);
}

/*********校验手机号码方法**************/

function checkPhone() {
    //手机号
    var reg = /^\d{11}$/;
    return check("phone", reg);
}

/*********校验邮箱方法**************/

function checkEmail() {
    //邮箱
    var reg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    return check("email", reg);
}


/*********密码邮箱方法**************/

function checkPwd() {
    //密码
    var reg = /^\d{3,6}$/;
    return check("pwd", reg);
}


function check(id, reg) {
    var uname = document.getElementById(id);
    var val = uname.value;
    var alt = uname.alt;
    var span = document.getElementById(id + "_span");
    if (val == null || val == "") {
        span.innerText = "×" + alt + "不能为空";
        span.style.color = "red";
        return false;
    } else if (reg.test(val)) {
        span.innerText = "√" + alt + "合法";
        span.style.color = "green";
        return true;
    } else {
        span.innerText = "×" + alt + "不合法";
        span.style.color = "red";
        return false;
    }
}

/*******性别校验**************/

function checkSex() {

    var sex = document.getElementsByName("sex");
    var span = document.getElementById("sex_span");
    for (var i in sex) {
        if (sex[i].checked) {
            span.innerHTML = "性别选择成功";
            span.style.color = "green";
            return true;
        }
    }
    span.innerHTML = "请选择性别";
    span.style.color = "red";
    return false;
}

/*******验证码输入校验********************/
function checkYZM() {
    var yzm = document.getElementById("yzm").value;
    var span = document.getElementById("yzm2_span");
    if (ran == yzm) {
        span.style.color = "green";
        span.innerText = "验证码正确";
        return true;
    } else {
        span.style.color = "red";
        span.innerText = "验证码不正确";
        return false;
    }
}

/*******是否同意**********/
function checkAgree() {
    //同意框
    var check = document.getElementById("check");
    //提交
    var sub = document.getElementById("sub");
    sub.disabled = !check.checked;
}

function zong() {
    var flag = checkName() && checkPwd() && checkSex() && checkYZM() && checkAgree() && checkEmail();
    return flag;
}