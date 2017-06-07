/**
 * Created by Administrator on 2017/6/1.
 */
$(function () {
    var selectArea = new MobileSelectArea();
    selectArea.init({trigger:$('#text_area'),value:$('#hd_area').val(),data:'/static/json/data.json'});
    var selectAge = new MobileSelectArea();
    selectAge.init({level: 1,trigger:$('#text_age'),value:$('#hd_age').val(),data:'/static/json/age.json'});
    var selectLevel = new MobileSelectArea();
    selectLevel.init({level: 1,trigger:$('#text_level'),value:$('#hd_level').val(),data:'/static/json/age.json'});
    var selectLabel = new MobileSelectArea();
    selectLabel.init({level: 1,trigger:$('#text_label'),value:$('#hd_label').val(),data:'/static/json/age.json'});
})