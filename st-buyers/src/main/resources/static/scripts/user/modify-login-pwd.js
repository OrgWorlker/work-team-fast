$(function () {
    $("#update").click(function () {
        var oldPwd = $("#oldPwd").val();
        var $newPwd = $("#newPwd");
        var newPwd = $newPwd.val();
        var $pwd = $("#pwd");
        var pwd = $pwd.val();
        if (!newPwd) {
            alert("请输入6到18位的新密码");
            return;
        }
        if (pwd != newPwd) {
            alert("两次新密码不一致");
            $newPwd.val("");
            $pwd.val("");
            return;
        } else if (newPwd.length < 6 || newPwd.length > 18) {
            alert("请输入6到18位的新密码");
            return;
        }
        $.post("/user/update/" + userId + "/0", {oldPwd: oldPwd, newPwd: newPwd}, function (result) {
            if (result == "success") {
                alert("密码修改成功");
                location.href = "/user/user-center/" + userId;
            } else if (result == "error"){
                alert("旧密码错误");
            } else {
                alert("密码修改失败");
            }
        })
    });
});