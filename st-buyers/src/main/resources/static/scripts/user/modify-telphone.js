$(function () {
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
        var phoneNum = $("#phoneNum").val();
        if (checkPhoneNum(phoneNum)) {
            $.post("",{telphone:phoneNum},function(result){
                if (result == "success") {
                    update();
                }
            })
        }
    });

    function update() {
        var valicode = $("#checkCode").val();
        $.post("",{telphone:phoneNum,valicode:valicode},function(result){
            if (result == "success") {
                update();
            }
        })
    }
});