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
})