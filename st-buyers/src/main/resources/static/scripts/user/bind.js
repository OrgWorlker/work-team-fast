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
    });

    $(".content li").on("click", function () {
        var clickedNum = $(".content li.back-green").length;
        if($(this).hasClass("back-green")){
            $(this).removeClass("back-green");
        } else {
            if(clickedNum >= 3) return;
            $(this).addClass("back-green");
        }
    });

  $(".submitButton").click(function(){
    console.log($("form").serialize());

    var flag = false;//true;



    // $("form ul").find("input:text").each(function(index, contt){
    //   if (!checkIsNotNull(contt.value)) {
    //     flag = false;
    //     $.alert("请补全信息！");
    //     return;
    //   }
    // });
    //
    // var checkLength = /^[a-zA-Z0-9]{6,18}$/;
    // var checkQQ = /^[0-9]{4,16}$/;
    // var passWordCheck = $("form ul").find("input:password");
    // if (!checkIsNotNull(passWordCheck[0].value) || !checkIsNotNull(passWordCheck[1].value)) {
    //   $.alert("请补全信息！");
    //   flag = false;
    //   return;
    // } else if (!checkQQ.test($("#qqCodeParam").val())) {
    //   $.alert("QQ输入有误！");
    //   flag = false;
    //   return;
    // } else if (!checkLength.test(passWordCheck[0].value) || !checkLength.test(passWordCheck[1].value)) {
    //   $.alert("密码长度在6到18位，不能满足要求，重新修改！");
    //   flag = false;
    //   return;
    // } else if (passWordCheck[0].value != passWordCheck[1].value) {
    //   $.alert("密码和确认密码不一致，重新修改！");
    //   flag = false;
    //   return;
    // }
    //odifyCity/" + cityName + "/" + userId, f
    //
    if (flag) {
      $.post("/user/updateTbUser/" + userId, $("form").serialize(), function (result) {
        if (result == "success") {
          $.alert("淘宝账号添加成功！");
          location.href = "/user/user-center/" + userId;
        } else {
          $.alert("淘宝账号添加失败！");
        }
      });
    }
  });


});