/**
 * Created by Administrator on 2017/6/28.
 */
$(function () {
    $("input[type]").change(function() {
        var $file = $(this);
        var fileObj = $file[0];
        var windowURL = window.URL || window.webkitURL;
        var dataURL;
        var $img = $(this).siblings("img");

        if(fileObj && fileObj.files && fileObj.files[0]){
            dataURL = windowURL.createObjectURL(fileObj.files[0]);
            $img.attr('src',dataURL);
        }else{
            dataURL = $file.val();
            var imgObj = document.getElementById("preview");
// 两个坑:
// 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
// 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
            imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;

        }
    });
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
    $(".orderRadio button").on("click", function () {
        $(this).parent().find(".btn-danger").removeClass("btn-danger").addClass("btn-default");
        // $(".orderRadio button.btn-danger").removeClass("btn-danger").addClass("btn-default");
        $(this).removeClass("btn-default").addClass("btn-danger");
        $(this).parent().find("input[type=hidden]").val($(this).attr("value"));
    })
    $(".yesNoRadio button").on("click", function () {
        $(this).parent().find(".btn-radio").removeClass("btn-radio").addClass("btn-default");
        // $(".yesNoRadio button.btn-radio").removeClass("btn-radio").addClass("btn-default");
        $(this).removeClass("btn-default").addClass("btn-radio");
        $(this).parent().find("input[type=hidden]").val($(this).attr("value"));
    })
    $(".yesNoRadio2 button").on("click", function () {
        $(this).parent().find(".btn-radio2").removeClass("btn-radio2").addClass("btn-default");
        // $(".yesNoRadio button.btn-radio").removeClass("btn-radio").addClass("btn-default");
        $(this).removeClass("btn-default").addClass("btn-radio2");
        $(this).parent().find("input[type=hidden]").val($(this).attr("value"));
    })
})