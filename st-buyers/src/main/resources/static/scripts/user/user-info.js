$(function () {
    var trad = $("#trade").val();
    var tradhref = "/user/modifyTradPwd/" + userId;
    $("#tradUrl").click(function () {
        if (trad) {
            $.alert("请联系客服修改密码");
            return;
        }
        location.href = tradhref;
    });

    $(".logout").click(function () {
        $.cookie('username', "", {path: "/"});
        $.cookie('checknum', "", {path: "/"});
        location.href = "/user/logout";
    });

    $("input[type]").change(function () {
        var $file = $(this);
        // $file.closest("form").submit();
        // var promise = $(this).siblings("iframe");
        // console.log(window.frames["hidden_frame"].document);
        // console.log(document.getElementById("hidden_frame").contentDocument.getElementsByTagName("pre"));
        uploadAjax();
        var fileObj = $file[0];
        var windowURL = window.URL || window.webkitURL;
        var dataURL;
        // var $img = $("#preview");
        var $img = $img = $(this).closest(".addImg").find("img");

        if (fileObj && fileObj.files && fileObj.files[0]) {
            dataURL = windowURL.createObjectURL(fileObj.files[0]);
            $img.attr('src', dataURL);
        } else {
            dataURL = $file.val();
            var imgObj = document.getElementById("preview");
// 两个坑:
// 1、在设置filter属性时，元素必须已经存在在DOM树中，动态创建的Node，也需要在设置属性前加入到DOM中，先设置属性在加入，无效；
// 2、src属性需要像下面的方式添加，上面的两种方式添加，无效；
            imgObj.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)";
            imgObj.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = dataURL;

        }
    });

    function uploadAjax() {
        var formdata = new FormData($("#uploadForm")[0]);
        $.ajax({
            url: $("#uploadUrl").val(),
            type: "post",
            data: formdata,    //处理表单数据
            dataType: 'json',
            processData: false,
            contentType: false,
            success: function (data) {
                if (data.code == 200) {
                    $.post("/user/modifyTx/" + data.fileKey + "/" + userId, function (result) {
                        if (result == "success") {
                            $.alert("头像修改成功")
                        }
                    });
                }
                console.log(data);
            },
            error: function (data) {
                console.log(data);
            }
        })
    }

    var selectArea = new MobileSelectArea();
    selectArea.init({
        trigger: $('#text_addr'),
        value: $('#hd_addr').val(),
        data: '/static/json/data.json',
        callback: function (_this, scroller, text, value) {
            var cityName = scroller.toString();
            $.post("/user/modifyCity/" + cityName + "/" + userId, function (result) {
                if (result == "success") {
                    $("li.text_addr .right span").text(cityName);
                } else {
                    $.alert("地区修改失败！");
                }
            });
        }
    });

});