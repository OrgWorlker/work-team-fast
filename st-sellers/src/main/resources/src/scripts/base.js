/**
 * Created by Administrator on 2017/6/28.
 */
$(function () {
    $(".nav-tabs li").on("click", function () {
        if($(this).hasClass("active")) return;
        $(this).siblings().each(function () {
            $(this).removeClass("active");
            $("#"+$(this).attr("class")).hide();
        })
        $("#"+$(this).attr("class")).show();
        $(this).addClass("active");
    })
    $(".filter button").on("click", function () {
        $(".filter button.fiter-button").removeClass("fiter-button").addClass("btn-default");
        $(this).removeClass("btn-default").addClass("fiter-button");
        $(".filter input[type=hidden]").val($(this).attr("value"));
    })
})