$(function(){
    $("#update").click(function(){
        var oldPwd = $("#oldPwd").val();
        var $newPwd = $("#newPwd");
        var newPwd = $newPwd.val();
        var $pwd = $("#pwd");
        var pwd = $pwd.val();
        if (pwd != newPwd){
            alert("两次新密码不一致");
            $newPwd.val("");
            $pwd.val("");
            return;
        }
        $.post("/user/update/"+userId+"/0", {oldPwd:oldPwd, newPwd:newPwd},function (result) {
            if (result == "success") {
                alert("密码修改成功");
            }else{
                alert("密码修改失败");
            }
        })
    });
});