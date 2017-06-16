/**
 * Created by Administrator on 2017/6/1.
 */
$(function () {
    var selectArea = new MobileSelectArea();
    selectArea.init({trigger:$('#text_area'),value:$('#hd_area').val(),data:'/static/json/data.json'});
    var selectAge = new MobileSelectArea();
    selectAge.init({level: 1,trigger:$('#text_age'),value:$('#hd_age').val(),data:'/static/json/age.json'});
    var selectLevel = new MobileSelectArea();
    selectLevel.init({level: 1,trigger:$('#text_level'),value:$('#hd_level').val(),data:'/static/json/level.json'});
    // var selectLabel = new MobileSelectArea();
    // selectLabel.init({level: 1,trigger:$('#text_label'),value:$('#hd_label').val(),data:'/static/json/age.json'});
    /*$("#tijiao").click(function () {
        $.dialog({
            type:'alert',   //对话框的种类（alert-确定； confirm-确定/取消； info）
            titleText:'信息提示11',  //标题
            contentHtml : '弹出对话框的内容部分',  //内容
            buttonText:{ ok : '确定'/!*, cancel : '取消'*!/ }  //按钮
        });
    })*/
    $("#text_label").on("click", function () {
        setTimeout(function(){
            $(".dialog-mask").show();
            $(".dialog-1").addClass("dialog-content-active");
            $("#text_label").blur();
        },600)
    })
    $(".dialog-1 .right").on("click", function () {
        var $selectLab = $(".content li.back-green");
        var $selectLabValue = "";
        if($selectLab.length > 0){
            $.each($selectLab, function () {
                if($selectLabValue == ""){
                    $selectLabValue = $(this).text();
                } else {
                    $selectLabValue = $selectLabValue + "," + $(this).text();
                }
            })
        }
        $("#text_label").val($selectLabValue);
        $(".dialog-1").removeClass("dialog-content-active");
        $(".dialog-mask").hide();
    })

    $(".content li").on("click", function () {
        var clickedNum = $(".content li.back-green").length;
        if($(this).hasClass("back-green")){
            $(this).removeClass("back-green");
        } else {
            if(clickedNum >= 3) return;
            $(this).addClass("back-green");
        }
    })
})