$(function () {
    var selectArea = new MobileSelectArea();
    selectArea.init({trigger:$('#text_area'),value:$('#hd_area').val(),data:'/static/json/data.json'});
    var selectAge = new MobileSelectArea();
    selectAge.init({level: 1,trigger:$('#text_age'),value:$('#hd_age').val(),data:'/static/json/bank.json'});

    $(".submitButton").click(function () {
        var flag = true;
        $("input:text").each(function (i, e) {
            if (!$(e).val()) {
                $.alert("请填写完整");
                flag = false;
            }
        });
        if (flag) {
            $.post("/user/bank/save", $("#bankForm").serialize(), function (result) {
                if (result == "success") {
                    history.back();
                } else {
                    $.alert("操作失败")
                }
            });
        }
    })
});