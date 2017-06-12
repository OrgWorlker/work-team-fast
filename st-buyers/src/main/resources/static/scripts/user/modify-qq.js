$(function () {
    $(".confirm").click(function () {
        var qq = $("#qq").val();
        $.post("/user/modifyQQ/" + qq + "/" + userId, function (result) {
            if (result == "success") {
                // $.alert("QQ号码修改成功");
                location.href = "/user/info/" + userId;
            }
        })
    });
});