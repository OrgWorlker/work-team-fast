$(function () {
    var time = null;
    $("#receiveOrder").click(function () {
        var text = $(this).text();
        if (text == "停止接单" ) {
            stopOrder();
            return;
        }
        var $active = $(".active");
        if ($active && $active.length > 0) {
            var type = [];
            var value = $(".active").each(function (i, e) {
                type.push( $(e).attr("value"));
            });
            time = setInterval(startOrder, 5000);
            $("#title").text("系统正在为您派送任务中...");
            $(".receiveOrder").text("停止接单");
        } else {
            $.alert("请选择任务类型")
        }

    });

    function startOrder() {
        console.log("1")
        /*$.post("", function(result) {

        });*/
    }0

    function stopOrder() {
        var text = $("#receiveOrder").text();
        if (text == "停止接单" ) {
            if (time){
                clearInterval(time);
            }
            $("#title").text("任务中心");
            $(".receiveOrder").text("开始接单");
        }
    }
    

    $(".text").click(function () {
        if ($(this).hasClass("active")) {
            $(this).removeClass("active")
        } else {
            $(this).addClass("active");
        }
    })
});