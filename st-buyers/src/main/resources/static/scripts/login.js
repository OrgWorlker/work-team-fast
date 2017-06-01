/**
 *  系统登陆js
 */
$(function () {
    function login(username, checknum) {
        var params = {'username': username, 'checknum': checknum};
        $.post("/user/login", params, function (result) {
            if (result.flag) {
                $.cookie('username', username);
                $.cookie('checknum', checknum);
                location.href = "/user/user-center/" + result.user.id;
            } else {
                alert(result.msg)
            }
        });
    }
    var username = $.cookie('username');
    var checknum = $.cookie('checknum');
    if (username && checknum) {
        login(username, checknum)
    }
    $("#login").click(function () {
        username = $("#username").val();
        checknum = $("#checknum").val();
        login(username, checknum);
    });
    console.log(username)
    console.log(checknum)
});