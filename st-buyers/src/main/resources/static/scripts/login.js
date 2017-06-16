/**
 *  系统登陆js
 */
$(function () {
    function login(username, checknum) {
        var params = {'username': username, 'checknum': checknum};
        console.log(params)
        $.post("/user/login", params, function (result) {
            if (result.flag) {
                $.cookie('username', username, {path:"/"});
                $.cookie('checknum', checknum, {path:"/"});
                location.href = "/user/user-center/" + result.user.id;
            } else {
                alert(result.msg)
            }
        });
    }
    var username = $.cookie('username');
    var checknum = $.cookie('checknum');
    $("#username").val(username);
    $("#checknum").val(checknum);
    if (username && checknum) {
        login(username, checknum)
    }
    $("#login").click(function () {
        username = $("#username").val();
        checknum = $("#checknum").val();
        login(username, checknum);
    });
});