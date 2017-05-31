$(function () {
    $("#login").click(function () {
        var params = {'username': $("#username").val(), 'checknum': $("#checknum").val()};
        $.post("/user/login", params, function (result) {
            if (result.flag) {
                if (result.flag == 2) {
                    location.href = "/user/first-into/" + result.user.id;
                } else {
                    location.href = "/user/user-center/" + result.user.id
                }

            } else {
                alert(result.msg)
            }
        });
    });
});