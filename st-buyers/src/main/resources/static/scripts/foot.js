/**
 * Created by zc.lin on 2017/5/31.
 */
$(function () {
    var currentLi = $("li[class='active']");
    $("#robWelfare").click(function () {
        if (this != currentLi[0]) {
            location.href = "/task/welfare/" + userId;
        }
    });
    $("#myWelfare").click(function () {
        if (this != currentLi[0]) {
            location.href = "/task/welfare/" + userId;
        }
    });
    $("#userCenter").click(function () {
        if (this != currentLi[0]) {
            location.href = "/user/user-center/" + userId;
        }
    });
});