$(function () {
    $(".confirm").click(function () {
        var phoneNum = $("#phoneNum").val();
        if (checkPhoneNum(phoneNum)) {
            $.get("/shortMessage/" + phoneNum, function (result) {
                if (result == "success") {
                    unclickConfirm();
                    $.alert("短信发送成功")
                }
            })
        }
    });

    $("#update").click(function () {
        var phoneNum = $("#phoneNum").val();
        if (checkPhoneNum(phoneNum)) {
            update();
        }
    });

    function update() {
        var valicode = $("#checkCode").val();
        var phoneNum = $("#phoneNum").val();
        $.post("/user/updateTelphone/" + userId, {telphone: phoneNum, valicode: valicode}, function (result) {
            if (result == "success") {
                location.href = "/user/info/" + userId;
                $.alert('手机号码修改成功');
            } else {
                $.alert('手机号码修改失败');
            }
        })
    }

    function checkPhoneNum(str) {
        var myreg = /^((1[0-9]{2})+\d{8})$/;
        var isPhone = myreg.test(str);
        if (!isPhone) {
            $.alert("请输入正确手机号码")
        }
        return isPhone;
    }
});