$(function(){
    $("#confirm").click(function () {
        var phoneNum = $("#phoneNum").val();
        if (checkPhoneNum(phoneNum)) {
            $.get("/shortMessage/" + phoneNum,function (result) {
                if(result == "success") {
                    unclickConfirm();
                    alert("短信发送成功")
                }
            })
        }
    });
    
    $("#update").click(function () {
        if (checkPwd()){
            var phoneNum = $("#phoneNum").val();
            var valicode = $("#checkCode").val();
            var checkNum = $("#checknum").val();
            $.post("/user/retrieve", {phoneNum:phoneNum, valicode:valicode,checkNum:checkNum }, function (result) {
                if (result == "success") {
                    alert("密码修改成功");
                    $.cookie('checknum', "");
                    location.href = "/login";
                } else if (result == "ERROR_VALI_CODE") {
                    alert("验证码错误");
                } else {
                    alert("密码修改失败");
                }

            })
        }
    });
    
    function unclickConfirm() {
        
    }
    
    function checkPwd() {
        var checkNum = $("#checknum").val();
        var password = $("#password").val();
        if (!checkNum){
            alert("密码不能为空");
            return false;
        }
        if (checkNum == password){
            return true;
        }
        alert("输入密码不一致");
        return false;
    }
    
    function checkPhoneNum(str) {
        var myreg = /^((1[0-9]{2})+\d{8})$/;
        var isPhone = myreg.test(str);
        if (!isPhone) {
            alert("请输入正确手机号码")
        }
        return isPhone;
    }
});