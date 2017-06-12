$(function () {
    function alertDialog() {
        $.dialog({
            type:'alert',   //对话框的种类（alert-确定； confirm-确定/取消； info）
            titleText:'信息提示11',  //标题
            contentHtml : '弹出对话框的内容部分',  //内容
            buttonText:{ ok : '确定'/*, cancel : '取消'*/ }  //按钮
        });
    }

    $.alert = function (msg, call1) {
        if (!call1) {
            call1 = function () {
                
            }
        }
        $.dialog({
            type:'alert',   //对话框的种类（alert-确定； confirm-确定/取消； info）
            titleText:'提示',  //标题
            contentHtml : msg,  //内容
            buttonText:{ ok : '确定'/*, cancel : '取消'*/ }  //按钮
        },call1());
    }
});