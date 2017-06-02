/**
 * Created by Administrator on 2017/6/1.
 */
$(function () {
    var selectArea = new MobileSelectArea();
    selectArea.init({trigger:$('#text_area'),value:$('#hd_area').val(),data:'../json/data.json'});
})