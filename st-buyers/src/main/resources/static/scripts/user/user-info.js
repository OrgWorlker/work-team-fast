$(function () {
    var trad = $("#trade").val();
    var tradhref="/user/modifyTradPwd/"  + userId;
    $("#tradUrl").click(function () {
        if (trad){
            alert("请联系客服修改密码");
            return;
        }
        location.href = tradhref;
    });

});