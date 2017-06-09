/**
 * Created by Administrator on 2017/6/1.
 */
$(function () {
    var selectArea = new MobileSelectArea();
    selectArea.init({trigger:$('#text_area'),value:$('#hd_area').val(),data:'../json/data.json'});
    var selectAge = new MobileSelectArea();
    selectAge.init({level: 1,trigger:$('#text_age'),value:$('#hd_age').val(),data:'../json/age.json'});
    var selectLevel = new MobileSelectArea();
    selectLevel.init({level: 1,trigger:$('#text_level'),value:$('#hd_level').val(),data:'../json/age.json'});
    var selectLabel = new MobileSelectArea();
    selectLabel.init({level: 1,trigger:$('#text_label'),value:$('#hd_label').val(),data:'../json/age.json'});

    alertDialog();
    function alertDialog() {
        $.dialog({
            type:'alert',   //对话框的种类（alert-确定； confirm-确定/取消； info）
            titleText:'信息提示11',  //标题
            contentHtml : '弹出对话框的内容部分',  //内容
            buttonText:{ ok : '确定'/*, cancel : '取消'*/ }  //按钮
        });
    }
})