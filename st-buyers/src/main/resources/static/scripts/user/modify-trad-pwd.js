$(function () {
    $("#update").click(function () {
        var $newPwd = $("#newPwd");
        var newPwd = $newPwd.val();
        var $pwd = $("#pwd");
        var pwd = $pwd.val();
        if (!newPwd) {
            $.alert("请输入6到18位的密码");
            return;
        }
        if (newPwd.length < 6 || newPwd.length > 18) {
            $.alert("请输入6到18位的密码");
            return;
        }
        $.post("/user/tradPwd/" + userId + "/1", { newPwd: newPwd }, function (result) {
            if (result == "success") {
                $.alert("交易密码设置成功");
                location.href = "/login";
            } else {
                $.alert("密码设置失败");
            }
        })
    });
});